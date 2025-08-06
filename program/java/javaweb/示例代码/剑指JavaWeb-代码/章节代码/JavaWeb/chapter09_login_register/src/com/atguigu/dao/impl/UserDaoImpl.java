package com.atguigu.dao.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;

/**
 * @Author chenxin
 * @Version 1.0
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    private QueryRunner runner=new QueryRunner();

    @Override
    public User findUserByPhone(String phone) {
        String sql="select id,phone,password,nick_name nickName from users where phone=?";
        return this.getBean(User.class,sql,phone);
    }

    @Override
    public void insertUser(User user) {
        String sql="insert into users(phone,password,nick_name) values(?,?,?)";
        this.update(sql,user.getPhone(),user.getPassword(),user.getNickName());
    }
}
