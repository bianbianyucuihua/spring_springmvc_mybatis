package com.hongyi;

import static org.junit.Assert.assertTrue;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.hongyi.dao.UserDao;
import com.hongyi.dao.impl.UserDaoImpl;
import com.hongyi.pojo.User;
import com.hongyi.service.UserService;
import com.hongyi.service.impl.UserServiceImpl;
import config.AppConfig;
import config.JDBCConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * Unit test for simple App.
 */
public class AppTest {
    AnnotationConfigApplicationContext ac =null;
    @Before
    public void init(){
        ac = new AnnotationConfigApplicationContext(AppConfig.class);
    }
    @Test
    public void test1() {
        UserDaoImpl userDao = ac.getBean("userDao", UserDaoImpl.class);
        System.out.println(userDao);
        UserDaoImpl userDao1 = ac.getBean("userDao", UserDaoImpl.class);
        System.out.println(userDao1);
        UserDaoImpl userDao2 = ac.getBean("userDao", UserDaoImpl.class);
        System.out.println(userDao2);
        System.out.println(userDao1==userDao2);
        ac.close();
    }
    @Test
    public void test2() {
        UserService userService = ac.getBean("userService", UserService.class);
        userService.getUsers();
        Object user = ac.getBean("user");
        System.out.println(user);
        DruidDataSource dataSource = ac.getBean("dataSource", DruidDataSource.class);
        System.out.println(dataSource);
        DruidPooledConnection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(conn);
    }
}
