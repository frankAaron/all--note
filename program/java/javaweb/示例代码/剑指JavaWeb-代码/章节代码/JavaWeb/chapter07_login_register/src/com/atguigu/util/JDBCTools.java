package com.atguigu.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author chenxin
 * @Version 1.0
 */
public class JDBCTools {
    //静态变量
    private static DataSource ds = null;

    //添加一个容器(存储数据库连接)
    private static ThreadLocal<Connection> local=new ThreadLocal<>();

    //静态代码块只执行一次
    static {
        //创建空集合
        Properties prop = new Properties();
        try {
            //读取配置文件中的数据到Properties集合中
            prop.load(JDBCTools.class.getClassLoader().getResourceAsStream("db.properties"));
            //创建连接池
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (IOException e) {
            System.out.println("读取配置文件失败");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取一个连接池对象
    public static DataSource getDs(){
        return ds;
    }

    //获取一个连接对象
        //将数据库连接放在容器内，然后判断容器是否存在数据库连接，如果存在就返回，不存在就新建一个，在返回
    public static Connection getConnection() {
        Connection connection = local.get();
        if(connection==null){
            try {
                connection=ds.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            local.set(connection);
        }
        return connection;
    }

    //释放资源
        //需要释放的数据库连接从，容器内获取，然后进行释放操作，释放完记得从容器内移除数据库连接
    public static void closeAll() {
        Connection connection = local.get();
        try {
            if(connection!=null){
                connection.close();
                local.remove();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
