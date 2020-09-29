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


        if ("list".equals(operation)){
            this.list(request,response);
        }else if ("toEdit".equals(operation)){
            this.toEdit(request,response);
        }else if("edit".equals(operation)){

                this.edit(request,response);

        }else if ("list".equals(operation)){

        }else if ("list".equals(operation)){

        }else if ("list".equals(operation)){

        }else if ("list".equals(operation)){

        }else if ("list".equals(operation)){

        }
    }





    private void list(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //进入列表页
        //获取数据
        int page = 1;
        int size = 5;
//            if(StringUtils.isNotBlank(request.getParameter("page"))){
//
//            }
        PageInfo all = booksService.finAll(page, size);
        System.out.println(4564);
        //将数据保存到指定的位置
        request.setAttribute("page",all);
        System.out.println(123);
        //跳转页面
        request.getRequestDispatcher("WEB-INF/pages/store/book/list.jsp").forward(request,response);
    }


    private void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        2.获取HTTPsession对象
        HttpSession session = request.getSession();
        Integer id = null;
        String id1 = request.getParameter("id");
        System.out.println(id1);

        if (id1 !=null){
            id = Integer.valueOf(id1);
            //获取数据
//                booksService.findById(id);
            //        判断ID是否存在
            if (booksService.findById(id)==null){
                String error ="该书不存在";
                session.setAttribute("error",error);
                System.out.println(error);
                //跳转页面
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
            else {
                booksService.findById(id);
                Books book = booksService.findById(id);
                session.setAttribute("book",book);
                //跳转页面
                request.getRequestDispatcher("WEB-INF/pages/store/book/update.jsp").forward(request,response);
            }
        }else {
            System.out.println("没有ID相关处理");
        }

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        2.获取HTTPsession对象
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        System.out.println(id);
        String name = request.getParameter("name");
        System.out.println(name);
        String price = request.getParameter("price");
        System.out.println(price);
        String pnum = request.getParameter("pnum");
        System.out.println(pnum);
        String category = request.getParameter("category");
        System.out.println(category);

        Books books = new Books();

        booksService.update(books);

        //跳转页面
        request.getRequestDispatcher("WEB-INF/pages/store/book/list.jsp").forward(request,response);

//        if (id1 !=null){
//            id = Integer.valueOf(id1);
//            //获取数据
////                booksService.findById(id);
//            //        判断ID是否存在
//            if (booksService.findById(id)==null){
//                String error ="该书不存在";
//                session.setAttribute("error",error);
//                System.out.println(error);
//                //跳转页面
//                request.getRequestDispatcher("login.jsp").forward(request,response);
//            }
//            else {
//                booksService.findById(id);
//                Books book = booksService.findById(id);
//                session.setAttribute("book",book);
//                //跳转页面
//                request.getRequestDispatcher("WEB-INF/pages/store/book/update.jsp").forward(request,response);
//            }
//        }else {
//            System.out.println("没有ID相关处理");
//        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
