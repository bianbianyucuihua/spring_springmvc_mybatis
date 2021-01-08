package com.hongyi.dao;

import com.hongyi.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public List<User> selectAll();
    public User selectUserById(Integer id);
    public int insertUser(User user);
    public int deleteUserById(Integer id);
    public int updateUser(User user);
}
