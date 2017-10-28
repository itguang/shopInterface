package cn.yearcon.shop.service;

import cn.yearcon.shop.entity.ShopCustomer;
import cn.yearcon.shop.entity.ShopOrder;
import cn.yearcon.shop.mapper.ShopOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 我的(个人中心) 业务逻辑层
 *
 * @author itguang
 * @create 2017-10-28 14:00
 **/
@Service
public class ShopMyService {

    @Autowired
    private ShopOrderMapper shopOrderMapper;
    @Autowired
    private ShopCustomerService shopCustomerService;


    /**
     * 通过openid查找未付款订单列表
     * @param openid
     * @return
     */
    public List<ShopOrder> queryNoPayOrderListByOpenid(String openid){
        ShopCustomer shopCustomer = shopCustomerService.findUniqueByOPenid(openid);
        if (shopCustomer!=null){
            List<ShopOrder> list =  shopOrderMapper.queryNoPayOrderListByCustomerId(shopCustomer.getId());
            return list;
        }
        return null;
    }

    /**
     * 通过openid查找已付款订单列表
     * @param openid
     * @return
     */
    public List<ShopOrder> queryPaidOrderListByCustomerId(String openid){
        ShopCustomer shopCustomer = shopCustomerService.findUniqueByOPenid(openid);
        if (shopCustomer!=null){
            List<ShopOrder> list =  shopOrderMapper.queryPaidOrderListByCustomerId(shopCustomer.getId());
            return list;
        }
        return null;
    }







}
