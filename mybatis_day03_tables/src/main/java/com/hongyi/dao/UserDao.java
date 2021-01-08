package com.hongyi.dao;

import com.hongyi.pojo.User;
import java.util.List;

public interface UserDao {
    public List<User> findUserAll();
    public List<User> findUserAndRole();
}
