package com.hongyi;

import com.hongyi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Test01 {
    @Autowired
    private  UserService userService;
    @Test
    public void test1(){
        userService.findAll();
        userService.findUserById();
        userService.delUserById(1);
        userService.updateUser();
    }
}
