package com.hongyi.service.impl;

import com.hongyi.dao.UserDao;
import com.hongyi.dao.impl.UserDaoImpl;
import com.hongyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class UserServiceImpl2 implements UserService{
    private UserDao userDao = new UserDaoImpl();
    public void findAll() {
            userDao.selectAll();
    }
    public void findUserById() {
        userDao.selectUserById();
    }
    public void delUserById() {
        userDao.deleteUserById();
    }
    public void updateUser() {
        userDao.updateUser();
    }
    public void test(){}
}
