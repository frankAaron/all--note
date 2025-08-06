package com.atguigu.service.impl;

import com.atguigu.bean.Book;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.service.BookService;

import java.util.List;

/**
 * @Author chenxin
 * @date 2022/10/21
 * @Version 1.0
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao=new BookDaoImpl();
    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public void insert(Book book) {
        bookDao.insert(book);
    }

    @Override
    public void delete(Integer id) {
        bookDao.delete(id);
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.getById(id);
    }

    @Override
    public void update(Book book) {
        bookDao.update(book);
    }
}
