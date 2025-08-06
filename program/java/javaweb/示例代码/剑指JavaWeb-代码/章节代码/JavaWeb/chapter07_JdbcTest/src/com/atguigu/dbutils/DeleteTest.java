package com.atguigu.dbutils;

import com.atguigu.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;

public class DeleteTest {
    public static void main(String[] args) throws Exception {
        //1. 创建QueryRunner对象
        QueryRunner runner=new QueryRunner();

        //2. 获得数据库连接
        Connection connection = JDBCTools.getConnection();

        //3.3 删除操作
        String deleteSql="delete from users where id=?";
        int len = runner.update(connection, deleteSql, 1);
        System.out.println(len > 0 ? "删除成功" : "删除失败");


        //4. 释放资源
        JDBCTools.freeConnection();
    }

}
