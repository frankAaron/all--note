package com.atguigu.service;

import com.atguigu.bean.Cart;
import com.atguigu.bean.Order;
import com.atguigu.bean.User;

import java.util.List;

/**
 * @Author chenxin
 * @date 2022/10/26
 * @Version 1.0
 */
public interface OrderService {
    /*
        返回值：订单号
        参数：购物车对象和当前登录人的User对象
     */
    String checkout(Cart cart, User user);

    /*
        功能：显示我的订单
     */
    List<Order> showOrder(Integer userId);
}
