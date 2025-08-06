package com.atguigu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/order")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1. 检查本次请求是否处于登录状态
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        try {
            request = (HttpServletRequest) req;
            response = (HttpServletResponse) resp;
        } catch (Exception e) {
            throw new RuntimeException();
        }

        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if(user==null){
            //说明不处于登录状态(跳转至登录页面)
            response.sendRedirect(request.getContextPath()+"/user?method=login.html");
        }else{
            //说明处于登录状态
            chain.doFilter(req, resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
