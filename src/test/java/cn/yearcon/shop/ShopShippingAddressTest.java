package cn.yearcon.shop;

import cn.yearcon.shop.entity.ShopShippingAddress;
import cn.yearcon.shop.mapper.ShopShippingAddressMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 收货地址测试
 *
 * @author itguang
 * @create 2017-10-20 12:57
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopShippingAddressTest {
    @Autowired
    ShopShippingAddressMapper shopShippingAddressMapper;
    @Test
    public void test1(){
        ShopShippingAddress shopShippingAddress = shopShippingAddressMapper.get("783f280e4acd4731ba89fe58d06dd397");
        System.out.println(shopShippingAddress.toString());
    }
    @Test
    public void test2(){
        List<ShopShippingAddress> list = shopShippingAddressMapper.getShopShippingAddressesByOpenid("123");
        System.out.println(list.toString());
    }
}
