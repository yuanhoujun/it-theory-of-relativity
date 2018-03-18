package com.youngfeng.server.dao;

import com.youngfeng.server.model.User;
import org.apache.ibatis.annotations.*;

public interface UserDAO {
    @Select("select * from t_user where username = #{username}")
    @Results(
            @Result(property = "name", column = "username")
    )
    User findByUsername(@Param("username") String username);

    @Select("select * from t_user where username = #{username} and pwd = #{pwd}")
    @Results(
            @Result(property = "name", column = "username")
    )
    User findUser(@Param("username") String username, @Param("pwd") String pwd);

    @Insert("insert into t_user(username, pwd) values(#{username}, #{pwd})")
    void insert(@Param("username") String username, @Param("pwd") String pwd);
}
