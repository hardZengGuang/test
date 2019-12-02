package com.dao;

import com.bean.Money;
import com.utils.PageBean;

import java.util.List;

public interface IMoneyDao {
    List<Money> selectAll(PageBean page);

   // List<Money>  selectPage(PageBean page);

    List<Money>  selectCount(PageBean page);

    int selectCont();

    int selectLikeCont(PageBean page);//查询总记录数


    List<Money> selectLikePage(PageBean page);//

}
