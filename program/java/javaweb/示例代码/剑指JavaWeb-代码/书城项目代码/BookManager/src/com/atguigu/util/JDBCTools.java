package com.atguigu.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTools {
    //数据库连接池
    private static DataSource ds;
    //<Connection>表示  ThreadLocalMap中(key,value)的value是Connection类型的对象
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    //静态变量的初始化，可以使用静态代码块
    static{
        try {
            Properties pro = new Properties();
            pro.load(JDBCTools.class.getClassLoader().getResourceAsStream("db.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection()throws SQLException {
        Connection connection = threadLocal.get();
        //每一个线程调用这句代码，都会到自己的ThreadLocalMap中，以threadLocal对象为key，找到value
        //如果value为空，说明当前线程还未获取过Connection对象，那么就从连接池中拿一个数据库连接对象给你
        //并且通过threadLocal的set方法把Connection对象放到当前线程ThreadLocalMap中
        if(connection == null){
            connection = ds.getConnection();
            //通过threadLocal的set方法把Connection对象放到当前线程ThreadLocalMap中
            threadLocal.set(connection);
        }
        return connection;
    }

    public static void freeConnection()throws SQLException{
        Connection connection = threadLocal.get();
        if(connection != null){
            connection.setAutoCommit(true);//还原自动提交模式
            threadLocal.remove();//从当前线程的ThreadLocalMap中删除这个连接
            connection.close();
        }
    }
}
