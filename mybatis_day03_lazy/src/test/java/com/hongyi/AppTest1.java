package com.hongyi;

import com.hongyi.dao.UserDao;
import com.hongyi.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest1 {
    SqlSessionFactory factory;
    @Before
    public void init(){
        InputStream in = AppTest1.class.getClassLoader().
                getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
    }

    @Test
    public void testFindUserAll(){
        SqlSession sqlSession = factory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> all = mapper.findUserAll();
        System.out.println(all);
        sqlSession.close();
        sqlSession = factory.openSession();
        UserDao mapper1 = sqlSession.getMapper(UserDao.class);
        List<User> all1 = mapper1.findUserAll();
        System.out.println(all1);
    }


}
