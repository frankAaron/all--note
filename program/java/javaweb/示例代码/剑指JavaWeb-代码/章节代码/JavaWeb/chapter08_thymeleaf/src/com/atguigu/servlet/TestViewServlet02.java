package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@WebServlet("/testViewServlet02")
public class TestViewServlet02 extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 将日期、字符串、List集合等对象共享在请求域内
        Date date=new Date();
        String str="http://www.atguigu.com";
        List list=new ArrayList();
        list.add("java");
        list.add("javaWeb");

        request.setAttribute("date",date);
        request.setAttribute("str",str);
        request.setAttribute("list",list);

        //2. 通过Thymeleaf渲染页面
        this.processTemplate("info_02",request,response);
    }
}
