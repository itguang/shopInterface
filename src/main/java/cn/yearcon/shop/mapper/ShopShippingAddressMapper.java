/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.yearcon.shop.mapper;


import cn.yearcon.shop.entity.ShopShippingAddress;
import cn.yearcon.shop.mapper.common.CrudDao;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 收货地址DAO接口
 * @author itguang
 * @version 2017-10-20
 */

public interface ShopShippingAddressMapper extends CrudDao<ShopShippingAddress> {


    /**
     * 通过openid获取该用户的收货地址列表
     * @param openid
     * @return
     */
    @Select("SELECT\n" +
            "\ta.id AS 'id',\n" +
            "\ta.customer_id AS 'customerId',\n" +
            "\ta.province AS 'province',\n" +
            "\ta.city AS 'city',\n" +
            "\ta.area AS 'area',\n" +
            "\ta.complete_address AS 'completeAddress',\n" +
            "\ta.postcode AS 'postcode',\n" +
            "\ta. NAME AS 'name',\n" +
            "\ta.mobile AS 'mobile',\n" +
            "\ta.is_default AS 'isDefault'\n" +
            "FROM\n" +
            "\tshop_customer c,\n" +
            "\tshop_shipping_address a\n" +
            "WHERE\n" +
            "\ta.customer_id = c.id\n" +
            "AND c.openid = #{openid};")
    List<ShopShippingAddress> getShopShippingAddressesByOpenid(@Param("openid") String openid);







	
}