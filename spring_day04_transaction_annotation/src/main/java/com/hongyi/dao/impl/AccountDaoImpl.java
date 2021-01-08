package com.hongyi.dao.impl;

import com.hongyi.dao.AccountDao;
import com.hongyi.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> selectAll() {
        String sql = "select * from account";
        List<Account> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class));
        return list;
    }

    @Override
    public Account selectAccountById(Integer id) {
        String sql = "select * from account where id=?";
        List<Account> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class),id);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public int updateAccountById(Account account) {
        String sql = "update account set money=? where id=?";
        int update = jdbcTemplate.update(sql, account.getMoney(), account.getId());
        return update;
    }
}
