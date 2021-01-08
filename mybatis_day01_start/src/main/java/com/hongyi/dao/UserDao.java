package com.hongyi.dao;

import com.hongyi.pojo.A;
import com.hongyi.pojo.User;
import com.hongyi.pojo.User1;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    //@Select("select * from user")
    public List<User> findAll();
    public int updateUserById(User user);
    public int insertUser(User user);
    public int deleteUserById(int id);
    public User selectUserById(Integer id);
    public List<User> findUsersByName(String name);
    public int findCount();
    public int insertUser1(User user);
    public List<User1> findUsers1();
    public int updateUser1ById(User1 user1);
    public User findUserByA(A a);
}
