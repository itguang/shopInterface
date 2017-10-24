package cn.yearcon.shop;

import cn.yearcon.shop.entity.ShopProduct;
import cn.yearcon.shop.mapper.ShopProductMapper;
import cn.yearcon.shop.service.ShopProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 商品表测试
 * @author itguang
 * @create 2017-10-20 9:43
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopProductTest {


    @Autowired
    private ShopProductMapper shopProductMapper;
    @Autowired
    private ShopProductService shopProductService;


    @Test
    public void test1(){
        ShopProduct shopProduct = shopProductMapper.get("00c099f8a13f414dbdbe077a5ad03073");
    }
    @Test
    public void test2(){
        List<ShopProduct> list = shopProductMapper.findIsNew(6);
        System.out.println(list.toString());

    } @Test
    public void test3(){
        ShopProduct shopProduct = shopProductService.findShopProductByid("9");
        System.out.println(shopProduct.toString());

    }

    @Test
    public void test4(){
        Integer i = shopProductService.incrementShopProductVisits("9");

        System.out.println(i);

    }

    @Test
    public void test5(){
        Integer i = shopProductService.incrementShopProductSales("9");

        System.out.println(i);

    }



}
