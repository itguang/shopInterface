package cn.yearcon.shop;

import cn.yearcon.shop.entity.ShopCategory;
import cn.yearcon.shop.entity.ShopProduct;
import cn.yearcon.shop.mapper.ShopCategoryMapper;
import cn.yearcon.shop.service.ShopCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 商品分类测试
 *
 * @author itguang
 * @create 2017-10-20 10:43
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopCategoryTest {

    @Autowired
    private ShopCategoryMapper shopCategoryMapper;
    @Autowired
    private ShopCategoryService shopCategoryService;

    @Test
    public void test1(){
        ShopCategory shopCategory = shopCategoryMapper.get("1");
        System.out.println(shopCategory.toString());

    }
    @Test
    public void test2(){
        List<ShopCategory> list = shopCategoryService.getAllShopCategory();
        System.out.println(list.toString());

    }
    @Test
    public void test3(){
        int count = shopCategoryMapper.findCountByCategoryId("1");
        System.out.println(count);

    }
    @Test
    public void test4(){
        List<ShopProduct> list = shopCategoryMapper.getShopProductByCategoryId("1",0, 3);
        System.out.println(list.size());
    }
    @Test
    public void test5(){
        List<ShopProduct> list = shopCategoryService.getShopProductByCategoryId("1",1, 3);
        System.out.println(list.size());
    }
}
