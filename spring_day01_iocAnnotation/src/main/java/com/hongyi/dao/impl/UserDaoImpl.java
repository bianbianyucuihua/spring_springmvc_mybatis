package com.hongyi.dao.impl;

import com.hongyi.dao.UserDao;
import com.hongyi.pojo.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
/*
    1.创建对象的注解
        @Component：组件(通用的)
            属性值：value表示创建的bean对象的id
        相当于：<bean id="value" class="com.hongyi.dao.impl.UserDao"></bean>
        @Controller 控制层
        @Service   业务层
        @Repository 持久层
        作用效果和Component一样，但是具有不一样的意义
        注意：注解创建对象必须带有无参构造方法

     2.功能性的注解
        作用域：
        @Scope:指定对象的作用域
        生命周期：
        @PostConstruct:指定对象的初始化方法
        @PreDestroy:指定对象的销毁方法
        加载时机
        @Lazy：延迟加载,默认是true
      3.依赖注入
        基本数据类型
        集合
        引用数据类型

 */
@Service
@Scope("singleton")
@Lazy(false)
public class UserDaoImpl implements UserDao {

    public UserDaoImpl(){
        System.out.println("执行了无参的构造方法");
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化方法init");
    }
    @PreDestroy
    public void destory(){
        System.out.println("销毁方法destory");
    }

    public List<User> findAll() {
        System.out.println("查询了所有用户");
        return null;
    }
}
