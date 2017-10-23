package cn.yearcon.shop;

import cn.yearcon.shop.entity.ShopCustomer;
import cn.yearcon.shop.mapper.ShopCustomerMapper;
import cn.yearcon.shop.service.ShopCustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 顾客表测试
 *
 * @author itguang
 * @create 2017-10-20 14:01
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopCustomerTest {

    @Autowired
    private ShopCustomerMapper shopCustomerMapper;
    @Autowired
    private ShopCustomerService shopCustomerService;

    @Test
    public void test1(){
        ShopCustomer shopCustomer = shopCustomerMapper.get("f157319b6c334914b4624791ed60b371");
        System.out.println(shopCustomer.toString());
    }
    @Test
    public void test2(){
        ShopCustomer shopCustomer = shopCustomerService.findUniqueByOPenid("666");
        System.out.println(shopCustomer.toString());
    }

    @Test
    public void test3(){
         shopCustomerMapper.updatePayPasswordByOpenid("777777", "666");

    }
}
