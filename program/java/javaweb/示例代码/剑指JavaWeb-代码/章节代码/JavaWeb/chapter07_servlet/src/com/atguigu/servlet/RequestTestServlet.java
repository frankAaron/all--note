package com.atguigu.servlet;

import com.atguigu.bean.User;
import org.apache.commons.beanutils.BeanUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/requestTest")
public class RequestTestServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问到了doGet方法...");
       /* //1.获取url信息
        //获取主机名
        String serverName = request.getServerName();
        System.out.println("serverName = " + serverName);
        //获取端口号
        int serverPort = request.getServerPort();
        System.out.println("serverPort = " + serverPort);
        //获取协议
        String scheme = request.getScheme();
        System.out.println("scheme = " + scheme);
        //获取上下文路径(※)
        String contextPath = request.getContextPath();
        System.out.println("contextPath = " + contextPath);

        //2.获取请求头信息
        //获得user-Agent信息
        String userAgent = request.getHeader("User-Agent");
        System.out.println("userAgent = " + userAgent);
        //获得referer请求源
        String referer = request.getHeader("Referer");
        System.out.println("referer = " + referer);

        //3.获取请求方式
        String method = request.getMethod();
        System.out.println("method = " + method);

        //4.获取请求参数（无论是在网址栏拼接，还是在请求体，如下方式都可以获取到）
        //获取单个值
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        String password = request.getParameter("password");
        System.out.println("password = " + password);

        //获取多个值
        String[] soccerTeams = request.getParameterValues("soccerTeam");
        System.out.println(Arrays.toString(soccerTeams));*/

        //获取表单提交的数据
/*        String username = request.getParameter("username");
        System.out.println("username = " + username);

        String password = request.getParameter("password");
        System.out.println("password = " + password);

        String email = request.getParameter("email");
        System.out.println("email = " + email);

        String[] hobbies = request.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));

        //实例化一个User对象，将数据注入到User对象内
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setHobby(hobbies);
        System.out.println("user = " + user);
*/
        Map<String, String[]> map = request.getParameterMap();
        /*//遍历map集合
        //1.获取所有的key值
        Set<String> strings = map.keySet();
        for (String string : strings) {
            System.out.println("string = " + string);
        }
        System.out.println("---------------------------");
        //2.获取所有的value值
        Collection<String[]> values = map.values();
        for (String[] value : values) {
            System.out.println(Arrays.toString(value));
        }
        System.out.println("---------------------------");
        //3.获取所有的键值对
        Set<Map.Entry<String, String[]>> entries = map.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            System.out.println("entry = " + entry);
        }*/

        //实例化一个User对象
        User user = new User();
        try {
            //使用BeanUtils中的静态方法populate，将map集合内的数据注入到user对象内
            BeanUtils.populate(user,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //展示结果
        System.out.println("user = " + user);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Web阶段，不区分get和post请求，两者处理方式一致
        System.out.println("访问到了doPost方法...");
        doGet(request,response);
    }
}
