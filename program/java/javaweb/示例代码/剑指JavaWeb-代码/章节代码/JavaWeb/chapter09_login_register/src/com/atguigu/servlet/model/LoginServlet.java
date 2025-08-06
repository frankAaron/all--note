package com.atguigu.servlet.model;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.servlet.base.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends ViewBaseServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取请求参数
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        //2. 调用业务层处理业务
        UserService userService=new UserServiceImpl();
        User loginUser = userService.login(phone, password);
        //3. 给响应
        if(loginUser!=null){
            // 判断是够勾选了
            String check = request.getParameter("check");
            if(check!=null){
                //将phone和password存储在Cookie内
                Cookie usernameCookie=new Cookie("atguigu_phone",phone);
                Cookie passwordCookie=new Cookie("atguigu_password",password);
                //设置时间默认是30天
                usernameCookie.setMaxAge(60*60*24*30);
                passwordCookie.setMaxAge(60*60*24*30);
                //添加到response中
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
            }
            //将用户添加到会话域内(保持登录状态)
            HttpSession session = request.getSession();
            session.setAttribute("user",loginUser);
            //3.1 如果成功，跳转至登录成功页面
            processTemplate("index",request,response);
        }else{
            //3.2 如果失败，提示错误信息
            request.setAttribute("errMsg","用户名或密码错误");
            processTemplate("login",request,response);
        }
    }
}
