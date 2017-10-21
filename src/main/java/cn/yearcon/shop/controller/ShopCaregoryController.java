package cn.yearcon.shop.controller;

import cn.yearcon.shop.entity.ShopCategory;
import cn.yearcon.shop.entity.ShopProduct;
import cn.yearcon.shop.service.ShopCategoryService;
import cn.yearcon.shop.utils.ShopResult;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "category")
    public ShopResult getAllCategory(){
        System.out.println("================category");
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


    @RequestMapping(value = "category/page")
    public ShopResult getShopProductByCategoryId(@RequestParam(value = "id") String id, @RequestParam(value ="curPage" ) int curPage, @RequestParam(value = "pageSize") int pageSize){

        ShopResult result = null;
        try {
            List<ShopProduct> list = shopCategoryService.getShopProductByCategoryId(id, curPage, pageSize);
            result = new ShopResult(list);
            if (list==null){
                result = new ShopResult(0,"没有数据");
            }
        } catch (Exception e) {
            result = new ShopResult(0,"服务器忙");
            e.printStackTrace();
        }
        return result;
    }

}
