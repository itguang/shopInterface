package cn.yearcon.shop.controller;

import cn.yearcon.shop.common.annotation.JSON;
import cn.yearcon.shop.entity.ShopIndexConfig;
import cn.yearcon.shop.entity.ShopProduct;
import cn.yearcon.shop.service.ShopIndexConfigService;
import cn.yearcon.shop.service.ShopProductService;
import cn.yearcon.shop.utils.ShopResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * ShopIndexConfig 商城首页接口
 *
 * @author itguang
 * @create 2017-10-19 14:58
 **/
@RestController
@RequestMapping(value = "shop/")
public class ShopIndexConfigController {

    @Autowired
    private ShopIndexConfigService shopIndexConfigService;

    @Autowired
    private ShopProductService shopProductService;

    /**
     * 首页图片接口
     *
     * @return
     */
    @RequestMapping(value = "index/image")
    public ShopResult getimage(HttpServletResponse response) {
        ShopResult shopResult = null;
        List<ShopIndexConfig> lists = null;
        try {
            lists = shopIndexConfigService.getIndexImage();
            if (lists != null) {
                shopResult = new ShopResult(1, "OK", lists);
            }else {
                shopResult = new ShopResult(1, "没有数据");
            }
        } catch (Exception e) {

            shopResult = new ShopResult(0, "服务器忙");
            e.printStackTrace();
        }
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        return shopResult;
    }

    @RequestMapping(value = "index/new-product")

    public ShopResult getIndexNewProduct() {
        ShopResult result;

        try {
            List<ShopProduct> list = shopProductService.findIsNew(6);
            if (list != null) {

                result = new ShopResult(1, "OK", list);


            } else {
                result = new ShopResult(0, "没有数据");
            }

        } catch (Exception e) {
            result = new ShopResult(0, "服务器忙");
            e.printStackTrace();
        }
        System.out.println(result.toString());

        return result;
    }

    @RequestMapping(value = "index/category")
    public ShopResult getIndexCategory(){
        ShopResult result=null;

        try {
            HashMap<String, List<ShopProduct>> map = shopIndexConfigService.findIndexCategory();

            if(map!=null){
                result  = new ShopResult(1, "OK", map);
            }else {
                result  = new ShopResult(1, "没有数据", map);
            }

        } catch (Exception e) {
            result  = new ShopResult(0, "服务器忙");
            e.printStackTrace();
        }
        System.out.println(result.toString());

        return result;

    }


}
