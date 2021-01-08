package com.hongyi;

import static org.apache.ibatis.ognl.DynamicSubscript.all;
import static org.junit.Assert.assertTrue;

import com.hongyi.dao.AccountDao;
import com.hongyi.dao.UserDao;
import com.hongyi.pojo.Account;
import com.hongyi.pojo.AccountUser;
import com.hongyi.pojo.User;
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
public class AppTest {
    private SqlSession sqlSession;
    @Before
    public void init(){
        InputStream in = AppTest.class.getClassLoader().
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
    public void testFindUserAll(){
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> all = mapper.findUserAll();
        for (User u:all) {
            System.out.println(u);
        }

    }
    @Test
    public void testFindAccountAll(){
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        List<Account> all = mapper.findAccountAll();
        System.out.println(all);

    }
    @Test
    public void testFindAccountUserAll(){
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        List<AccountUser> all = mapper.findAccountUserAll();
        for (AccountUser au:all) {
            System.out.println(au);
        }
    }
    @Test
    public void testFindUserRoleAccountAll(){
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> all = mapper.findUserAndRole();
        for (User au:all) {
            System.out.println(au);
        }
    }
}
