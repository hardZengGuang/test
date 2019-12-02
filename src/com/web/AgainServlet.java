package com.web;

import com.service.IMoneyService;
import com.service.impl.MoneyServiceImpl;
import com.utils.JdbcUtil;
import com.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class AgainServlet extends HttpServlet {
    IMoneyService service=new MoneyServiceImpl();
    private PageBean page=new PageBean();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        page = JdbcUtil.mapToBean(PageBean.class, map);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
