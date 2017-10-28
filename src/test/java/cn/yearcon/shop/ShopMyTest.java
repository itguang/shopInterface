package cn.yearcon.shop;

import cn.yearcon.shop.entity.ShopOrder;
import cn.yearcon.shop.service.ShopMyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 个人中心测试
 *
 * @author itguang
 * @create 2017-10-28 15:11
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopMyTest {

    @Autowired
    private ShopMyService shopMyService;

    @Test
    public void test1(){
        List<ShopOrder> list = shopMyService.queryNoPayOrderListByOpenid("123");
        System.out.println(list.size());
    }@Test
    public void test2(){
        List<ShopOrder> list = shopMyService.queryPaidOrderListByCustomerId("666");
        System.out.println(list.size());
    }

}
