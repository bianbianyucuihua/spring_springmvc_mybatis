package com.hongyi;

import static org.junit.Assert.assertTrue;

import com.hongyi.dao.UserDao;
import com.hongyi.dao.impl.UserDaoImpl;
import com.hongyi.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest{
    @Test
    public void test1(){
        /*
            代理模式做什么事
         */
        InputStream in = AppTest.class.getClassLoader().
                getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);//构建者模式
        UserDaoImpl dao = new UserDaoImpl(factory);
        List<User> all = dao.findAll();
        System.out.println(all);
    }
}
