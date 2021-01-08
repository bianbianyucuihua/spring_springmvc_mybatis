package com.hongyi;

import static org.junit.Assert.assertTrue;

import com.hongyi.dao.UserDao;
import com.hongyi.pojo.User;
import com.hongyi.service.UserService;
import com.hongyi.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ac = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = ac.getBean("userDaoImpl", UserDao.class);
        System.out.println(userDao);
        UserDao userDao1 = ac.getBean("userDaoImpl", UserDao.class);
        System.out.println(userDao1);
        System.out.println(userDao==userDao1);
        ac.close();
    }
    @Test
    public void test2(){
        ClassPathXmlApplicationContext ac = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        User user = ac.getBean("user", User.class);
        System.out.println(user);

    }
    @Test
    public void test3(){
        ClassPathXmlApplicationContext ac = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = ac.getBean("userServiceImpl", UserService.class);
        service.getUsers();

    }
    @Test
    public void test4(){
        ClassPathXmlApplicationContext ac = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = ac.getBean("userServiceImpl1", UserService.class);
        service.getUsers();

    }
}
