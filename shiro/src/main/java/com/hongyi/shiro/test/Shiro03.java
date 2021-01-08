package com.hongyi.shiro.test;

import com.hongyi.shiro.util.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-shiro.xml")
public class Shiro03 {

    @Test
    public void test1(){
        UsernamePasswordToken token =
                new UsernamePasswordToken("zhoujin","123456");
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        System.out.println(subject.hasRole("admin"));
        System.out.println(subject.hasRole("admin"));
        System.out.println(subject.hasRole("salesman"));
        System.out.println(subject.isPermitted("sys:user:*"));
    }
}
