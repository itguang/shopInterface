package cn.yearcon.shop.service;

import cn.yearcon.shop.entity.ShopCustomer;
import cn.yearcon.shop.entity.ShopOrder;
import cn.yearcon.shop.entity.ShopProduct;
import cn.yearcon.shop.entity.ShopShippingAddress;
import cn.yearcon.shop.mapper.ShopOrderMapper;
import cn.yearcon.shop.pojo.OrderBean;
import cn.yearcon.shop.service.common.CrudService;
import cn.yearcon.shop.utils.IdGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;
import java.util.Date;

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
        //应付积分 (商品数量*商品所需积分)
        order.setAmountPayable(productAmount*shopProduct.getPoints());
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
     * @return
     */
        public Integer  pay(String orderId,String payPassword){

            //通过 orderId 获取订单信息
            ShopOrder shopOrder = shopOrderMapper.get(orderId);
            String customerId = shopOrder.getCustomerId();

            //判断支付密码是否正确
            ShopCustomer shopCustomer = shopCustomerService.get(customerId);
            String password = shopCustomer.getPayPassword();
            if(payPassword.equals(password)){
                //修改订单支付状态
                shopOrder.setPayStatus(1);
            }
            int i = this.update(shopOrder);
            if(1==i){
                //商品销量+1
                shopProductService.incrementShopProductSales(shopOrder.getProductId());
            }


            return i;
        }





}
