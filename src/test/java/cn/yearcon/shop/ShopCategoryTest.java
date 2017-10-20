package cn.yearcon.shop;

import cn.yearcon.shop.entity.ShopCategory;
import cn.yearcon.shop.mapper.ShopCategoryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void test1(){
        ShopCategory shopCategory = shopCategoryMapper.get("1");
        System.out.println(shopCategory.toString());

    }
}
