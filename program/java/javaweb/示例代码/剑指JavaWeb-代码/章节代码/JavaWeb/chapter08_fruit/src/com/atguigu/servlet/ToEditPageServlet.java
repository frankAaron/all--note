package com.atguigu.servlet;

import com.atguigu.common.servlet.ViewBaseServlet;
import com.atguigu.common.util.StringUtil;
import com.atguigu.bean.Fruit;
import com.atguigu.service.FruitService;
import com.atguigu.service.impl.FruitServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit.html")
public class ToEditPageServlet extends ViewBaseServlet {

    private FruitService fruitService=new FruitServiceImpl();

    @Override
    public void doGet(HttpServletRequest request , HttpServletResponse response)throws IOException, ServletException {
        //获取水果id
        String fidStr = request.getParameter("fid");

        if(StringUtil.isNotEmpty(fidStr)){
            int fid = Integer.parseInt(fidStr);

            //根据id获取水果信息
            Fruit fruit = fruitService.getFruitByFid(fid);
            request.setAttribute("fruit",fruit);
            //跳转页面
            this.processTemplate("edit",request,response);
        }
    }
}
