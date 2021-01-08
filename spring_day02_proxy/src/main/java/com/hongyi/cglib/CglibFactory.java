package com.hongyi.cglib;

import com.hongyi.service.impl.UserServiceImpl2;
import com.hongyi.util.LogUtil;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * 动态代理
 *  特点：字节码随用随创建
 *  作用：对被代理对象的方法在不修改源码的基础上进行动态的增强
 *  动态代理的分类：
 *      1.基于接口的动态代理
 *      2.基于子类的动态代理
 *  基于子类的动态代理：
 *      使用技术：第三方jar包提供的cglib
 *      使用方法：Enhancer对象中的静态create方法
 *      方法的参数：
 *          Class type,类对象，被代理对象的类对象;固定的
 *          InvocationHandler h，是一个接口，这个接口就表示对方法的增强，一般使用匿名内部类。
 *
 */
public class CglibFactory {
    private UserServiceImpl2 us = new UserServiceImpl2();

    public UserServiceImpl2 getCglibUserServiceImpl2(){
        UserServiceImpl2 daiUs = (UserServiceImpl2)Enhancer.create(us.getClass(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                Object obj = null;
                if(method.getName().equals("test")){
                    obj = method.invoke(us, objects);
                    return obj;
                }
                LogUtil.start();
                obj = method.invoke(us, objects);
                LogUtil.end();
                return obj;
            }
        });
        return daiUs;
    }
}
