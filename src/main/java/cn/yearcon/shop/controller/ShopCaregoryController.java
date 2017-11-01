package cn.yearcon.shop.controller;

import cn.yearcon.shop.entity.ShopCategory;
import cn.yearcon.shop.entity.ShopProduct;
import cn.yearcon.shop.service.ShopCategoryService;
import cn.yearcon.shop.utils.RedisUtil;
import cn.yearcon.shop.utils.ShopResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品分类
 *
 * @author itguang
 * @create 2017-10-21 13:28
 **/
@RestController
@RequestMapping(value = "shop/")
public class ShopCaregoryController {

    @Autowired
    private ShopCategoryService shopCategoryService;

    @Autowired
    RedisUtil redisUtil;

    /**
     *查询所有分类信息
     * @return
     */
    @RequestMapping(value = "category")
    @Cacheable(value = "category")
    public ShopResult getAllCategory(){

        ShopResult result = null;
        try {
            List<ShopCategory> list = shopCategoryService.getAllShopCategory();
            result = new ShopResult(list);
            if(list==null){
                result = new ShopResult(0,"没有数据");
            }
        } catch (Exception e) {
            result = new ShopResult(0,"服务器忙");
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 通过商品分类id 和分页参数,获取商品信息
     * @param id 商品分类id
     * @param curPage 页数
     * @param pageSize 页大小
     * @return
     */
    @RequestMapping(value = "category/page")
    @Cacheable(value = "category")
    public ShopResult getShopProductByCategoryId(@RequestParam(value = "id") String id, @RequestParam(value ="curPage" ) int curPage, @RequestParam(value = "pageSize") int pageSize){

        ShopResult result = null;
        try {
            List<ShopProduct> list = shopCategoryService.getShopProductByCategoryId(id, curPage, pageSize);
            result = new ShopResult(list);

        } catch (Exception e) {
            result = new ShopResult(0,"服务器忙");
            e.printStackTrace();
        }
        return result;
    }

}
