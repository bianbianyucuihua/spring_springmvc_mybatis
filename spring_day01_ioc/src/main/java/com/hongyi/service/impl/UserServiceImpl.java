package com.hongyi.service.impl;

import com.hongyi.dao.UserDao;
import com.hongyi.pojo.User;
import com.hongyi.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao){
        this.userDao=userDao;
    }
    public List<User> getUsers() {
        System.out.println("getUsers执行了");
        return userDao.findAll();
    }
}
