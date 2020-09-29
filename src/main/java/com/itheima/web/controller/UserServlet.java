package com.itheima.web.controller;

import com.itheima.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.获取请求的用户名
        String username = request.getParameter("username");
        System.out.println(username);
        UserServiceImpl userService = new UserServiceImpl();

//        2.获取HTTPsession对象
        HttpSession session = request.getSession();

//            3.将用户名信息添加到共享信息
//        session.setAttribute("user");
        //跳转页面
        request.getRequestDispatcher("/pages/home/main.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
