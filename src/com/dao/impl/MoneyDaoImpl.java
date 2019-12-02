package com.dao.impl;

import com.bean.Money;
import com.dao.IMoneyDao;
import com.utils.JdbcUtil;
import com.utils.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class MoneyDaoImpl implements IMoneyDao {
    @Override
    public List<Money> selectAll(PageBean page) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {
            return qr.query("select * from money", new BeanListHandler<Money>(Money.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



  /*  @Override
    public List<Money>  selectPage(PageBean page) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {
            String sql="select * from money where 1=1 ";
            if (page.getDange()!=null&&!page.getDange().equals("0")){
                sql+= " and dange ='%"+page.getDange()+"%'";
            }
           *//* if (page.getId()!=null&&!page.getId().equals(" ")){
                sql+=" and id ='"+page.getId()+"'";
            }*//*
            return qr.query(sql ,new BeanListHandler<Money>(Money.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

    @Override//分页查询
    public List<Money> selectCount(PageBean page) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {
            int startRow = (page.getCurrPage() - 1) * page.getSize();
            return qr.query("select * from money limit ?,? ", new BeanListHandler<Money>(Money.class), startRow, page.getSize());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override//分页查询
    public int selectCont() {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {

            return qr.query("select count(*) from money", new ScalarHandler<Long>()).intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int selectLikeCont(PageBean page) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {
            String sql = "select * from money where 1=1 ";
            if (page.getId()!= null && !page.getId().equals("0")) {
                sql += " and id like "+ page.getId();
            }
            if (page.getDange()!= null && !page.getDange().equals("0")) {
                sql += " and dange like '%" + page.getDange() + "%'";
            }
            return qr.query(sql, new ScalarHandler<Long>()).intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override//分页模糊
    public List<Money> selectLikePage(PageBean page) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());

        int startRow = (page.getCurrPage() - 1) * page.getSize();
        String sql = "select * from money where 1=1 ";
        if (page.getId()!= null && !page.getId().equals("null")) {
            sql += " and id like" + page.getId() ;
        }
        if (page.getDange()!= null && !page.getDange().equals("0")) {
            sql += " and dange like'%" + page.getDange() + "%'";
        }
        sql += " limit ?,?";

        try {
            return qr.query(sql, new BeanListHandler<Money>(Money.class), startRow, page.getSize());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}