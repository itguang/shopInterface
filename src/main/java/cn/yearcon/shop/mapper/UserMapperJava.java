package cn.yearcon.shop.mapper;

import cn.yearcon.shop.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapperJava {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectOne(String id);

}
