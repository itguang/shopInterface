/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.yearcon.shop.mapper;


import cn.yearcon.shop.entity.ShopCategory;
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
    /**
     * 在商品表中查找新品
     * @param size 查找几条新品数据
     * @return  List<ShopProduct>
     */

    @Select("SELECT\n" +
            "\ta.id AS \"id\",\n" +
            "\ta. NAME AS \"name\",\n" +
            "\ta.points AS \"points\",\n" +
            "\ta.sales AS \"sales\",\n" +
            "\ta.picture_url_default AS \"pictureUrlDefault\"\n" +
            "FROM\n" +
            "\tshop_product a\n" +
            "WHERE\n" +
            "\tis_new = 1\n" +
            "ORDER BY\n" +
            "\tsort_no\n" +
            "LIMIT 6;")
    List<ShopProduct> findIsNew(Integer size);

    /**
     * 通过商品id查找商品信息
     * @param id
     * @return
     */
    @Select("SELECT\n" +
            "\ta.id AS \"id\",\n" +
            "\t\ta.product_no AS \"productNo\",\n" +
            "\t\ta.brand AS \"brand\",\n" +
            "\t\ta.name AS \"name\",\n" +
            "\t\ta.market_date AS \"marketDate\",\n" +
            "\t\ta.category_id AS \"categoryId\",\n" +
            "\t\ta.visits AS \"visits\",\n" +
            "\t\ta.product_type AS \"productType\",\n" +
            "\t\ta.occasion AS \"occasion\",\n" +
            "\t\ta.size AS \"size\",\n" +
            "\t\ta.style AS \"style\",\n" +
            "\t\ta.function AS \"function\",\n" +
            "\t\ta.target AS \"target\",\n" +
            "\t\ta.vamp_texture AS \"vampTexture\",\n" +
            "\t\ta.low_shoes_name AS \"lowShoesName\",\n" +
            "\t\ta.insole_texture AS \"insoleTexture\",\n" +
            "\t\ta.sort_no AS \"sortNo\",\n" +
            "\t\ta.keyword AS \"keyword\",\n" +
            "\t\ta.summary AS \"summary\",\n" +
            "\t\ta.stores AS \"stores\",\n" +
            "\t\ta.price AS \"price\",\n" +
            "\t\ta.points AS \"points\",\n" +
            "\t\ta.description AS \"description\",\n" +
            "\t\ta.details AS \"details\",\n" +
            "\t\ta.sales AS \"sales\",\n" +
            "\t\ta.residue AS \"residue\",\n" +
            "\t\ta.is_new AS \"isNew\",\n" +
            "\t\ta.is_hot AS \"isHot\",\n" +
            "\t\ta.is_alive AS \"isAlive\",\n" +
            "\t\ta.picture_url_default AS \"pictureUrlDefault\",\n" +
            "\t\ta.picture_url2 AS \"pictureUrl2\",\n" +
            "\t\ta.picture_url3 AS \"pictureUrl3\",\n" +
            "\t\ta.picture_url4 AS \"pictureUrl4\",\n" +
            "\t\ta.picture_url5 AS \"pictureUrl5\",\n" +
            "\t\ta.picture_url6 AS \"pictureUrl6\",\n" +
            "\t\ta.add_time AS \"addTime\"\n" +
            "FROM\n" +
            "\tshop_product a\n" +
            "WHERE\n" +
            "\ta.id = #{id};")
    ShopProduct findShopProductByid(String id);



	
}