package cn.yearcon.shop.service;

import cn.yearcon.shop.entity.ShopCustomer;
import cn.yearcon.shop.entity.ShopOrder;
import cn.yearcon.shop.entity.ShopProduct;
import cn.yearcon.shop.entity.ShopShippingAddress;
import cn.yearcon.shop.mapper.ShopOrderMapper;
import cn.yearcon.shop.pojo.OrderBean;
import cn.yearcon.shop.service.common.CrudService;
import cn.yearcon.shop.utils.IdGen;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ShopOrder 业务逻辑层
 *
 * @author itguang
 * @create 2017-10-20 14:23
 **/
@Service
@Transactional
public class ShopOrderService extends CrudService<ShopOrderMapper,ShopOrder> {

    @Autowired
    private ShopOrderMapper shopOrderMapper;

    @Autowired
    private ShopShippingAddressService shopShippingAddressService;
    @Autowired
    private ShopProductService shopProductService;
    @Autowired
    private ShopCustomerService shopCustomerService;
    @Autowired
    private ShopProductSpecificationService shopProductSpecificationService;

    @Autowired
    private PointService pointService;

    @Autowired
    private ObjectMapper objectMapper;







    /**
     *根据客户端提交的数据生成订单
     * @return 订单id
     */
    public String saveOrder(OrderBean orderBean) {
        String addressId = orderBean.getAddressId();
        String productId = orderBean.getProductId();
        String productSpecificationId = orderBean.getProductSpecificationId();
        int productAmount = orderBean.getProductAmount();
        String invoiceRequest = orderBean.getInvoiceRequest();
        String remarkBuyer = orderBean.getRemarkBuyer();
        String invoiceTitle = orderBean.getInvoiceTitle();

        ShopShippingAddress shopShippingAddress = shopShippingAddressService.get(addressId);
        ShopProduct shopProduct = shopProductService.findShopProductByid(productId);

        ShopOrder order = new ShopOrder();
        //生成订单id
        String uuid = IdGen.uuid();
        order.setId(uuid);
        //生成订单号
        Date date = new Date();
        order.setOrderNumber(String.valueOf(date.getTime()));

        //生成运单号(管理员录入)

        //生成交易号(和订单号一样即可)
        order.setTransactionNo(order.getOrderNumber());
        //设置顾客id
        order.setCustomerId(shopShippingAddress.getCustomerId());

        //设置产品id
        order.setProductId(productId);
        //商品编码(产品id)
        order.setProductCode(productId);
        //设置产品规格id
        order.setProductSpecificationId(productSpecificationId);

        //设置商品名称
        order.setProductName(shopProduct.getName());
        //设置商品简介
        order.setProductSimplename(shopProduct.getDescription());
        //设置商品数量
        order.setProductAmount(productAmount);
        //收货人姓名
        order.setConsignee(shopShippingAddress.getName());
        //收件人手机
        order.setConsigneeMobile(shopShippingAddress.getMobile());
        //应付积分 (需要根据商品规格id来获取其积分值:商品数量*商品所需积分)
        int needIntegration = shopProductSpecificationService.get(productSpecificationId).getNeedIntegration();
        order.setAmountPayable(productAmount*needIntegration);
        //实付积分
        order.setAmountPaid(productAmount*shopProduct.getPoints());
        //发票抬头
        order.setInvoiceTitle(invoiceTitle);

        //发票要求
        order.setInvoiceRequest(invoiceRequest);
        //配送方式
        order.setDeliveryType("快递免邮");
        //remarkBuyer
        order.setRemarkBuyer(remarkBuyer);

        //省
        order.setProvince(shopShippingAddress.getProvince());
        //市
        order.setCity(shopShippingAddress.getCity());
        //区
        order.setArea(shopShippingAddress.getArea());
        //收获人详细地址(注:)
        order.setShoppingAddressId(shopShippingAddress.getCompleteAddress());
        //邮编
        order.setConsigneeCode(shopShippingAddress.getPostcode());


        //生成订单
        int i = shopOrderMapper.insert(order);
        if(i==1){
            return order.getId();
        }


        return null;
    }


