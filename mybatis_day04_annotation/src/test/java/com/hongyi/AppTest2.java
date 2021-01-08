package com.hongyi;

import com.hongyi.dao.AccountDao;
import com.hongyi.pojo.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest2 {
    private SqlSessionFactory factory;
    @Before
    public void init(){
        InputStream in = AppTest2.class.getClassLoader().
                getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
    }
    @Test
    public void findAccountByUserId(){
        SqlSession sqlSession = factory.openSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        List<Account> accountByUserId = mapper.findAccountByUserId(54);
        sqlSession.close();
        sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(AccountDao.class);
        accountByUserId = mapper.findAccountByUserId(54);
        sqlSession.close();
    }
    @Test
    public void findAccountAll(){
        SqlSession sqlSession = factory.openSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        List<Account> accountAll = mapper.findAccountAll();
        sqlSession.close();
        sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(AccountDao.class);
        accountAll = mapper.findAccountAll();
        sqlSession.close();
    }



}
