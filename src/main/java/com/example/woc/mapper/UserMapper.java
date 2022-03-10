package com.example.woc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.woc.entity.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @author: 風楪fy
 * @create: 2022-01-15 01:22
 **/
//@Repository
public interface UserMapper extends BaseMapper<Account> {
//    @Insert("insert into account(username,password,email) VALUES(#{username},#{password},#{email})")
//        //void saveUser(Account account);
//    int saveUser(@Param("username") String username,
//                 @Param("password") String password,@Param("email") String email);
//
//
//    @Select("select id,username,password,email from account where username=#{username}")
//    Account selectUser(@Param("username") String username);
//
//
//    @Delete("DELETE FROM account WHERE username=#{username}")
//    int delByUser(@Param("username") String username);
}
