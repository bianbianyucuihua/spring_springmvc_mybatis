package com.hongyi.service.impl;

import com.hongyi.dao.AccountDao;
import com.hongyi.pojo.Account;
import com.hongyi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;


    @Override
    @Transactional(propagation = Propagation.REQUIRED )
    public boolean transfer(Integer source, Integer target, Double money) {
        Account sourceAccount = accountDao.selectAccountById(source);
        Account targetAccount = accountDao.selectAccountById(target);
        sourceAccount.setMoney(sourceAccount.getMoney()-money);
        targetAccount.setMoney(targetAccount.getMoney()+money);
        int i = accountDao.updateAccountById(sourceAccount);
        //int a = 1/0;
        int j = accountDao.updateAccountById(targetAccount);
        return true;
    }

}
