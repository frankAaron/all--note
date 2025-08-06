package com.atguigu.servlet.model;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.util.CommonResult;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkUsername")
public class CheckUsernameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        //1. 获取请求参数
        String username = request.getParameter("username");
        //2. 调用业务层处理业务
        UserService userService=new UserServiceImpl();
        User user = userService.checkUsername(username);
        //3. 给响应
        PrintWriter writer = response.getWriter();
        CommonResult commonResult=null;
        if(user==null){
            commonResult=CommonResult.ok();
        }else{
            commonResult=CommonResult.error();
        }

        //将CommonResult写回去
        String s = new Gson().toJson(commonResult);
        System.out.println("s = " + s);//{flag:true/false}
        writer.write(s);
    }

}
