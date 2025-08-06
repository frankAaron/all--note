package com.atguigu.dao;

import com.atguigu.bean.Book;

import java.util.List;

/**
 * @Author chenxin
 * @date 2022/10/21
 * @Version 1.0
 */
public interface BookDao {

    List<Book> findAll();

    void insert(Book book);

    void delete(Integer id);

    Book getById(Integer id);

    void update(Book book);
}
