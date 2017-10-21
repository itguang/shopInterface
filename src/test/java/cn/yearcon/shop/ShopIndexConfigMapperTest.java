package cn.yearcon.shop;

import cn.yearcon.shop.dao.repository.ShopIndexConfigRepository;
import cn.yearcon.shop.entity.ShopCategory;
import cn.yearcon.shop.entity.ShopIndexConfig;
import cn.yearcon.shop.entity.ShopProduct;
import cn.yearcon.shop.mapper.ShopIndexConfigMapper;
import cn.yearcon.shop.service.ShopIndexConfigService;
import cn.yearcon.shop.service.ShopProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

/**
 * ShopIndexConfigMapperTest
 *
 * @author itguang
 * @create 2017-10-19 13:59
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopIndexConfigMapperTest {


    @Autowired
    private ShopIndexConfigService service;

    @Autowired
    private ShopIndexConfigRepository repository;


    @Autowired
    private ShopIndexConfigService shopIndexConfigService;



    @Test
    public void test1(){
        ShopIndexConfig shopIndexConfig = service.get("1");
        List<ShopIndexConfig> lists= service.getIndexImage();
        System.out.println(shopIndexConfig.toString());
    }
    @Test
    public void test2(){
        ShopIndexConfig one = repository.findOne("1");
        System.out.println(one.toString());
    }
    @Test
    public void testRetuenValueNull(){


        List<ShopIndexConfig> lists= shopIndexConfigService.getIndexImage();
        System.out.println(lists.toString());

    }

    @Autowired
    private ShopIndexConfigMapper shopIndexConfigMapper;
    @Autowired
    private ShopProductService shopProductService;
    @Test
    public void test3(){
//        HashMap<String, List<ShopProduct>> map = shopIndexConfigService.findIndexCategory();
        List<ShopCategory> allCategory = shopIndexConfigMapper.findAllCategory();

        System.out.println(allCategory.toString());


    }


}
