/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.yearcon.shop.mapper;


import cn.yearcon.shop.entity.ShopCustomer;
import cn.yearcon.shop.mapper.common.CrudDao;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 顾客信息DAO接口
 * @author itguang
 * @version 2017-10-20
 */
public interface ShopCustomerMapper extends CrudDao<ShopCustomer> {


    /**
     * 根据openid设置支付密码
     * @param payPassword 支付密码
     * @param openid openid
     * @return
     */
    @Select("UPDATE shop_customer\n" +
            "SET pay_password = #{payPassword}\n" +
            "WHERE\n" +
            "\topenid = #{openid}")
    void updatePayPasswordByOpenid(@Param("payPassword") String payPassword, @Param("openid") String openid);

	
}