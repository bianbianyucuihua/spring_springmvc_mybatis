package com.hongyi;

import static org.junit.Assert.assertTrue;

import com.hongyi.dao.UserDao;
import com.hongyi.pojo.User;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void test1(){
        InputStream in = AppTest.class.
                getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
//        user.setUsername("潘进");
//        user.setAddress("贵阳");
        user.setSex("男");
        List<User> all = mapper.findUsers(user);
        System.out.println(all);
        sqlSession.close();
    }

    @Test
    public void test2(){
        InputStream in = AppTest.class.
                getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = null;
        List<User> all = mapper.findUsers1(user);
        System.out.println(all);
        sqlSession.close();
    }
    @Test
    public void test3(){
        InputStream in = AppTest.class.
                getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setId(51);
        user.setUsername("前夫");
        user.setSex("男");
        int i = mapper.updateUserById(user);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test4(){
        InputStream in = AppTest.class.
                getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<Integer> list = new ArrayList<Integer>();
        int i = mapper.deleteUserByIds(list);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
}
