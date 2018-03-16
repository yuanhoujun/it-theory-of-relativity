package com.youngfeng.server.dao;

import com.youngfeng.server.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDAO {
    @Select("select * from t_user where username = #{username}")
    User findByUsername(@Param("username") String username);

    @Select("select * from t_user where username = #{username} and pwd = #{pwd}")
    User findUser(@Param("username") String username, @Param("pwd") String pwd);

    @Insert("insert into t_user(username, pwd) values(#{username}, #{pwd})")
    void insert(@Param("username") String username, @Param("pwd") String pwd);
}
