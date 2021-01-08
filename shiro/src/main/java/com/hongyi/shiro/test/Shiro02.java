package com.hongyi.shiro.test;

import com.hongyi.shiro.util.ShiroUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.UUID;

public class Shiro02 {
    @Test
    public void test1(){
        Subject subject = ShiroUtil.login("zhoujin", "123456");
        System.out.println(subject.isAuthenticated());
        System.out.println(subject.hasRole("admin"));
        System.out.println(subject.hasRole("admin"));
        System.out.println(subject.hasRole("salesman"));
        System.out.println(subject.isPermitted("sys:user:*"));
    }
    @Test
    public void test2(){
        String s = UUID.randomUUID().toString().replace("-","");
        System.out.println(s);
        Md5Hash md5Hash = new Md5Hash("123456",s ,3);
        System.out.println(md5Hash);
    }
}
