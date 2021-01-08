package com.hongyi.dao.impl;

import com.hongyi.dao.UserDao;
import com.hongyi.pojo.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    public List<User> findAll() {
        System.out.println("查询了数据库");
        return null;
    }
}
