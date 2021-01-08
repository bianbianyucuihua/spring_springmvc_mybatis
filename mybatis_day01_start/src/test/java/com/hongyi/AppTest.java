package com.hongyi;

import static org.junit.Assert.assertTrue;

import com.hongyi.dao.UserDao;
import com.hongyi.pojo.A;
import com.hongyi.pojo.User;
import com.hongyi.pojo.User1;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.util.Date;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest{
    private SqlSession sqlSession;
    private UserDao mapper;
    @Before
    public void init(){
        InputStream in = AppTest.class.getClassLoader().
                getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);//构建者模式
        sqlSession = factory.openSession();//工厂模式
        mapper = sqlSession.getMapper(UserDao.class);//代理模式
    }

    @Test
    public void test1(){
        List<User> all = mapper.findAll();
        System.out.println(all);
    }
    @Test
    public void test2(){
        User user = new User();
        user.setId(41);
        user.setAddress("贵阳");
        int i = mapper.updateUserById(user);
        System.out.println(i);
    }
    @Test
    public void test3(){
        User user = new User();
        user.setUsername("潘进");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("贵阳");
        int i = mapper.insertUser(user);
        System.out.println(i);
    }
    @Test
    public void test4(){
        int i = mapper.deleteUserById(50);
        System.out.println(i);
    }
    @Test
    public void test5(){
        User user = mapper.selectUserById(42);
        System.out.println(user);
    }
    @Test
    public void test6(){
        String name = "王";
//        List<User> users = mapper.findUsersByName("%"+name+"%");
        List<User> users = mapper.findUsersByName(name);
        System.out.println(users);
    }
    @Test
    public void test7(){
        int count = mapper.findCount();
        System.out.println(count);
    }
    @Test
    public void test8(){
        User user = new User();
        user.setUsername("潘进");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("贵阳");
        System.out.println("插入数据之前"+user);
        int i = mapper.insertUser1(user);
        System.out.println(i);
        System.out.println("插入数据之后"+user);
    }

    @Test
    public void test9(){
        List<User1> all = mapper.findUsers1();
        System.out.println(all);
    }

    @Test
    public void test10(){
        User1 user1 = new User1();
        user1.setUid(41);
        user1.setUaddress("遵义");
        int i = mapper.updateUser1ById(user1);
        System.out.println(i);
    }

    @Test
    public void test11(){
        A a = new A();
        User u = new User();
        u.setId(51);
        a.setUser(u);
        User userByA = mapper.findUserByA(a);
        System.out.println(userByA);
    }
    @After
    public void destory(){
        sqlSession.commit();
        sqlSession.close();
    }
}
