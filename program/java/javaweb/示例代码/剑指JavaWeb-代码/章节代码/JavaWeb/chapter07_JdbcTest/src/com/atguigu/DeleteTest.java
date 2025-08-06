package com.atguigu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteTest {
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

        //4. 对users表内的数据进行删除操作
        //4.1 准备带有占位符的sql语句
        String sql="delete from users where id=?";
        //4.2 获得PreparedStatement对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //4.3 为sql语句绑定参数
        preparedStatement.setObject(1,1);
        //4.4 执行,返回值为sql语句影响的行数
        int len = preparedStatement.executeUpdate();
        System.out.println(len > 0 ? "删除成功" : "删除失败");
        //5. 关闭资源
        preparedStatement.close();
        connection.close();
    }
}
