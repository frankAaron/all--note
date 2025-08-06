package com.atguigu.dao;

import com.atguigu.bean.User;

/**
 * @Author chenxin
 * @Version 1.0
 */
public interface UserDao {
    User findUserByPhone(String phone);

    void insertUser(User user);
}
