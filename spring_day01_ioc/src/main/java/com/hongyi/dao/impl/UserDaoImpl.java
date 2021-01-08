package com.hongyi.dao.impl;

import com.hongyi.dao.UserDao;
import com.hongyi.pojo.User;

import java.util.List;

public class UserDaoImpl implements UserDao {

    public UserDaoImpl(){
        System.out.println("执行了无参的构造方法");
    }

    public void init(){
        System.out.println("初始化方法init");
    }

    public void destory(){
        System.out.println("销毁方法destory");
    }

    public List<User> findAll() {
        System.out.println("查询了所有用户");
        return null;
    }
}
