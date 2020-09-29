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
import java.io.IOException;
import java.util.List;

public class BooksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("operation");
        if ("list".equals(operation)){
            //进入列表页
            //获取数据
            BooksServiceImpl booksService = new BooksServiceImpl();
            int page = 1;
            int size = 5;
//            if(StringUtils.isNotBlank(request.getParameter("page"))){
//
//            }
            PageInfo all = booksService.finAll(page, size);
            //将数据保存到指定的位置
            request.setAttribute("page",all);
            //跳转页面
            request.getRequestDispatcher("WEB-INF/pages/store/book/list.jsp").forward(request,response);
        }else if ("list".equals(operation)){

        }else if ("list".equals(operation)){

        }else if ("list".equals(operation)){

        }else if ("list".equals(operation)){

        }else if ("list".equals(operation)){

        }else if ("list".equals(operation)){

        }else if ("list".equals(operation)){

        }
    }
//        1.获取请求的用户名
//        String operation = request.getParameter("operation");
//        if("list".equals(operation)){
//            this.list(request,response);
//        }else if("toAdd".equals(operation)){
//            this.toAdd(request,response);
//        }else if("toExamine".equals(operation)){
//            this.toExamine(request,response);
//        }else if("review".equals(operation)){
//            try {
//                this.review(request,response);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else if("save".equals(operation)){
//            try {
//                this.save(request, response);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }else if("toEdit".equals(operation)){
//            this.toEdit(request,response);
//        }else if("edit".equals(operation)){
//            try {
//                this.edit(request,response);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }else if("delete".equals(operation)){
//            this.delete(request,response);
//        }else if("toTestUpload".equals(operation)){
//            this.toTestUpload(request,response);
//        }else if("testUpload".equals(operation)){
//            try {
//                this.testUpload(request,response);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }else if("downloadReport".equals(operation)){
//            this.downloadReport(request,response);
//        }
//    }




//    private void list(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
//        //进入列表页
//        //获取数据
//        int page = 1;
//        int size = 5;
//        if(StringUtils.isNotBlank(request.getParameter("page"))){
//            page = Integer.parseInt(request.getParameter("page"));
//        }
//        if(StringUtils.isNotBlank(request.getParameter("size"))){
//            size = Integer.parseInt(request.getParameter("size"));
//        }
//        PageInfo all = Books.findAll(page, size);
//        //将数据保存到指定的位置
//        request.setAttribute("page",all);
//        //跳转页面
//        request.getRequestDispatcher("/WEB-INF/pages/store/question/list.jsp").forward(request,response);
//
//
//
//
//        //跳转页面
//        request.getRequestDispatcher("/pages/home/main.jsp").forward(request,response);
//
//    }
//
//    private void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //查询要修改的数据findById
//        String id = request.getParameter("id");
//        Question question = BooksService.
//        //将数据加载到指定区域，供页面获取
//        request.setAttribute("question",question);
//
//        List<Company> companyList = companyService.findAll();
//        List<Catalog> catalogList = catalogService.findAll();
//        request.setAttribute("companyList",companyList);
//        request.setAttribute("catalogList",catalogList);
//
//        //跳转页面
//        request.getRequestDispatcher("/WEB-INF/pages/store/question/update.jsp").forward(request,response);
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
