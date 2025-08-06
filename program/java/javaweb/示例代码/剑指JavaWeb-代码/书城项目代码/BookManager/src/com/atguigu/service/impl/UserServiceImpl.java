package com.atguigu.service.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.service.UserService;
import com.atguigu.util.MD5Util;

/**
 * @Author chenxin
 * @date 2022/10/18
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDaoImpl();

    @Override
    public boolean regist(User user) {
        //1. 对密码进行加密(待实现)
        user.setPassword(MD5Util.encode(user.getPassword()));
        //2. 新增
        return userDao.saveUser(user);
    }

    @Override
    public User login(String username, String password) {
        //1. 使用用户名去查询
        User user = userDao.findUserByUsername(username);
        //2. 做密码的校验(如果注册的时候有加密，需要处理)
        if(user!=null){
            String encode = MD5Util.encode(password);
            if(user.getPassword().equals(encode)){
                return user;
            }
        }
        return null;
    }

    @Override
    public User checkUsername(String username) {
        return userDao.findUserByUsername(username);
    }
}
