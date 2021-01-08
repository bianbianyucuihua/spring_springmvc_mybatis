package com.hongyi;

import com.hongyi.service.UserService;
import config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:applicationContext.xml")
@ContextConfiguration(classes = AppConfig.class)
public class Test02 {
    @Autowired
    private  UserService userService;
    @Test
    public void test1(){
        userService.findAll();
    }
}
