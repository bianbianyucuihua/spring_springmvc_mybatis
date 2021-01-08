package com.hongyi.service;


import com.hongyi.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findUserById(Integer id);
    public int addUser(User user);
    public int delUserById(Integer id);
    public int updateUser(User user);
}
