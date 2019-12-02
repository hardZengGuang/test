package com.web;

import com.bean.Account;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("你已进入拦截器");
        //没有登录session中没有account对象
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        //2.获得session
        HttpSession session = request.getSession();
        //3.从session中取出account对象
        Account account = (Account) session.getAttribute("account");
        if (account!=null){
            chain.doFilter(req, resp);
        }else {
            response.sendRedirect("SL/jsp/login.jsp");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
