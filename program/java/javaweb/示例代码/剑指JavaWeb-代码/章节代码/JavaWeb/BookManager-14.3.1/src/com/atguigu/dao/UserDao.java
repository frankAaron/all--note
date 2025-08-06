package com.atguigu.dao;

import com.atguigu.bean.User;

public interface UserDao {
    User findUserByUsername(String username);

    boolean saveUser(User user) ;
}
