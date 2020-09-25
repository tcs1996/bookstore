package com.itheima.web.Filter;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

    /**
     * @author bunuo
     * 1.对所有页面访问进行过滤，除不需要登陆的页面外，其他页面都将被过滤
     * 2.判断session是否超时，session超时将跳转登陆页面
     */
    public class LoginFilter implements Filter {
        /**
         * Default constructor.
         */

        /**
         * @see Filter#destroy()
         */
        public void destroy() {
            // TODO Auto-generated method stub
        }

        /**
         * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
         */
        public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) resp;
            HttpSession session = request.getSession();
            String uri =  request.getRequestURI() ;
            String path = request.getContextPath();
            if(isContain(path,uri)){
                chain.doFilter(request, response);
            }else{
                if(session.getAttribute("userInfo") == null){//判断用户 session 是否失效
                    //session.invalidate();
                    if (request.getHeader("x-requested-with") != null&& request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){//如果是ajax请求响应头会有，x-requested-with；
                        System.out.println("session timeout,please login again.");
                        response.setHeader("sessionstatus", "timeout");//在响应头设置session状态
                        response.getWriter().print("timeout"); //打印一个返回值，没这一行，在tabs页中无法跳出（导航栏能跳出），具体原因不明
                    }else{//普通请求session 超时处理
                        request.getSession().setAttribute("goUrl", request.getRequestURL()+"?"+ request.getQueryString());//记录登陆之前的请求地址
                        System.out.println("session timeout,please login again."+"===="+request.getRequestURI() );
                        response.sendRedirect(request.getContextPath()+"/login.jsp");//将jsp重定向到新的jsp或servlet请求
                    }
                }else{
                    chain.doFilter(request, response);
                }
            }
        }


        /**
         * @see Filter#init(FilterConfig)
         */
        public void init(FilterConfig fConfig) throws ServletException {

        }

        //判断过滤器中是否包含uri中。
        private boolean isContain(String PATH,String uri){
            List<String> uriList = new ArrayList<String>();
            uriList.add("/manage.jsp");
            Iterator<String> iterator = uriList.iterator() ;
            while(iterator.hasNext()){
                String suri = (String)iterator.next() ;
                if(uri.startsWith(PATH+suri)){
                    return true ;
                }else{
                    continue ;
                }
            }
            return false ;
        }
    }

