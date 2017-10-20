/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.yearcon.shop.mapper;


import cn.yearcon.shop.entity.ShopProduct;
import cn.yearcon.shop.mapper.common.CrudDao;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 商品信息DAO接口
 * @author itguang
 * @version 2017-10-20
 */

public interface ShopProductMapper extends CrudDao<ShopProduct> {

    @Select("SELECT\n" +
            "\t*\n" +
            "FROM\n" +
            "\tshop_product a\n" +
            "WHERE\n" +
            "\tis_new = 1\n" +
            "ORDER BY\n" +
            "\tsort_no\n" +
            "LIMIT 6;")
    List<ShopProduct> findIsNew();

	
}