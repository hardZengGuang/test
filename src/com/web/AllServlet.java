package com.web;

import com.bean.Money;
import com.service.IMoneyService;
import com.service.impl.MoneyServiceImpl;
import com.utils.JdbcUtil;
import com.utils.PageBean;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AllServlet extends javax.servlet.http.HttpServlet {
    IMoneyService service=new MoneyServiceImpl();
    private PageBean page=new PageBean();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        page = JdbcUtil.mapToBean(PageBean.class, map);
        //List<Money> list= service.selectPage(page);
       // List<Money> list=service.selectCount(page);
       List<Money> list=service.selectLikePage(page);
        response.setContentType("text/html;charset=UTF-8");
        request.getSession().setAttribute("page",page);
        request.getSession().setAttribute("list",list);
        request.getRequestDispatcher("/jsp/show.jsp").include(request,response);
}
}
