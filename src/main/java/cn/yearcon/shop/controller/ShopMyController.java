package cn.yearcon.shop.controller;

import cn.yearcon.shop.entity.ShopOrder;
import cn.yearcon.shop.service.PointService;
import cn.yearcon.shop.service.ShopMyService;
import cn.yearcon.shop.utils.ShopResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 我的(个人中心)
 *
 * @author itguang
 * @create 2017-10-28 13:59
 **/
@RestController
@RequestMapping(value = "shop")
public class ShopMyController {

    @Autowired
    private ShopMyService shopMyService;

    @Autowired
    private PointService pointService;

    /**
     * 通过openid查找未付款订单
     * @param openid
     * @return
     */
    @RequestMapping(value = "my/order/no-pay/{openid}")
    public ShopResult queryNoPayOrderListByOpenid(@PathVariable(value = "openid") String openid) {
        ShopResult result = null;
        try {
            List<ShopOrder> list = shopMyService.queryNoPayOrderListByOpenid(openid);
            result = new ShopResult(list);
        } catch (Exception e) {
            result = new ShopResult(0,"服务器忙");
            e.printStackTrace();
        }


        return result;
    }/**
     * 通过openid查找已付款订单
     * @param openid
     * @return
     */
    @RequestMapping(value = "my/order/paid/{openid}")
    public ShopResult queryPaidOrderListByOpenid(@PathVariable(value = "openid") String openid) {
        ShopResult result = null;
        try {
            List<ShopOrder> list = shopMyService.queryPaidOrderListByCustomerId(openid);
            result = new ShopResult(list);
        } catch (Exception e) {
            result = new ShopResult(0,"服务器忙");
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 通过openid查询会员信息
     * @param openid
     * @return
     */
    @RequestMapping(value = "my/vip-info/{openid}")
    public String getVipInfo(@PathVariable("openid") String openid){
        String body = pointService.QueryVipByOpenid(openid);
        return body ;
    }

    /**
     * 通过openid查询会员积分
     * @param openid
     * @return
     */
    @RequestMapping(value = "my/vip-point/{openid}")
    public String getVipPoint(@PathVariable("openid") String openid){
        String body = pointService.quryPoint(openid);

        return body;
    }




}
