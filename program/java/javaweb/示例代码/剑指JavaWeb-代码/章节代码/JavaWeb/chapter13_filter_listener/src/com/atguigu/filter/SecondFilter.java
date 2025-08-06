package com.atguigu.filter;

import javax.servlet.*;
import java.io.IOException;

public class SecondFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("访问到了SecondFilter...");
        chain.doFilter(req, resp);
        System.out.println("这是SecondFilter放行后的代码");
    }

    public void init(FilterConfig config) throws ServletException {

    }
    public void destroy() {
    }


}
