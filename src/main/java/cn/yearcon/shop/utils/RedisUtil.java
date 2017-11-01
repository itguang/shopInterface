package cn.yearcon.shop.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * redis
 *
 * @author itguang
 * @create 2017-10-30 15:09
 **/
@Component
public class RedisUtil {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     *设置缓存
     * @param key
     * @param value
     */
    public void  set(String key,Object value){
        ValueOperations opsForValue = redisTemplate.opsForValue();
        opsForValue.set(key,value);

    }


    /**
     *设置缓存
     * @param key
     * @param value
     * @param timeout 失效时间(秒)
     */
    public void set(String key,Object value,Long timeout){
        ValueOperations opsForValue = redisTemplate.opsForValue();
        opsForValue.set(key,value,timeout, TimeUnit.SECONDS);


    }

    /**
     *得到指定key
     * @param key
     * @return
     */
    public Object get(String key){
        ValueOperations opsForValue = redisTemplate.opsForValue();
        return opsForValue.get(key);
    }

    /**
     * 删除指定key
     * @param key
     */
    public void del(String key){
        redisTemplate.delete(key);

    }


}
