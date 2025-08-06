package com.atguigu.servlet;

import com.atguigu.bean.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/employeeServlet")
public class EmployeeServlet extends ViewBaseServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1.创建ArrayList对象并填充
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(1, "tom", 500.00));
        employeeList.add(new Employee(2, "jerry", 600.00));
        employeeList.add(new Employee(3, "harry", 700.00));

        // 2.将集合数据存入请求域
        request.setAttribute("employeeList", employeeList);

        // 3.调用父类方法渲染视图
        super.processTemplate("list", request, response);
    }

}
