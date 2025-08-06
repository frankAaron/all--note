package com.atguigu.dao;

import com.atguigu.bean.Order;

import java.util.List;

/**
 * @Author chenxin
 * @date 2022/10/26
 * @Version 1.0
 */
public interface OrderDao {

    void insert(Order order);

    Integer getId(String sequence);

    List<Order> findOrderByUserId(Integer userId);
}
