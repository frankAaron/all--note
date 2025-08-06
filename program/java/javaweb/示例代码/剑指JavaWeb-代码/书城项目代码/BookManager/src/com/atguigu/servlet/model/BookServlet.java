package com.atguigu.servlet.model;

import com.atguigu.bean.Book;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.servlet.base.ViewBaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/book")
public class BookServlet extends ViewBaseServlet {

    private BookService bookService=new BookServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method.equals("findAll")){
            findAll(request, response);
        }else if(method.equals("book_add.html")){
            toAddPage(request,response);
        }else if(method.equals("add")){
            add(request, response);
        }else if(method.equals("edit.html")){
            toEditPage(request, response);
        }else if(method.equals("update")){
            update(request, response);
        }else if(method.equals("delete")){
            delete(request, response);
        }
    }

    protected void toAddPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        processTemplate("manager/book_add",request,response);
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> all = bookService.findAll();
        request.setAttribute("books",all);
        processTemplate("manager/book_manager",request,response);
    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Book book=new Book();
        try {
            BeanUtils.populate(book,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        bookService.insert(book);
        response.sendRedirect(request.getContextPath()+"/book?method=findAll");
    }

    protected void toEditPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Book book = bookService.getById(Integer.parseInt(id));
        request.setAttribute("book",book);
        processTemplate("manager/book_edit",request,response);
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Book book=new Book();
        try {
            BeanUtils.populate(book,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        bookService.update(book);

        response.sendRedirect(request.getContextPath()+"/book?method=findAll");
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        bookService.delete(Integer.parseInt(id));
        response.sendRedirect(request.getContextPath()+"/book?method=findAll");
    }
}
