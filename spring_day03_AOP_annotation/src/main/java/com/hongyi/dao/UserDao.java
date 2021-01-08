package com.hongyi.dao;

public interface UserDao {
    public void selectAll();

    public void selectUserById();

    public void deleteUserById();

    public void updateUser();
}