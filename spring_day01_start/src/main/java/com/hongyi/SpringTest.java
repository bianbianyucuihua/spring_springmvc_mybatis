package com.hongyi;

import com.hongyi.dao.UserDao;
import com.hongyi.dao.impl.UserDaoImpl;
import com.hongyi.demo.Demo01;
import com.hongyi.demo.Demo02;
import com.hongyi.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringTest {
    @Test
    public void test1(){
        ApplicationContext ac = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        //ApplicationContext ac = new FileSystemXmlApplicationContext("E:\\javaWorkSpace\\intelliJIDEAWorkSpace\\mybatis\\spring_day01_start\\src\\main\\resources\\applicationContext.xml");
        UserService userService = (UserService)ac.getBean("userService");
        System.out.println(userService);
        UserDao userDao = (UserDaoImpl)ac.getBean("userDao");
        System.out.println(userDao);
        Demo01 d = (Demo01) ac.getBean("demo01");
        System.out.println(d);
        Demo02 d2 = (Demo02) ac.getBean("demo02");
        System.out.println(d2);
        d2.show();
    }
}
