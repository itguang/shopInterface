package cn.yearcon.shop;

import cn.yearcon.shop.entity.ShopOrder;
import cn.yearcon.shop.mapper.ShopOrderMapper;
import cn.yearcon.shop.service.ShopOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 商品订单测试
 *
 * @author itguang
 * @create 2017-10-20 13:15
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopOrderTest {

    @Autowired
    private ShopOrderMapper shopOrderMapper;
    @Autowired
    private ShopOrderService shopOrderService;

    @Test
    public void test1(){
        ShopOrder shopOrder = shopOrderMapper.get("1");
        System.out.println(shopOrder.toString());
    }

    @Test
    public void test2(){
        ShopOrder shopOrder = shopOrderService.queryLastOrderByCustomerId("1");
        System.out.println(shopOrder.toString());

    }





}
