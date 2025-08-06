package com.atguigu.dao.impl;

import com.atguigu.bean.Book;
import com.atguigu.dao.BookDao;
import com.atguigu.util.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author chenxin
 * @date 2022/10/21
 * @Version 1.0
 */
public class BookDaoImpl implements BookDao {

    //就是由dbutils的QueryRunner，变成了JdbcTemplate
    private QueryRunner runner=new QueryRunner();

    @Override
    public List<Book> findAll() {
        try {
            Connection connection = JDBCTools.getConnection();
            String sql="select id bookId,title bookName,author,price,sales,stock,img_path imgPath from t_books";
            return runner.query(connection,sql,new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCTools.freeConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public void insert(Book book) {
        try {
            Connection connection = JDBCTools.getConnection();
            String sql="insert into t_books values(null,?,?,?,?,?,?)";
            runner.update(connection,sql,book.getBookName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCTools.freeConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            Connection connection = JDBCTools.getConnection();
            String sql="delete from t_books where id=?";
            runner.update(connection,sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCTools.freeConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Book getById(Integer id) {
       try {
           Connection connection = JDBCTools.getConnection();
           String sql="select id bookId,title bookName,author,price,sales,stock,img_path imgPath from t_books where id=?";
           return runner.query(connection,sql,new BeanHandler<Book>(Book.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
           try {
               JDBCTools.freeConnection();
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }
       }
        return null;
    }

    @Override
    public void update(Book book) {
        try {
            Connection connection = JDBCTools.getConnection();
            String sql="update t_books set title=?,author=?,price=?,sales=?,stock=? where id=?";
            runner.update(connection,sql,book.getBookName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getBookId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }finally {
            try {
                JDBCTools.freeConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
