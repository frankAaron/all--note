package com.atguigu.servlet;

import com.atguigu.bean.CommonResult;
import com.atguigu.bean.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/jsonTest")
public class JsonTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问到了JsonTestServlet");
        //1. 将普通的JavaBean对象作为响应数据
        User user = new User(1, "admin", "root");
        //将User变成Json字符串（满足Json格式的字符串）
        //采用工具gson(Java端的工具，是一个jar包)
       /* Gson gson = new Gson();
        String s = gson.toJson(user);
        System.out.println(s);//{,,}

        PrintWriter writer = response.getWriter();
        writer.write(s);*/

        //2.将List集合作为响应数据
       /* List<Object> list = new ArrayList<>();
        list.add(new User(1,"admin1","root"));
        list.add(new User(2,"admin2","root"));
        list.add(new User(3,"admin3","root"));

        String s = new Gson().toJson(list);
        System.out.println("s = " + s);//[{},{},{}]
        response.getWriter().write(s);*/

        //3.将Map集合作为响应数据
        /*Map<String , User> map = new HashMap<>();
        map.put("a01",new User(1,"admin1","root"));
        map.put("a02",new User(2,"admin2","root"));
        map.put("a03",new User(3,"admin3","root"));

        String s = new Gson().toJson(map);
        System.out.println("s = " + s);//{a01:{},a02:{},a03:{}}
        response.getWriter().write(s);*/

        //借助统一响应数据模板
        //1.返回普通的字符串
        CommonResult commonResult = CommonResult.ok().setResultData("success");
        //commonResult：flag=true,resultData="success",message=null
        String s = new Gson().toJson(commonResult);
        System.out.println("返回普通字符串：");
        System.out.println("s = " + s);

        //2.返回JavaBean
        User user1 = new User(2, "atguigu", "12345");
        CommonResult commonResult1 = CommonResult.ok().setResultData(user1);
        //commonResult1: flag=true,resultData={id:2,username:atguigu,password:12345}
        String s1 = new Gson().toJson(commonResult1);
        System.out.println("返回JavaBean：");
        System.out.println("s1 = " + s1);




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
