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
        ApplicationContext ac = new
                ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService bean = (UserService)ac.getBean("userService");
//        bean.getUsers();
        //根据bean的id获取对象，获取的对象是唯一的
        UserDao userDao = (UserDao)ac.getBean("userDao");
        userDao.findAll();
        //根据类型查找对象
        //UserDao bean = ac.getBean(UserDao.class);
        //bean.findAll();
        //根据ID和类型查找
        UserDao dao = ac.getBean("dao", UserDao.class);
        dao.findAll();
    }

    @Test
    public void test2(){
        ApplicationContext ac = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao1 = ac.getBean("userDao", UserDao.class);
        UserDao dao2 = ac.getBean("userDao", UserDao.class);
        System.out.println(dao1);
        System.out.println(dao2);
        System.out.println(dao1==dao2);
    }
    @Test
    public void test3(){
        ApplicationContext ac = new
                ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao dao1 = ac.getBean("userDao", UserDao.class);
//        System.out.println(dao1);
//        ac.close();
    }
    @Test
    public void test4(){
        ApplicationContext ac = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        User user = ac.getBean("user", User.class);
        System.out.println(user);
    }
}
