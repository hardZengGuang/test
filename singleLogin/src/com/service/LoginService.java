package com.service;

import com.bean.Account;
import com.dao.LoginDao;
import com.utils.MD5Util;
import com.utils.StringUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class LoginService {
    private  final  static  String  salt2  = "kasdkjh86dkdkf_9dieuyred123la8ldjKhflJF";
    /*
    1.实现 login查询方法 调用dao去模拟数据库map中查询

    2.向数据库map中添加两个用户数据注册
    */
    static {//静态代码块中的代码会在本类被加载的时候执行
        LoginService service = new LoginService();
        service.insert("kgc","123","2016-10-09 12:12:12");
        service.insert("k9503","666","2019-6-11 12:12:12");
    }
    private LoginDao dao=new LoginDao();
    public int insert(String name,String psw,String createTime){
        //创建一个account对象
        Account account = new Account();
        //2,。设置属性 name salt psw createTime
        account.setName(name);
        String salt = MD5Util.MD5Encode(name, "utf-8");
        account.setSalt(salt);
        //原密码拼接两个盐
        psw=psw+"|"+salt+"|"+salt2;
        psw=MD5Util.MD5Encode(psw,"utf-8");
        account.setPsw(psw);

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        try {
            Date ctime = (Date) f.parse(createTime);
            account.setCreateTime(ctime);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dao.insert(account);
    }
    public Account login(String name, String psw) {//登录查询
       Account account= dao.select(name);
        if (account==null){
            return null;
        }
        String psw2=account.getPsw();
        psw=psw+"|"+account.getSalt()+"|"+salt2;
        String psw1= MD5Util.MD5Encode(psw,"utf-8");

        if (StringUtil.isEqual(psw1,psw2)){
            return account;
        }
        return null;
    }
}
