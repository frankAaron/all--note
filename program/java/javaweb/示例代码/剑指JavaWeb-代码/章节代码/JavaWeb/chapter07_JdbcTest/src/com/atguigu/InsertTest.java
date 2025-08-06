package com.atguigu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertTest {
    public static void main(String[] args) throws Exception {
        //1. 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2. 设置连接数据库的参数
        String url="jdbc:mysql://localhost:3306/atguigu";
        //用户名，采用root用户登录
        String username="root";
        //密码，root用户的密码(安装数据库的时候设置的)
        String password="root";

        //3. 获得数据库连接
        Connection connection = DriverManager.getConnection(url, username, password);

        //输出验证结果是否成功
        System.out.println("connection = " + connection);

        //4. 将数据添加到users表格内

        //4.1 准备带有占位符的sql语句(后期可以避免sql语句的拼接和sql注入问题)
        String sql="insert into users(username,password,email) values(?,?,?)";
        //4.2 获得PreparedStatement对象

        PreparedStatement preparedStatement =connection .prepareStatement(sql);
        //4.3 为sql语句绑定参数(也就是占位符?位置的数据)
        //值得注意的是setObject方法可以绑定任意类型的参数，第一个参数的含义是第几个问号，第二个参数就是参数值
        //参数的个数一定要和问号的个数保持一致，否则会出错误
        preparedStatement.setObject(1,"xiaoshang");
        preparedStatement.setObject(2,"atguigu");
        preparedStatement.setObject(3,"xiaoshang@atguigu.com");
        //4.4 执行,返回值为sql语句影响的行数
        int len = preparedStatement.executeUpdate();
        System.out.println(len > 0 ? "新增成功" : "新增失败");
        //5. 关闭资源
        preparedStatement.close();
        connection.close();
    }

}
