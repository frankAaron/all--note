package com.atguigu.dao.impl;

import com.atguigu.bean.Order;
import com.atguigu.dao.OrderDao;
import com.atguigu.util.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author chenxin
 * @date 2022/10/26
 * @Version 1.0
 */
public class OrderDaoImpl implements OrderDao {

    private QueryRunner runner=new QueryRunner();
    @Override
    public void insert(Order order) {
        try {
            Connection connection = JDBCTools.getConnection();
            String sql="insert into t_order values(null,?,?,?,?,?,?)";
            runner.update(connection,sql,order.getOrderSequence(),order.getCreateTime(),order.getTotalCount(),order.getTotalAmount(),order.getOrderStatus(),order.getUserId());
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

    @Override
    public Integer getId(String sequence) {
        try {
            Connection connection = JDBCTools.getConnection();
            String sql="select order_id from t_order where order_sequence=?";
            return (Integer) runner.query(connection, sql, new ScalarHandler(), sequence);
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

    @Override
    public List<Order> findOrderByUserId(Integer userId) {

        try {
            Connection connection = JDBCTools.getConnection();
            String sql="select " +
                    "order_id orderId,order_sequence orderSequence," +
                    "create_time createTime,total_count totalCount," +
                    "total_amount totalAmount,order_status orderStatus,user_id userId " +
                    "from t_order where user_id=?";
            return runner.query(connection,sql,new BeanListHandler<Order>(Order.class),userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCTools.freeConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
