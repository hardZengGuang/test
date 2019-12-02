package com.service;

import com.bean.Money;
import com.utils.PageBean;

import java.util.List;

public interface IMoneyService {
    List<Money> selectAll(PageBean page);

   // List<Money>  selectPage(PageBean page);

   List<Money> selectCount(PageBean page);

    List<Money> selectLikePage(PageBean page);




}
