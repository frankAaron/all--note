package com.atguigu.servlet;

import com.atguigu.common.servlet.ViewBaseServlet;
import com.atguigu.common.util.StringUtil;
import com.atguigu.service.FruitService;
import com.atguigu.service.impl.FruitServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/del")
public class DelServlet extends ViewBaseServlet {
    private FruitService fruitService=new FruitServiceImpl();

    @Override
    public void doGet(HttpServletRequest request , HttpServletResponse response)throws IOException, ServletException {
        //获取水果id
        String fidStr = request.getParameter("fid");
        if(StringUtil.isNotEmpty(fidStr)){
            int fid = Integer.parseInt(fidStr);
            //根据id删除水果
            fruitService.delFruit(fid);
            //重定向到首页
            response.sendRedirect("index.html");
        }
    }
}
