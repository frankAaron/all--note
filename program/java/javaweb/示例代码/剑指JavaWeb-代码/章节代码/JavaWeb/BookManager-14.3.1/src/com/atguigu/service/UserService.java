package com.atguigu.service;

import com.atguigu.bean.User;

public interface UserService {
    //验证用户名是否重复
    User checkUsername(String username);

    //向数据库添加用户信息
    boolean regist(User user);
}
