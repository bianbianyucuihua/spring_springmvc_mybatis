package com.hongyi;

import com.hongyi.dao.AccountDao;
import com.hongyi.dao.UserDao;
import com.hongyi.pojo.Account;
import com.hongyi.pojo.User;
import com.hongyi.pojo.User1;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest1 {
    private SqlSession sqlSession;
    @Before
    public void init(){
        InputStream in = AppTest1.class.getClassLoader().
                getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        sqlSession = factory.openSession();
    }
    @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void findAccountAll(){
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        List<Account> accountAll = mapper.findAccountAll();
//        System.out.println(accountAll);
    }



}
