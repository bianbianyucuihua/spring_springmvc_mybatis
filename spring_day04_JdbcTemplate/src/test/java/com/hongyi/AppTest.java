package com.hongyi;

import static org.junit.Assert.assertTrue;

import com.hongyi.dao.AccountDao;
import com.hongyi.pojo.Account;
import com.hongyi.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AppTest{
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private AccountService accountService;
    @Test
    public void test1(){
        List<Account> list = accountDao.selectAll();
        System.out.println(list);
    }
    @Test
    public void test2(){
        Account account = accountDao.selectAccountById(1);
        System.out.println(account);
    }
    @Test
    public void test3(){
        Account account = new Account();
        account.setId(2);
        account.setMoney(900.0);
        int i = accountDao.updateAccountById(account);
        System.out.println(i);
    }
    @Test
    public void test4(){
        boolean b = accountService.transfer(1, 2, 200.0);
        System.out.println(b);
    }
}
