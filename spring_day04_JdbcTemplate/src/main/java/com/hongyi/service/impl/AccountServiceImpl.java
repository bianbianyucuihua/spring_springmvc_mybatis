package com.hongyi.service.impl;

import com.hongyi.dao.AccountDao;
import com.hongyi.pojo.Account;
import com.hongyi.service.AccountService;
import org.springframework.transaction.PlatformTransactionManager;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public boolean transfer(Integer source, Integer target, Double money) {
        Account sourceAccount = accountDao.selectAccountById(source);
        Account targetAccount = accountDao.selectAccountById(target);
        sourceAccount.setMoney(sourceAccount.getMoney()-money);
        targetAccount.setMoney(targetAccount.getMoney()+money);
        int i = accountDao.updateAccountById(sourceAccount);
        int a = 1/0;
        int j = accountDao.updateAccountById(targetAccount);
        return true;
    }
}
