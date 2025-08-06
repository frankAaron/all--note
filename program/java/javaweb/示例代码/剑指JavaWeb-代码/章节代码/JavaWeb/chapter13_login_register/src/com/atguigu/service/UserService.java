package com.atguigu.service;

import com.atguigu.bean.User;

/**
 * @Author chenxin
 * @Version 1.0
 */
public interface UserService {
    /**
     * 注册功能
     * @param phone
     * @param password
     */
    boolean regist(String phone,String password,String nickName);

    /**
     * 登录功能
     * @param email
     * @param password
     * @return
     */
    User login(String email,String password);

    User checkUsername(String username);
}
