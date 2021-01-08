package com.hongyi.service.impl;

import com.hongyi.dao.UserDao;
import com.hongyi.dao.impl.UserDaoImpl;
import com.hongyi.pojo.User;
import com.hongyi.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public UserServiceImpl(){}
    public List<User> findUsers() {
        return userDao.findAll();
    }
}
