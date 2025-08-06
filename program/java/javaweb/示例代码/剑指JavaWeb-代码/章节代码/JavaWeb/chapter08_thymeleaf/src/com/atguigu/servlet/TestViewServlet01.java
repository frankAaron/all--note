package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/testViewServlet01")
public class TestViewServlet01 extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取到生日的请求参数，计算得出年龄
        String birthday = request.getParameter("birthday");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(birthday, formatter);
        //2. 将年龄存储在请求域内
        int age=LocalDate.now().getYear()-date.getYear();
        request.setAttribute("age",age);
        //3. 通过Thymeleaf渲染页面
        this.processTemplate("info_01",request,response);
    }
}
