package com.hongyi.dao.impl;

import com.hongyi.dao.UserDao;
import com.hongyi.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
public class UserDaoImpl2 implements UserDao {

    public UserDaoImpl2(){
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
