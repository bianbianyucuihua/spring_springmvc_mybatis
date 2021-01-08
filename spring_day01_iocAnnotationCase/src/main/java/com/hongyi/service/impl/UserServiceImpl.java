package com.hongyi.service.impl;

import com.hongyi.dao.UserDao;
import com.hongyi.pojo.User;
import com.hongyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public List<User> findUsersAll() {
        return userDao.selectAll();
    }

    public User findUserById(Integer id) {
        return userDao.selectById(id);
    }
}
