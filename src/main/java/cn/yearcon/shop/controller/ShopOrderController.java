package cn.yearcon.shop.controller;

import cn.yearcon.shop.entity.ShopShippingAddress;
import cn.yearcon.shop.pojo.OrderBean;
import cn.yearcon.shop.service.ShopOrderService;
import cn.yearcon.shop.service.ShopShippingAddressService;
import cn.yearcon.shop.utils.ShopResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * 订单Controller
 *
 * @author itguang
 * @create 2017-10-22 11:29
 **/
@RestController
@RequestMapping(value = "shop/")
public class ShopOrderController {
    @Autowired
    private ShopShippingAddressService shopShippingAddressService;
    @Autowired
    private ShopOrderService shopOrderService;

    /**
     *生成订单
     * @return
     */
    @RequestMapping(value = "order/save-order")
    public ShopResult saveOrder(OrderBean orderBean){
        ShopResult result = null;
        try {
            String orderId =   shopOrderService.saveOrder(orderBean);
            HashMap<String, String> map = new HashMap<>();
            map.put("orderId",orderId);
            result = new ShopResult(map);
        } catch (Exception e) {
            result = new ShopResult(0,"服务器忙");
            e.printStackTrace();
        }

        return result;
    }




    /**
     * 通过openid获取该用户的收货地址列表
     * @param openid
     * @return
     */
    @RequestMapping(value = "address/{openid}")
    public ShopResult getShopShippingAddressesByOpenid(@PathVariable("openid") String openid){
        ShopResult result=null;
        try {
            List<ShopShippingAddress> list = shopShippingAddressService.getShopShippingAddressesByOpenid(openid);
            result = new ShopResult(list);
        } catch (Exception e) {
            result = new ShopResult(0,"服务器忙");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 保存客户端提交的收货人地址数据
     */
    @RequestMapping(value = "address/save")
    public ShopResult saveShopShippingAddress(ShopShippingAddress shippingAddress,HttpServletRequest request){

        String openid = (String) request.getSession().getAttribute("openid");

        ShopResult result=null;

        try {
            Integer i = shopShippingAddressService.saveShopShippingAddress(shippingAddress);
            if (i==1){
                result = new ShopResult(1,"OK");
            }else {
                result = new ShopResult(0,"添加地址失败");
            }
        } catch (Exception e) {
            result = new ShopResult(0,"服务器忙");
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 更新客户端提交的收货人地址数据
     * @param shippingAddress
     * @return
     */
    @RequestMapping(value = "address/update")
    public ShopResult updateShopShippingAddress(ShopShippingAddress shippingAddress, HttpServletRequest request){

        ShopResult result = null;
        try {
            Integer i = shopShippingAddressService.updateShopShippingAddress(shippingAddress);
            if(i==1){
                result = new ShopResult(1,"OK");
            }else {
                result = new ShopResult(0,"修改地址失败");
            }
        } catch (Exception e) {
            result = new ShopResult(0,"服务器忙");
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 删除收货人地址数据
     * @param id 收货人地址id
     * @return
     */
    @RequestMapping(value = "address/delete/{id}")
    public ShopResult deleteShopShippingAddress(@PathVariable("id") String id){

        ShopResult result = null;
        try {
            Integer i = shopShippingAddressService.deleteShopShippingAddressById(id);
            if(i==1){
                result = new ShopResult(1,"OK");
            }else {
                result = new ShopResult(0,"删除失败");
            }
        } catch (Exception e) {
            result = new ShopResult(0,"服务器忙");
            e.printStackTrace();
        }


        return result;
    }

    /**
     *根据订单id和支付密码确认订单状态
     * @param orderId
     * @param payPassword
     * @return
     */
    @RequestMapping("order/pay")
    public ShopResult pay(@RequestParam("orderId") String orderId,@RequestParam("payPassword") String payPassword){
        ShopResult result = null;

        try {
            Integer code = shopOrderService.pay(orderId,payPassword);
            if(code==1){
                result = new ShopResult(1,"OK");

            }
            if (code==2){
                result = new ShopResult(0,"对不起,您的积分不足!");

            }
            if(code==3){
                result = new ShopResult(0,"支付密码错误!");
            }
            if(code==4){
                result = new ShopResult(0,"扣除积分失败!");
            }
            if (code==5){
                result = new ShopResult(0,"支付失败,该订单不存在");
            }
        } catch (Exception e) {
            result = new ShopResult(0,"服务器忙");
            e.printStackTrace();
        }

        return result;

    }

}
