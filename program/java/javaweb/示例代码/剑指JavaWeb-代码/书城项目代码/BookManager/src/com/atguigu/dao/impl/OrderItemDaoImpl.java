package com.atguigu.dao.impl;

import com.atguigu.bean.OrderItem;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.util.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author chenxin
 * @date 2022/10/26
 * @Version 1.0
 */
public class OrderItemDaoImpl implements OrderItemDao {
    private QueryRunner runner=new QueryRunner();
    @Override
    public void insert(OrderItem item) {
        try {
            Connection connection = JDBCTools.getConnection();
            String sql="insert into t_order_item values(null,?,?,?,?,?,?)";
            runner.update(connection,sql,item.getBookName(),item.getPrice(),item.getImgPath(),item.getItemCount(),item.getItemAmount(),item.getOrderId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }finally {
            try {
                JDBCTools.freeConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
