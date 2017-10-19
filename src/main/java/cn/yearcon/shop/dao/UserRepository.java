package cn.yearcon.shop.dao;


import cn.yearcon.shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//对spring data jpa不熟的请私下去了解
public interface UserRepository extends JpaRepository<User,String> {

    //也可以按照spring data jpa 的规则,自定义方法
    User findByUserName(String userName);





}
