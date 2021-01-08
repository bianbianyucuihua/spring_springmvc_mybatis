package com.hongyi.dao;

import com.hongyi.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
}
