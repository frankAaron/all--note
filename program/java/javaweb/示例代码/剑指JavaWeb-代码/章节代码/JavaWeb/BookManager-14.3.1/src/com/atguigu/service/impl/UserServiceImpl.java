package com.atguigu.service.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.service.UserService;
import com.atguigu.util.MD5Util;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();

    @Override
    public User checkUsername(String username) {
        return userDao.findUserByUsername(username);
    }


    @Override
    public boolean regist(User user) {
        //1. 对密码进行加密(待实现)
        user.setPassword(MD5Util.encode(user.getPassword()));
        //2. 新增
        return userDao.saveUser(user);
    }


}
