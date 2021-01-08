package com.hongyi.servlet;

import com.hongyi.service.UserService;
import com.hongyi.service.impl.UserServiceImpl;
import com.hongyi.util.SpringContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServlet {
    public static void main(String[] args) {
//        UserService service = new UserServiceImpl();
//        service.findUsers();
        SpringContext sc = new SpringContext("beans.properties");
        UserServiceImpl userService = (UserServiceImpl)sc.getBean("userService");
        userService.findUsers();

    }
}
