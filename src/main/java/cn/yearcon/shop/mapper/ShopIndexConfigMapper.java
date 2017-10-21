/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.yearcon.shop.mapper;

import cn.yearcon.shop.entity.ShopCategory;
import cn.yearcon.shop.entity.ShopIndexConfig;
import cn.yearcon.shop.entity.ShopProduct;
import cn.yearcon.shop.mapper.common.CrudDao;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 积分商城首页配置DAO接口
 * @author itguang
 * @version 2017-10-19
 */

public interface ShopIndexConfigMapper extends CrudDao<ShopIndexConfig> {
    List<ShopIndexConfig> getByType(Integer type);
    List<ShopIndexConfig> getIndexImage();

    /**
     * 通过Category的id,查找首页分类信息,默认6条数据
     * @param categoryId
     * @return
     */
    @Select("SELECT\n" +
            "\tp.category_id AS \"categoryId\",\n" +
            "\tp.id,\n" +
            "\tp. NAME,\n" +
            "\tp.points,\n" +
            "\tp.sales,\n" +
            "\tp.picture_url_default As \"pictureUrlDefault\"\n" +
            "FROM\n" +
            "\tshop_product p\n" +
            "WHERE\n" +
            "\tp.category_id = #{categoryId}\n" +
            "ORDER BY p.sales DESC\n" +
            "LIMIT 6;")
    List<ShopProduct> findIndexCategoryByCategoryId(String categoryId);

    /**
     * 查询所有分类信息
     * @return
     */
    @Select("SELECT\n" +
            "\ta.id AS \"id\",\n" +
            "\ta.category_name AS \"categoryName\",\n" +
            "\ta.category_picture_url AS \"categoryPictureUrl\"\n" +
            "FROM\n" +
            "\tshop_category a")
    List<ShopCategory> findAllCategory();


	
}