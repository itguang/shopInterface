package cn.yearcon.shop;

import cn.yearcon.shop.entity.ShopProductSpecification;
import cn.yearcon.shop.mapper.ShopProductSpecificationMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void test1(){
        ShopProductSpecification shopProductSpecification = shopProductSpecificationMapper.get("9510caeed1584144b818cdef9739a1b3");
        System.out.println(shopProductSpecification.toString());

    }


}
