package com.hongyi;

import static org.junit.Assert.assertTrue;

import com.hongyi.dao.AccountDao;
import com.hongyi.dao.UserDao;
import com.hongyi.pojo.Account;
import com.hongyi.pojo.User;
import com.hongyi.pojo.User1;
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
        System.out.println(all);
    }
    @Test
    public void SelectUserById(){
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.SelectUserById(41);
        System.out.println(user);
    }
    @Test
    public void InsertUser(){
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setUsername("mybatis");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("mybatis home");
        int i = mapper.insertUser(user);
        System.out.println(i);
        System.out.println(user);
    }
    @Test
    public void UpdateUser(){
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setId(55);
        user.setUsername("mybatis annotation");
        user.setSex("女");
        user.setBirthday(new Date());
        user.setAddress("mybatis home");
        int i = mapper.updateUser(user);
        System.out.println(i);
    }
    @Test
    public void deleteUserById(){
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int i = mapper.deleteUserById(53);
        System.out.println(i);
    }
    @Test
    public void selectCount(){
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int i = mapper.selectCount();
        System.out.println(i);
    }
    @Test
    public void selectUserByName(){
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        String name ="王";
        List<User> users = mapper.selectUserByName(name);
        System.out.println(users);
    }

    @Test
    public void testFindUser1All(){
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User1> all = mapper.findUser1All();
        System.out.println(all);
    }
    @Test
    public void testFindUser1ById(){
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User1 user1ById = mapper.findUser1ById(55);
        System.out.println(user1ById);
    }
}
