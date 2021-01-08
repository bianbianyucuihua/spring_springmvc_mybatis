package com.hongyi.dao.impl;

import com.hongyi.dao.UserDao;
import org.springframework.stereotype.Repository;
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void selectAll() {
        System.out.println("查询所有的用户");
    }

    @Override
    public void selectUserById() {
        System.out.println("通过id查询用户");
    }

    @Override
    public void deleteUserById() {
        System.out.println("根据id删除用户");
    }

    @Override
    public void updateUser() {
        System.out.println("更新用户");
    }
}
