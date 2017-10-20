package cn.yearcon.shop;

import cn.yearcon.shop.dao.repository.UserRepository;
import cn.yearcon.shop.entity.User;
import cn.yearcon.shop.mapper.UserMapper;
import cn.yearcon.shop.mapper.UserMapperJava;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapperJava userMapperJava;
    @Autowired
    private UserMapper userMapper;


    @Test
    public void testUserRepository() {
        User user = new User();
        user.setId("2");
        user.setUserName("itguang2");
        userRepository.save(user);


    }

    /**
     * mybatis 之java 注解
     */
    @Test
    public void testUserMapper() {
        userMapperJava.selectOne("1");

    }
    @Test
    public void testMybatisXml(){
        userMapper.getAll();
    }



}
