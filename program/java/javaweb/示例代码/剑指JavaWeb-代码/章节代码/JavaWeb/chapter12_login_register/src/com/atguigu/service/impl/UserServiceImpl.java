package com.atguigu.service.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.service.UserService;
import com.atguigu.util.MD5Util;

/**
 * @Author chenxin
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDaoImpl();

    @Override
    public boolean regist(String phone, String password,String nickName) {
        //1. 判断用户名是否重复(后期学完Vue会改造成异步方式验证用户名是否重复，暂时先这样操作)
        User user = userDao.findUserByPhone(phone);
        if(user==null){
            //2. 如果不重复则，进行新增
            User registUser=new User();
            registUser.setPhone(phone);
            registUser.setNickName(nickName);
            //3.密码进行加密
            registUser.setPassword(MD5Util.encode(password));
            //4. 将注册信息添加到数据库
            userDao.insertUser(registUser);
            return true;
        }
        return false;
    }

    @Override
    public User login(String phone, String password) {
        //1. 根据用户名查询User对象
        User user = userDao.findUserByPhone(phone);
        //2. 如果不是null则说明用户名是正确的
        if(user!=null){
            //2. 在对密码进行加密后，判断密码是否正确
            if(user.getPassword().equals(MD5Util.encode(password))){
                //3. 如果都正确，返回当前登录人对象
                return user;
            }
        }
        //4. 如果不正确返回null
        return null;
    }

    @Override
    public User checkUsername(String username) {
        return userDao.findUserByPhone(username);
    }
}
