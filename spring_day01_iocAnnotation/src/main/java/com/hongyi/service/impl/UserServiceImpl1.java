package com.hongyi.service.impl;

import com.hongyi.dao.UserDao;
import com.hongyi.pojo.User;
import com.hongyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl1 implements UserService {
    @Resource(name="userDaoImpl1")
    private UserDao userDao;

    public List<User> getUsers() {
        System.out.println("getUsers执行了");
        return userDao.findAll();
    }
}
