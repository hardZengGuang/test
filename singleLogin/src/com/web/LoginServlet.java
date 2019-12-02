package com.web;

import com.bean.Account;
import com.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private LoginService service=new LoginService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1.取参数： name psw
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String psw=request.getParameter("psw");
        //2.调用service  查询
        Account account=service.login(name,psw);

        //3.存session
        if (account!=null){
            HttpSession session = request.getSession();
            session.setAttribute("account",account);
            //4.跳转
            response.sendRedirect("/SL/jsp/success.jsp");
        }else {
            response.sendRedirect("/SL/jsp/faile.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
