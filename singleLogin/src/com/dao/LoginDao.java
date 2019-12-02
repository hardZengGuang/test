package com.dao;

import com.bean.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/*
1.模拟的数据库
2.实现新增
3.实现查询
*/

public class LoginDao {
    private static Map<String,Account> map = new HashMap<String, Account>();//模拟数据库
    private static AtomicInteger id=new AtomicInteger(0);//模拟自增长
    public int insert(Account account) {
        if (!map.containsKey(account.getName())){
            account.setId(id.incrementAndGet());//实现id自增长并返回id
            map.put(account.getName(),account);
            return account.getId();
        }
        return 0;
    }
//查询key得到value
    public Account select(String name) {
        return map.get(name);
    }
}
