package com.hongyi;

import static org.junit.Assert.assertTrue;

import com.hongyi.pojo.User;
import com.hongyi.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void test1(){
        ApplicationContext ac = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ac.getBean("userService", UserService.class);
        List<User> usersAll = userService.findUsersAll();
        System.out.println(usersAll);

    }
}
