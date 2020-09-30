package com.itheima.web.controller;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.Books;
import com.itheima.service.BooksService;
import com.itheima.service.impl.BooksServiceImpl;
import com.sun.org.apache.xml.internal.resolver.Catalog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class BooksServlet extends HttpServlet {
    BooksServiceImpl booksService = new BooksServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("operation");


        if ("list".equals(operation)) {
            this.list(request, response);
        } else if ("toEdit".equals(operation)) {
            this.toEdit(request, response);
        } else if ("edit".equals(operation)) {

            this.edit(request, response);

        } else if  ("delete".equals(operation)){
                this.delete(request,response);
        }
    }


    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //进入列表页
        //获取数据
        int page = 1;
        int size = 5;
//            if(StringUtils.isNotBlank(request.getParameter("page"))){
//
//            }
        PageInfo all = booksService.finAll(page, size);
        //将数据保存到指定的位置
        request.setAttribute("page", all);
        //跳转页面
        request.getRequestDispatcher("WEB-INF/pages/store/book/list.jsp").forward(request, response);
    }


    private void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        2.获取HTTPsession对象
        HttpSession session = request.getSession();
        Integer id = null;
        String id1 = request.getParameter("id");
        System.out.println(id1);

        if (id1 != null) {
            id = Integer.valueOf(id1);
            //获取数据
            //        判断ID是否存在
            if (booksService.findById(id) == null) {
                String error = "该书不存在";
                session.setAttribute("error", error);
                System.out.println(error);
                //跳转页面
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                booksService.findById(id);
                Books book = booksService.findById(id);
                session.setAttribute("book", book);
                //跳转页面
                request.getRequestDispatcher("WEB-INF/pages/store/book/update.jsp").forward(request, response);
            }
        }

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        2.获取HTTPsession对象
        HttpSession session = request.getSession();
        //获取前端返回参数
        Integer id = null;
        id = Integer.valueOf(request.getParameter("id"));
        String name = null;
        name = request.getParameter("name");
        Double price = 0.0;
        price = Double.valueOf(request.getParameter("price"));
        Integer pnum = null;
        pnum = Integer.valueOf(request.getParameter("pnum"));
        String category = null;
        category = request.getParameter("category");
        //赋值给book对象
        Books books = new Books();
        books.setId(id);
        books.setName(name);
        books.setPrice(price);
        books.setPnum(pnum);
        books.setCategory(category);
        booksService.update(books);
        //调用列表方法
        list(request, response);
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = null;
        id = Integer.valueOf(request.getParameter("id"));
        Books books = new Books();
       if (booksService.findById(id)==null){
           System.out.println("该图书不存在");
       }else {
           books = booksService.findById(id);
           booksService.delete(books);
           //调用列表方法
           list(request, response);
       }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
