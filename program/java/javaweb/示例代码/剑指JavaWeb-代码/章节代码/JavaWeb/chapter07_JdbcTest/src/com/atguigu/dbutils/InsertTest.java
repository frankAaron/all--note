package com.atguigu.dbutils;

import com.atguigu.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;

public class InsertTest {
    public static void main(String[] args) throws Exception {
        //1. 创建QueryRunner对象
        QueryRunner runner=new QueryRunner();

        //2. 获得数据库连接
        Connection connection = JDBCTools.getConnection();

        //3. 进行增删改操作,增删改操作逐一进行测试即可
        //3.1 新增操作
        String insertSql
                ="insert into users(username,password,email) values(?,?,?)";
        /*
         * update()方法的参数介绍：
         * Connection connection表示数据库连接
         * String sql表示sql语句
         * Object... params表示sql语句占位符位置的参数
         * 要求和之前一样，顺序和个数要保持一致
         */
        int len = runner.update(connection, insertSql,
                "xiaoshang", "atguigu", "xiaoshang@atguigu.com");
        System.out.println(len > 0 ? "新增成功" : "新增失败");

        //4. 释放资源
        JDBCTools.freeConnection();
    }

}
