/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.yearcon.shop.mapper;


import cn.yearcon.shop.entity.ShopProductSpecification;
import cn.yearcon.shop.mapper.common.CrudDao;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 产品规格表DAO接口
 * @author itguang
 * @version 2017-10-20
 */

public interface ShopProductSpecificationMapper extends CrudDao<ShopProductSpecification> {


    /**
     * 通过商品id查询商品规格参数
     * @param id 商品id
     * @return
     */
    @Select("SELECT\n" +
            "\t  a.id AS 'id',\n" +
            "\t\ta.product_id AS 'productId',\n" +
            "\t\ta.name AS 'name',\n" +
            "    a.color AS 'color',\n" +
            "\t\ta.inventory AS 'inventory',\n" +
            "\t\ta.need_integration AS 'needIntegration'\n" +
            "\t\t\n" +
            "FROM\n" +
            "\tshop_product_specification a\n" +
            "WHERE\n" +
            "\ta.product_id = #{id}")
    List<ShopProductSpecification> getShopProductSpecificationById(@Param("id") String id);
	
}