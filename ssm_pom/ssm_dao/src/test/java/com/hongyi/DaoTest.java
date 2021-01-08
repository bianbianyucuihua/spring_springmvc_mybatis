package com.hongyi;

import com.hongyi.dao.UserDao;
import com.hongyi.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {
    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        User user = userDao.selectUserById(10000);
        System.out.println(user);
    }
}
