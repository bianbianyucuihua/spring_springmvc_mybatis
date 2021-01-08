package com.hongyi;

import com.hongyi.cglib.CglibFactory;
import com.hongyi.service.impl.UserServiceImpl2;
import org.junit.Test;

public class CglibTest {
    @Test
    public void test1(){
        CglibFactory factory = new CglibFactory();
        UserServiceImpl2 dai = factory.getCglibUserServiceImpl2();
        dai.findAll();
        dai.delUserById();
        dai.findUserById();
    }
}
