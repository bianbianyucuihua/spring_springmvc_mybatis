package com.hongyi.dao;

import com.hongyi.pojo.User;

import java.util.List;

public interface UserDao {
    //@Select("select * from user")
    public List<User> findAll();
}
