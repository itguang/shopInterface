package cn.yearcon.shop.controller;

import cn.yearcon.shop.service.ShopCustomerService;
import cn.yearcon.shop.utils.ShopResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 顾客Controller
 *
 * @author itguang
 * @create 2017-10-23 14:29
 **/
@RestController
@RequestMapping("shop/")
public class ShopCustomerController {
    @Autowired
    private ShopCustomerService shopCustomerService;

    /**
     * 根据openid设置支付密码
     * @param payPassword 支付密码
     * @param openid openid
     * @return
     */
    @RequestMapping(value = "customer/update-password")
    public ShopResult updatePayPasswordByOpenid(@RequestParam("payPassword") String payPassword, @RequestParam("openid") String openid) {
        ShopResult result = null;
        try {
           Integer i = shopCustomerService.updatePayPasswordByOpenid(payPassword, openid);

           if(1==i){
               result = new ShopResult(1, "OK");
           }else {
               result = new ShopResult(0, "设置密码失败");
           }
        } catch (Exception e) {
            result = new ShopResult(0, "服务器忙");
            e.printStackTrace();
        }
        return result;
    }


}
