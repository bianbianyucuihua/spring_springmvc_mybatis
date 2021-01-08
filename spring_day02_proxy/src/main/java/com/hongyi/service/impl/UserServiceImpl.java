package com.hongyi.service.impl;

import com.hongyi.dao.UserDao;
import com.hongyi.service.UserService;
import com.hongyi.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private LogUtil log;

    @Override
    public void findAll() {
        log.start();
        userDao.selectAll();
        log.end();
    }

    @Override
    public void findUserById() {
        log.start();
        userDao.selectUserById();
        log.end();
    }

    @Override
    public void delUserById() {
        log.start();
        userDao.deleteUserById();
        log.end();
    }

    @Override
    public void updateUser() {
        log.start();
        userDao.updateUser();
        log.end();
    }
}
