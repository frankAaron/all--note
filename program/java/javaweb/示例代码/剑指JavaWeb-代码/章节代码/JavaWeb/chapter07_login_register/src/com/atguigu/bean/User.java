package com.atguigu.bean;

/**
 * @Author chenxin
 * @date 2022/12/18
 * @Version 1.0
 */
public class User {
    private Integer id;      //用户ID
    private String phone;   //手机号码
    private String password;//用户密码
    private String nickName;//用户昵称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
