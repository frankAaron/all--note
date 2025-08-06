package com.atguigu;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTest {
    public static void main(String[] args) throws Exception {
        //1. 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. 设置连接数据库的参数
        //需要设置连接数据库的类型是mysql,ip是localhost,端口号是3306，数据库名字是atguigu
        String url="jdbc:mysql://localhost:3306/atguigu";
        //用户名，采用root用户登录
        String username="root";
        //密码，root用户的密码(安装数据库的时候设置的)
        String password="root";
        //3. 获得数据库连接
        Connection connection = DriverManager.getConnection(url, username, password);
        //4. 输出验证结果是否成功
        System.out.println("connection = " + connection);
    }

}
