package cn.yearcon.shop;

import cn.yearcon.shop.entity.ShopConfig;
import cn.yearcon.shop.mapper.ShopConfigMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 首页配置测试
 *
 * @author itguang
 * @create 2017-10-20 13:51
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopConfigTest {

    @Autowired
    private ShopConfigMapper shopConfigMapper;

    @Test
    public void test1(){
        ShopConfig shopConfig = shopConfigMapper.get("1");
        System.out.println(shopConfig.toString());
    }
}
