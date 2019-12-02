package com.service.impl;

import com.bean.Money;
import com.dao.IMoneyDao;
import com.dao.impl.MoneyDaoImpl;
import com.service.IMoneyService;
import com.utils.PageBean;

import java.util.List;

public class MoneyServiceImpl implements IMoneyService {

    IMoneyDao dao=new MoneyDaoImpl();
    @Override
    public List<Money> selectAll(PageBean page) {
        int count=dao.selectCont();
        int totalPage=(count%2==0)?(count/2):(count/2+1);
        page.setTotalPage(totalPage);
        page.setCount(count);
        return dao.selectAll( page);
    }

  /*  @Override
    public List<Money>  selectPage(PageBean page) {
        int count=dao.selectCont();
        int totalPage=(count%2==0)?(count/2):(count/2+1);
        page.setTotalPage(totalPage);
        page.setCount(count);
        return dao.selectPage(page);
    }*/

    @Override
    public List<Money>  selectCount(PageBean page) {
        int count=dao.selectCont();
        int totalPage=(count%2==0)?(count/2):(count/2+1);
        page.setTotalPage(totalPage);
        page.setCount(count);
        return dao.selectCount(page);
    }

    @Override
    public List<Money> selectLikePage(PageBean page) {
        int count=dao.selectLikeCont(page);
        int totalPage=(count%2==0)?(count/2):(count/2+1);
        page.setTotalPage(totalPage);
        page.setCount(count);
        return dao.selectLikePage(page);
    }


    }





