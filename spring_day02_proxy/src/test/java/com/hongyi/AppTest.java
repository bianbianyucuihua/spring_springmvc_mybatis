package com.hongyi;

import static org.junit.Assert.assertTrue;

import com.hongyi.config.AppConfig;
import com.hongyi.service.UserService;
import com.hongyi.service.impl.UserServiceImpl1;
import com.hongyi.util.LogUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Unit test for simple App.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppTest{
    @Autowired
    private  UserServiceImpl1 userServiceImpl1;

    @Test
    public void test2(){
        UserService userService = (UserService) Proxy.newProxyInstance(UserServiceImpl1.class.getClassLoader(),
                UserServiceImpl1.class.getInterfaces(),
                new InvocationHandler() {
                    /**
                     * @param proxy 表示代理对象
                     * @param method 表示增强的方法
                     * @param args   表示增强方法需要的参数
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object obj = null;
                        LogUtil.start();
                        obj = method.invoke(userServiceImpl1, args);
                        LogUtil.end();
                        return obj;
                    }
                });
        userService.findAll();
        userService.findUserById();
        userService.delUserById();
        userService.updateUser();
    }
}
