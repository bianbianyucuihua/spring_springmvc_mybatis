package com.hongyi.dao;

import com.hongyi.pojo.Account;
import com.hongyi.pojo.User;

import java.util.List;

public interface AccountDao {
    public List<Account> findAccountAll();

    public List<Account> findAccountByUserId(Integer id);
}
