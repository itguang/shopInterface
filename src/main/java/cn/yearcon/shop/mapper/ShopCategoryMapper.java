/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.yearcon.shop.mapper;


import cn.yearcon.shop.entity.ShopCategory;
import cn.yearcon.shop.entity.ShopProduct;
import cn.yearcon.shop.mapper.common.CrudDao;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 商品分类DAO接口
 * @author itguang
 * @version 2017-10-20
 */
public interface ShopCategoryMapper extends CrudDao<ShopCategory> {


    /**
     * 查询所有分类信息
     * @return
     */
    @Select("SELECT\n" +
            "\ta.id AS id,\n" +
            "\ta.category_name AS categoryName,\n" +
            "\ta.category_picture_url AS categoryPictureUrl\n" +
            "FROM\n" +
            "\tshop_category a\n" +
            "ORDER BY\n" +
            "\ta.sort")
    List<ShopCategory> getAllShopCategory();

    /**
     * 通过分类ID获取所有商品信息(按销量从高到底排序),注意,mysql分页查询 limit 从0开始
     * @return
     */
    @Select("SELECT\n" +
            "\ta.id AS id,\n" +
            "\ta.`name` AS `name`,\n" +
            "\ta.description AS description,\n" +
            "\ta.points AS points,\n" +
            "\ta.sales AS sales,\n" +
            "\ta.visits AS \"visits\",\n" +
            "\ta.picture_url_default AS pictureUrlDefault\n" +
            "FROM\n" +
            "\tshop_product a\n" +
            "WHERE\n" +
            "\ta.category_id = #{id}\n" +
            "ORDER BY points\n" +
            "LIMIT #{startIndex},#{pageSize};")
    List<ShopProduct> getShopProductByCategoryId(@Param("id") String id, @Param("startIndex") int startIndex,@Param("pageSize") int pageSize);

    /**
     * 查询某个分类下所有商品总数
     * @param id
     * @return
     */
    @Select("SELECT\n" +
            "COUNT(*)\n" +
            "FROM\n" +
            "\tshop_product a\n" +
            "WHERE\n" +
            "\tcategory_id = #{id}")
    int findCountByCategoryId(String id);

	
}