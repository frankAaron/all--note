package com.atguigu.servlet;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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
            //3.1 如果成功，跳转至首页
            response.sendRedirect(request.getContextPath()+"/index.html");
        }else{
            //3.2 如果失败，跳转至原页面(登录页面)
            response.sendRedirect(request.getContextPath()+"/login.html");
        }
    }
}
