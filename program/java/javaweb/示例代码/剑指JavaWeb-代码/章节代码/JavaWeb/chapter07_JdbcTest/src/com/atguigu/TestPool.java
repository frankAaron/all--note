package com.atguigu;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

public class TestPool {
    public static void main(String[] args)throws Exception {
        Properties pro = new Properties();//这是一个map
        //因为druid.properties文件是在src下，最后会随着.java文件一起编译到类路径下（class）
        //可以通过类加载器帮我们加载资源配置文件
        pro.load(TestPool.class.getClassLoader().getResourceAsStream("druid.properties"));
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        Connection connection = ds.getConnection();
        System.out.println("connection = " + connection);
    }

}
