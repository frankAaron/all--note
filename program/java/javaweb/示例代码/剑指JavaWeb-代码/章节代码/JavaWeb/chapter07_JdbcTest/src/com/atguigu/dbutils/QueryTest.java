package com.atguigu.dbutils;

import com.atguigu.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;

import com.atguigu.bean.User;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

public class QueryTest {

    public static void main(String[] args) throws Exception {
        //1. 创建QueryRunner对象
        QueryRunner runner=new QueryRunner();

        //2. 获得数据库连接
        Connection connection = JDBCTools.getConnection();
/*

        //3. 查询情况
        //3.1 查询单条结果
        String sql="select * from users where id=?";
        */
/*
            new BeanHandler<User>(User.class)  单条结果的处理器
                泛型设置为User
                实参设置User.class 底层使用反射进行映射
            功能：将sql语句的查询结果映射到一个User对象上
         *//*

        User user = runner.query(connection, sql, new BeanHandler<User>(User.class), 1);
        System.out.println("user = " + user);

*/

        //3.2 查询多条结果
        //String sql="select * from users";

        /*
         * new BeanListHandler<User>(User.class)多条结果的处理器
         *    泛型设置为User
         *    实参设置User.class 底层使用反射进行映射
         *    功能：将sql语句的每一条查询结果映射到一个User对象上，
         *    最终采用List集合存储这些Userr对象
         */
/*

        List<User> userList
                = runner.query(connection, sql, new BeanListHandler<User>(User.class));
        userList.stream().forEach(System.out::println);
*/

        // 使用BeanListHandler查询单条结果
        //String sql="select * from users where id=?";

        /*
         * new BeanHandler<User>(User.class)  单条结果的处理器
         *    泛型设置为User
         *    实参设置User.class 底层使用反射进行映射
         *    功能：将sql语句的查询结果映射到一个User对象上
         */

       /* User user = runner.query(connection, sql, new BeanHandler<User>(User.class),1);
        System.out.println("user = " + user);*/

        //3.3 查询单个值结果
        String sql="select count(*) from users";

        /*
         * new ScalarHandler<Long>()一个值的结果处理器
         *    泛型设置为Long,sql语句查询结果值的数据类型
         *    功能：将sql语句的查询结果赋值到Long类型上
         */

        Long count = (Long) runner.query(connection, sql, new ScalarHandler());
        System.out.println("count = " + count);

        //4. 释放资源
        JDBCTools.freeConnection();
    }

}
