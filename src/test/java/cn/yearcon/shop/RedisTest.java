package cn.yearcon.shop;

import cn.yearcon.shop.dao.repository.UserRepository;
import cn.yearcon.shop.entity.User;
import cn.yearcon.shop.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * redis测试
 *
 * @author itguang
 * @create 2017-10-30 11:06
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test1(){
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set("aaa1","aaa value");

        String str = operations.get("aaa1");
        System.out.println("str="+str);


    }

    @Test
    public void test2(){
        User user = new User();
        user.setId("123");
        user.setUserName("itguang");
        ValueOperations opsForValue = redisTemplate.opsForValue();
        opsForValue.set("user",user);
        User user1 = (User)opsForValue.get("user");
        System.out.println(user1.toString());


    }@Test
    public void test3(){
        User user = new User();
        user.setId("1234");
        user.setUserName("itguang2");
        redisUtil.set("user2",user);
        User user1 = (User)redisUtil.get("user2");
        System.out.println(user1.toString());


    }

    @Test
    public void test4(){
        User u1 = userRepository.findByUserName("itguang");
        System.out.println("第一次查询：" + u1.getPassWord());
    }


}
