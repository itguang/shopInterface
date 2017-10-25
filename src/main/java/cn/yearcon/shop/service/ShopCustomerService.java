package cn.yearcon.shop.service;

import cn.yearcon.shop.entity.ShopCustomer;
import cn.yearcon.shop.mapper.ShopCustomerMapper;
import cn.yearcon.shop.service.common.CrudService;
import cn.yearcon.shop.utils.IdGen;
import org.apache.ibatis.annotations.Insert;
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
public class ShopCustomerService extends CrudService<ShopCustomerMapper, ShopCustomer> {

    @Autowired
    private ShopCustomerMapper shopCustomerMapper;

    /**
     * 通过openid查找顾客表唯一值
     *
     * @param openid
     * @return
     */
    public ShopCustomer findUniqueByOPenid(String openid) {
        ShopCustomer shopCustomer = shopCustomerMapper.findUniqueByProperty("openid", openid);
        return shopCustomer;
    }

    /**
     * 根据openid设置支付密码
     *
     * @param payPassword 支付密码
     * @param openid      openid
     * @return
     */
    public Integer updatePayPasswordByOpenid(String payPassword, String openid) {
        Integer i = shopCustomerMapper.updatePayPasswordByOpenid(payPassword, openid);
        return i;
    }

    /**
     * 保存openid到数据库Customer表,如果数据库表中已有则什么都不做
     * @param openid
     * @return
     */
    public Integer saveOPenid(String openid) {

        ShopCustomer unique = shopCustomerMapper.findUniqueByProperty("openid", openid);
        if (null==unique){
            ShopCustomer shopCustomer = new ShopCustomer();
            String uuid = IdGen.uuid();
            shopCustomer.setId(uuid);
            shopCustomer.setOpenid(openid);
            Integer i = shopCustomerMapper.insert(shopCustomer);
            return i;

        }
        return  1;



    }


}
