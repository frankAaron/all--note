package com.atguigu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QueryTest {
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

        //4. 对users表内的数据进行查询
        //4.1 准备带有占位符的sql语句
        String sql="select * from users where id=?";
        //4.2 获得PreparedStatement对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //4.3 为sql语句绑定参数
        preparedStatement.setObject(1,1);
        //4.4 执行,返回值为sql语句的查询结果
        ResultSet resultSet = preparedStatement.executeQuery();
        //5. 处理结果集
        //如果sql语句的查询结果是多条的话，将if换成while即可
        if(resultSet.next()){
            int id = resultSet.getInt("id");//获取id列的数据
            System.out.println("id = " + id);
            String username1 = resultSet.getString("username");
            System.out.println("username1 = " + username1);
            String password1 = resultSet.getString("password");
            System.out.println("password1 = " + password1);
            String email = resultSet.getString("email");
            System.out.println("email = " + email);
        }
        //6. 关闭资源
        preparedStatement.close();
        connection.close();
    }
}