    /**
     * 根据订单id和支付密码确认订单状态
     * @param orderId
     * @param payPassword
     * @return 1:支付成功 , 2: 积分不足 ,3:支付密码错误,4:扣除积分失败
     */
        public Integer  pay(String orderId,String payPassword){

            //通过 orderId 获取订单信息
            ShopOrder shopOrder = shopOrderMapper.get(orderId);
            if (shopOrder==null){
                return 5;//该订单不存在

            }
            String customerId = shopOrder.getCustomerId();

            //判断支付密码是否正确
            ShopCustomer shopCustomer = shopCustomerService.get(customerId);
            String password=getPayPassword( shopCustomer.getOpenid());


            //支付密码正确
            if(payPassword.equals(password)){


                //1,获取订单应付积分值
                int amountPaid = shopOrder.getAmountPaid();
                //2,获取openid
                String openid = shopCustomer.getOpenid();
                //3,根据openid查询用户积分是否足够
                int point =getPointByOpenid(openid);
                //积分足够
                if (amountPaid<=point){
                    //4,如果足够,减去相应积分,修改订单状态
                    String paid ="-"+String.valueOf(amountPaid);
                    int code = updatePoint(openid,paid, "订单id=" + shopOrder.getId());
                    //扣除积分成功
                    if (code==0){
                        //5,修改订单支付状态
                        shopOrder.setPayStatus(1);
                        int i = this.update(shopOrder);
                        if(1==i){
                            //6,商品销量+1
                            shopProductService.incrementShopProductSales(shopOrder.getProductId());
                        }
                        //7,支付成功
                        return i;
                    }else {
                        //扣除积分失败
                        return 4;
                    }
                }else {
                    //积分不足,返回状态 2,供controller调用
                    return 2;
                }
            }else {
                //支付密码错误
                return 3;
            }

        }


    /**
     * 通过openidid 查询该会员还有多少积分
     * @param openid
     * @return 会员积分
     */
    private Integer getPointByOpenid(String openid){

        String quryPoint = pointService.quryPoint(openid);
        try {
            Map map = objectMapper.readValue(quryPoint, Map.class);
            Integer code = (Integer)map.get("code");
            if(code==0){
                Map map1 = (Map) map.get("jsondata");
                String points= (String)map1.get("points");
                return Integer.parseInt(points);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

        }

    /**
     * 积分增减
     * @param openid
     * @param ChangePoint 积分值.负为减,正为增
     * @param Remark 备注:订单id
     * @return 0:成功.1:失败
     */
        private Integer updatePoint(String openid, String ChangePoint, String Remark){
            String body = pointService.updatePoint(openid,ChangePoint,Remark);
            try {
                Map map = objectMapper.readValue(body, Map.class);
                Integer code = (Integer) map.get("code");

                System.out.println("code="+code);
                return code;
            } catch (IOException e) {
                e.printStackTrace();
            }



        return null;

        }

    /**
     * 获取会员名支付密码
     * @param openid
     * @return
     */
    private String getPayPassword(String openid){
            String body = pointService.QueryVipByOpenid(openid);

            try {
                Map map = objectMapper.readValue(body, Map.class);
                Integer code = (Integer) map.get("code");
                System.out.println("code="+code);
                if (code==0){
                    Map jsondata = (Map) map.get("jsondata");
                    String password = (String) jsondata.get("password");
                    System.out.println("password="+password);
                    return password;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }



            return null;
        }


    /**
     * 通过openid查找已付款订单
     * @param openid
     * @return
     */
        public List<ShopOrder> findOrderListPaid(String openid){
            ShopCustomer customer = shopCustomerService.findUniqueByOPenid(openid);
            String cusTomerID = customer.getId();

            List<ShopOrder> list = shopOrderMapper.queryPaidOrderListByCustomerId(cusTomerID);
            return list;


        }

    /**
     * 查找最近一笔订单的快递信息
     * @param openid
     * @return
     */
    public ShopOrder queryLastOrderByCustomerId(String openid){
        ShopCustomer shopCustomer = shopCustomerService.findUniqueByOPenid(openid);

        ShopOrder shopOrder = shopOrderMapper.queryLastOrderByCustomerId(shopCustomer.getId());
        return shopOrder;
    }



}
