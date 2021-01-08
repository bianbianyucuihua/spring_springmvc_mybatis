package com.hongyi.service.impl;

import com.hongyi.dao.UserDao;
import com.hongyi.service.UserService;
import com.hongyi.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl1 implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void findAll() {
        userDao.selectAll();
    }
    @Override
    public void findUserById() {
        userDao.selectUserById();
    }
    @Override
    public void delUserById() {
        userDao.deleteUserById();
    }
    @Override
    public void updateUser() {
        userDao.updateUser();
    }
}
