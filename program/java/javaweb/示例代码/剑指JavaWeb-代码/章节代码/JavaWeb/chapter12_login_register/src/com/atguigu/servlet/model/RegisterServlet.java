package com.atguigu.servlet.model;

import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author chenxin
 * @Version 1.0
 */
@WebServlet("/regist")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符编码，防止中文乱码
        request.setCharacterEncoding("UTF-8");
        //1. 获取请求参数
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String nickName = request.getParameter("nickName");
        //2. 调用业务层处理业务
        UserService userService=new UserServiceImpl();
        boolean flag = userService.regist(phone, password,nickName);
        //3. 给响应
        if(flag){
            //3.1 如果成功，跳转至登录页面(由于不需要携带共享数据，所以用重定向)
            response.sendRedirect(request.getContextPath()+"/login.html");
        }else{
            //3.2 如果失败，跳转至原页面(注册页面),按照常理应该将错误提示共享到页面端，由于还未介绍Thymeleaf
            //导致页面端无法获取共享数据，所以暂时省略错误信息提示的功能,暂时也不携带共享数据
            response.sendRedirect(request.getContextPath()+"/register.html");
        }
    }
}
