package com.atguigu.servlet.model;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.servlet.base.ViewBaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/regist")
public class RegistServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService=new UserServiceImpl();
        //1. 获取请求参数
        //1.1 获取用户的信息数据
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user=new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //1.2 获取验证码数据
        String code = request.getParameter("code");
        System.out.println("用户输入验证码："+code);
        //从session中根据KAPTCHA_SESSION_KEY获取正确验证码
        Object kaptcha_session_key = request.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        System.out.println("正确验证码 ： " + kaptcha_session_key);

        boolean regist=false;
        if(code.equals(kaptcha_session_key)){
            //验证码正确
            //2. 调用业务层处理业务
            regist = userService.regist(user);
        }
        //3. 给响应
        if(regist){
            processTemplate("user/regist_success",request,response);
        }else{
            request.setAttribute("codeErrMsg","验证码错误");
            processTemplate("user/regist",request,response);
        }
    }

}
