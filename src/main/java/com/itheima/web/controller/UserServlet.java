package com.itheima.web.controller;

import com.itheima.domain.User;
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

//        初始化用户名及密码
        String username = null;
        String password = null;
//        1.获取请求的用户名及密码
         username = request.getParameter("username");
         password = request.getParameter("password");
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        UserServiceImpl userService = new UserServiceImpl();
//        2.获取HTTPsession对象
        HttpSession session = request.getSession();

//        判断用户是否存在
        if (userService.findByUsername(username)==null){
            String error ="用户不存在";
            session.setAttribute("error",error);
            System.out.println(error);
                    //跳转页面
        request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        else if (username.equals(userService.findByUsername(username).getUsername())&& password.equals(userService.findByUsername(username).getPassword())){
            //将用户名信息添加到共享信息
            session.setAttribute("user",user);
            request.getRequestDispatcher("/pages/home/main.jsp").forward(request,response);
        }else {
            String login_msg ="用户名或密码错误";
            session.setAttribute("login_msg",login_msg);
            System.out.println(login_msg);
            //跳转页面
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
