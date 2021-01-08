package com.hongyi.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("advice")
@Aspect
public class TransactionAdvice {

    @Pointcut("execution(* com.hongyi.service.impl.*.findAll())")
    public void pt(){}
    /*开启事务*/
    //@Before("pt()")
    public void beginTransaction(){
        System.out.println("事务已开启");
    }
    /*提交事务*/
    //@AfterReturning("pt()")
    public void commit(){
        System.out.println("提交事务");
    }
    /*回滚事务*/
    //@AfterThrowing("pt()")
    public void rollback(){
        System.out.println("回滚事务");
    }
    /*关闭连接对象*/
    //@After("execution(* com.hongyi.service.impl.*.findAll())")
    public void closeConnection(){
        System.out.println("关闭连接");
    }
    /*环绕通知：开启事务、提交、回滚、关闭连接*/
    @Around("pt()")
    public Object arround(ProceedingJoinPoint proceed){
        Object obj = null;
        //获取执行强化方法所需的参数
        Object[] args = proceed.getArgs();
        try {
            beginTransaction();
            //执行需要强化的方法
            obj = proceed.proceed();
            commit();
            return obj;
        } catch (Throwable throwable) {
            rollback();
            throwable.printStackTrace();
        }finally {
            closeConnection();
        }
        return obj;
    }
}
