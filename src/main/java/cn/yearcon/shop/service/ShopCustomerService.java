package cn.yearcon.shop.service;

import cn.yearcon.shop.entity.ShopCustomer;
import cn.yearcon.shop.mapper.ShopCustomerMapper;
import cn.yearcon.shop.service.common.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ShopCustomer 业务逻辑层
 *
 * @author itguang
 * @create 2017-10-20 14:21
 **/
@Service
@Transactional
public class ShopCustomerService extends CrudService<ShopCustomerMapper,ShopCustomer> {

    @Autowired
    private ShopCustomerMapper shopCustomerMapper;

    /**
     * 通过openid查找顾客表唯一值
     * @param openid
     * @return
     */
    public ShopCustomer findUniqueByOPenid(String openid){
        ShopCustomer shopCustomer = shopCustomerMapper.findUniqueByProperty("openid", openid);
        return  shopCustomer;
    }

    /**
     * 根据openid设置支付密码
     * @param payPassword 支付密码
     * @param openid openid
     * @return
     */
    public Integer updatePayPasswordByOpenid(String payPassword, String openid){
       Integer i=  shopCustomerMapper.updatePayPasswordByOpenid(payPassword, openid);
       return i;
    }


}
