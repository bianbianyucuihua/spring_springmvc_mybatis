package com.hongyi.dao;

import com.hongyi.pojo.Account;

import java.util.List;

public interface AccountDao {
    public List<Account> selectAll();
    public Account selectAccountById(Integer id);
    public int updateAccountById(Account account);

}
