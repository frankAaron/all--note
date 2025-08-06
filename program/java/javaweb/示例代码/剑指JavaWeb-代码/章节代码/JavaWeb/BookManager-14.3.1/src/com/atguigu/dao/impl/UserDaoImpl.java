package com.atguigu.dao.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.util.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private QueryRunner runner=new QueryRunner();

    //根据id查询用户
    @Override
    public User findUserByUsername(String username)  {

        try {
            Connection connection = JDBCTools.getConnection();
            String sql="select * from t_users where username=?";
            return runner.query(connection,sql,new BeanHandler<User>(User.class),username);
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

    //新增用户信息
    @Override
    public boolean saveUser(User user)  {

        try {
            Connection connection = JDBCTools.getConnection();
            String sql="insert into t_users values(null,?,?,?)";
            int update = runner.update(connection, sql, user.getUsername(), user.getPassword(), user.getEmail());
            if(update>0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCTools.freeConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }


}
