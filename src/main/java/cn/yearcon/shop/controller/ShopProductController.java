package cn.yearcon.shop.controller;

import cn.yearcon.shop.entity.ShopProduct;
import cn.yearcon.shop.entity.ShopProductSpecification;
import cn.yearcon.shop.service.ShopProductService;
import cn.yearcon.shop.service.ShopProductSpecificationService;
import cn.yearcon.shop.utils.ShopResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Id;
import java.util.List;

/**
 * 商品信息
 *
 * @author itguang
 * @create 2017-10-21 13:40
 **/
@RestController
@RequestMapping(value = "shop/")
public class ShopProductController {
    @Autowired
    private ShopProductService shopProductService;
    @Autowired
    private ShopProductSpecificationService shopProductSpecificationService;

    /**
     *通过商品id查找商品信息
     * @param id 商品id
     * @return
     */
    @RequestMapping(value = "product/{id}")
    public ShopResult getShopProductById(@PathVariable(value =                                                                                                                              "id") String id){
        ShopResult result;
        try {
            ShopProduct shopProduct = shopProductService.findShopProductByid(id);
            result = new ShopResult(shopProduct);
            if (shopProduct==null){
                result = new ShopResult(0,"没有查到此产品相关信息");

            }
        } catch (Exception e) {
            result = new ShopResult(0,"服务器忙");
            e.printStackTrace();
        }
        return result;
    }

    /**
     *通过商品id获取商品规格参数
     * @param id 商品id
     * @return
     */
    @RequestMapping(value = "product-specification/{id}")
    public ShopResult getShopProductSpecificationById(@PathVariable(value = "id")String id){
        ShopResult result = null;

        try {
            List<ShopProductSpecification> list = shopProductSpecificationService.getShopProductSpecificationById(id);
            result = new ShopResult(list);
        } catch (Exception e) {
            result = new ShopResult(0,"服务器忙");
            e.printStackTrace();
        }


        return result;

    }



}
