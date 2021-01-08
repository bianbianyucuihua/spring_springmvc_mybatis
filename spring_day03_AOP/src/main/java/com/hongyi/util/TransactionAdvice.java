package com.hongyi.util;

import org.aspectj.lang.ProceedingJoinPoint;

public class TransactionAdvice {

    /*开启事务*/
    public void beginTransaction(){
        System.out.println("事务已开启");
    }
    /*提交事务*/
    public void commit(){
        System.out.println("提交事务");
    }
    /*回滚事务*/
    public void rollback(){
        System.out.println("回滚事务");
    }
    /*关闭连接对象*/
    public void closeConnection(){
        System.out.println("关闭连接");
    }
    /*环绕通知：开启事务、提交、回滚、关闭连接*/
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
