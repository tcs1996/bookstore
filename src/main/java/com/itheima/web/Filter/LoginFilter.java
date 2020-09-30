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
                if(session.getAttribute("user") == null){//判断用户 session 是否失效
                    String error ="您尚未登录，请先登录";
                    session.setAttribute("error",error);
                    System.out.println(error);
                    //跳转页面
                    request.getRequestDispatcher("login.jsp").forward(request,response);

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
            uriList.add("/login.jsp");
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

