package com.hongyi.dao;

import com.hongyi.pojo.User;
import java.util.List;

public interface UserDao {
    public List<User> findAll(String name);
    public List<User> findUsers(User user);
    public List<User> findUsers1(User user);
    public int updateUserById(User user);
    public int deleteUserByIds(List<Integer> ids);
}
