package com.hongyi.service.impl;

import com.hongyi.dao.UserDao;
import com.hongyi.pojo.User;
import com.hongyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userDaoImpl1")
    private UserDao userDao;

    public UserServiceImpl(){}

    /*public UserServiceImpl(@Autowired UserDao userDaoImpl){
        this.userDao=userDaoImpl;
    }*/
/*    @Autowired
    public UserServiceImpl(UserDao userDaoImpl){
        this.userDao=userDaoImpl;
    }*/
    public List<User> getUsers() {
        System.out.println("getUsers执行了");
        return userDao.findAll();
    }
}
