package com.atguigu.dao;

import com.atguigu.bean.User;

import java.sql.SQLException;

/**
 * @Author chenxin
 * @date 2022/10/18
 * @Version 1.0
 */
public interface UserDao {
    boolean saveUser(User user) ;

    User findUserByUsername(String username) ;
}
