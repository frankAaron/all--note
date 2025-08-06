package com.atguigu.servlet;

import com.atguigu.bean.School;
import com.atguigu.bean.Student;
import com.atguigu.bean.Subject;
import com.atguigu.bean.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/testOgnlServlet")
public class TestOgnlServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 创建一个Student对象
        Subject subject=new Subject();
        subject.setSubjectName("java");

        School school01=  new School();
        school01.setSchoolName("XX大学");

        School school02=  new School();
        school02.setSchoolName("尚硅谷");

        List<School> schoolList=new ArrayList<>();
        schoolList.add(school01);
        schoolList.add(school02);

        Teacher teacher01=new Teacher();
        teacher01.setTeacherName("A老师");

        Teacher teacher02=new Teacher();
        teacher02.setTeacherName("B老师");

        Map<String,Teacher> teacherMap=new HashMap<>();
        teacherMap.put("teacher01",teacher01);
        teacherMap.put("teacher02",teacher02);

        Student student=new Student();
        student.setStudentName("小尚同学");
        student.setSubject(subject);
        student.setSchoolList(schoolList);
        student.setTeacherMap(teacherMap);

        //2. 将Student对象共享到请求域内
        request.setAttribute("student",student);

        //3. 通过Thymeleaf渲染页面
        this.processTemplate("info_03",request,response);
    }
}
