package com.atguigu.dbutils;

import com.atguigu.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;

public class UpdateTest {
    public static void main(String[] args) throws Exception {
        //1. 创建QueryRunner对象
        QueryRunner runner=new QueryRunner();

        //2. 获得数据库连接
        Connection connection = JDBCTools.getConnection();

        //3.2 修改操作
        String updateSql="update users set username=?,password=?,email=? where id=?";
        int len = runner.update(connection, updateSql, "atguigu", "123456",
                "xiaoshang@atguigu.cn", 1);
        System.out.println(len > 0 ? "修改成功" : "修改失败");

        //4. 释放资源
        JDBCTools.freeConnection();
    }

}
