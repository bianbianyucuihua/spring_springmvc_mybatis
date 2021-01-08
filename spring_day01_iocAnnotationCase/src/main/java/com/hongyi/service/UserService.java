package com.hongyi.service;

import com.hongyi.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> findUsersAll();
    public User findUserById(Integer id);
}
