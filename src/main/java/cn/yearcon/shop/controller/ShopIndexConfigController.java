package cn.yearcon.shop.controller;

import cn.yearcon.shop.entity.ShopIndexConfig;
import cn.yearcon.shop.service.ShopIndexConfigService;
import cn.yearcon.shop.service.ShopProductService;
import cn.yearcon.shop.utils.ShopResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @return
     */
    @RequestMapping(value ="index/image")
    public ShopResult getimage(){
        ShopResult shopResult = null;
        List<ShopIndexConfig> lists=null;
        try {
             lists= shopIndexConfigService.getIndexImage();
             if(lists!=null){
            shopResult = new ShopResult(1,"OK",lists);
             }
        } catch (Exception e) {

            shopResult = new ShopResult(0,"未知错误",lists);
            e.printStackTrace();
        }

        return shopResult;
    }

    public ShopResult getIndexCategoryData(){




        return null;
    }


}
