package cn.yearcon.shop;

import cn.yearcon.shop.entity.ShopProductSpecification;
import cn.yearcon.shop.mapper.ShopProductSpecificationMapper;
import cn.yearcon.shop.service.ShopProductSpecificationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 产品规格测试
 *
 * @author itguang
 * @create 2017-10-20 10:19
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopProductSpecificationTest {


    @Autowired
    private ShopProductSpecificationMapper shopProductSpecificationMapper;
    @Autowired
    private ShopProductSpecificationService shopProductSpecificationService;


    @Test
    public void test2(){
        List<ShopProductSpecification> list = shopProductSpecificationMapper.getShopProductSpecificationById("888888");
        System.out.println(list.toString());

    }
    @Test
    public void test3(){
        List<ShopProductSpecification> list = shopProductSpecificationService.getShopProductSpecificationById("88888888");
        System.out.println(list.toString());

    }


}
