package com.atguigu.servlet.model;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.servlet.base.ViewBaseServlet;
import com.atguigu.util.CommonResult;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user")
public class UserServlet extends ViewBaseServlet {

    private UserService userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取method请求参数
        String method = request.getParameter("method");
        //进行判断
        if(method.equals("regist.html")){
            toRegistPage(request, response);
        }else if(method.equals("checkUsername")){
            checkUsername(request, response);
        }else if(method.equals("regist")){
            regist(request, response);
        }else if(method.equals("login.html")){
            toLoginPage(request, response);
        }else if(method.equals("login")){
            login(request, response);
        }else if(method.equals("logout")){
            logout(request, response);
        }
    }

    protected void toRegistPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processTemplate("user/regist",request,response);
    }
    protected void checkUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1. 获取请求参数
        String username = request.getParameter("username");
        //2. 调用业务层处理业务
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
    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    protected void toLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processTemplate("user/login",request,response);
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //调用业务层进行登录功能操作
        User user = userService.login(username, password);
        //根据user是否有值判断登录是否成功
        if(user!=null){
            request.getSession().setAttribute("user",user);
            processTemplate("user/login_success",request,response);
        }else{
            request.setAttribute("errMsg","用户名或密码错误");
            processTemplate("user/login",request,response);
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("user");
        response.sendRedirect(request.getContextPath()+"/index.html");
    }
}
