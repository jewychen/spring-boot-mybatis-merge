package org.monkey.mapper.mysql;

import org.apache.ibatis.annotations.*;
import org.monkey.domain.User;

import java.util.List;

/**
 * Created by monkey on 2017/1/5.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(@Param("username") String username);


//    @Insert({
//            "<script>",
//            "insert into mybatis_demo (name, age)",
//            "values ",
//            "<foreach  collection='dmoList' item='dmo' separator=','>",
//            "( #{dmo.name,jdbcType=VARCHAR}, #{dmo.age,jdbcType=INTEGER})",
//            "</foreach>",
//            "</script>"
//    })
//    int insertBatch(@Param("dmoList") List<MybatisDemoDMO> dmoList);

    @Insert({"<script>",
            "INSERT INTO user ",
            "VALUES ",
            "<foreach  collection='userList' item='usr' separator=','>",
            "( #{usr.id,jdbcType=INTEGER}, #{usr.username,jdbcType=VARCHAR}, #{usr.password,jdbcType=VARCHAR} )",
            "</foreach>",
            "</script>"
    })
    void insertUser(@Param("userList") List<User> userList);

//    @Insert({"INSERT INTO USER VALUES (#{id}, #{username}, #{password}) "})
//    void insertUser(@Param("id") long id,
//                    @Param("username")String username, @Param("password")String password);

    @Flush
    List flush();

}
