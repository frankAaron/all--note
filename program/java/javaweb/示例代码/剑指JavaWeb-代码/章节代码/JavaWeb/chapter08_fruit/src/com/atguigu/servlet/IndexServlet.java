package com.atguigu.servlet;

import com.atguigu.common.servlet.ViewBaseServlet;
import com.atguigu.bean.Fruit;
import com.atguigu.service.FruitService;
import com.atguigu.service.impl.FruitServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//Servlet从3.0版本开始支持注解方式的注册
@WebServlet("/index.html")
public class IndexServlet extends ViewBaseServlet {

    private FruitService fruitService=new FruitServiceImpl();

    @Override
    public void doGet(HttpServletRequest request , HttpServletResponse response)throws IOException, ServletException {
        //获取所有水果信息
        List<Fruit> fruitList = fruitService.getFruitList();
        System.out.println("fruitList = " + fruitList);

        //将水果信息保存到请求域
        request.setAttribute("fruitList",fruitList);

        //跳转页面

        //此处的视图名称是 index
        //那么thymeleaf会将这个 逻辑视图名称 对应到 物理视图 名称上去
        //逻辑视图名称 ：   index
        //物理视图名称 ：   view-prefix + 逻辑视图名称 + view-suffix
        //所以真实的视图名称是：      /       index       .html
        this.processTemplate("index",request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
