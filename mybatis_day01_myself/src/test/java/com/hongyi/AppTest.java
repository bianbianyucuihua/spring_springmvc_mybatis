package com.hongyi;

import static org.junit.Assert.assertTrue;

import com.hongyi.dao.UserDao;
import com.hongyi.mybatis.SqlSession;
import com.hongyi.mybatis.SqlSessionFactory;
import com.hongyi.mybatis.SqlSessionFactoryBuilder;
import com.hongyi.pojo.User;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest{
    @Test
    public void test1(){
        InputStream in = AppTest.class.getClassLoader().
                getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);//构建者模式
        SqlSession sqlSession = factory.openSession();//工厂模式
        UserDao mapper = sqlSession.getMapper(UserDao.class);//代理模式
        List<User> all = mapper.findAll();
        System.out.println(all);
    }
}
