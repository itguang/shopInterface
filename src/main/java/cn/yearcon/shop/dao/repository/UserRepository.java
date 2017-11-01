package cn.yearcon.shop.dao.repository;


import cn.yearcon.shop.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames = "shop")
public interface UserRepository extends JpaRepository<User,String> {

    @Cacheable("test")
    User findByUserName(String userName);
}
