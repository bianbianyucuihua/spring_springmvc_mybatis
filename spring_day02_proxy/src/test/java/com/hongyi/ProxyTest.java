package com.hongyi;

import com.hongyi.service.UserService;
import com.hongyi.service.impl.UserServiceImpl1;
import com.hongyi.util.LogUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *  特点：字节码随用随创建
 *  作用：对被代理对象的方法在不修改源码的基础上进行动态的增强
 *  动态代理的分类：
 *      1.基于接口的动态代理
 *      2.基于子类的动态代理
 *  基于接口的动态代理：
 *      使用技术：JDK提供对象Proxy
 *      使用方法：Proxy.newProxyInstance()
 *      方法的参数：
 *          ClassLoader loader：类加载器，表示代理对象的类加载器；
 *          可以使用被代理对象的类加载器；固定的
 *          Class<?>[] interfaces,字节码数组，被代理对象的字节码数组;固定的
 *          InvocationHandler h，是一个接口，这个接口就表示对方法的增强，一般使用匿名内部类。
 *
 */
public class ProxyTest {
    private static final UserServiceImpl1 bProxy = new UserServiceImpl1();
    public static void main(String[] args) {
        UserService userService = (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(),
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

                        obj = method.invoke(bProxy, args);

                        LogUtil.end();
                        return obj;
                    }
                });
        userService.findAll();


    }
}
