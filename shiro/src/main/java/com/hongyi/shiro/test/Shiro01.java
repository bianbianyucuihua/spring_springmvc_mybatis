package com.hongyi.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.junit.Test;

public class Shiro01 {
    @Test
    public void test(){
        //创建安全管理器
        DefaultSecurityManager manager = new DefaultSecurityManager();
        //创建域(读取数据，等待认证和授权)
        Realm realm = new IniRealm("classpath:shiro.ini");
        manager.setRealm(realm);
        //将安全管理器设置到运行环境
        SecurityUtils.setSecurityManager(manager);
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        //创建token用于具体用户的身份和凭证
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername("lisi");
        token.setPassword("123456".toCharArray());
        //检查是否认证
        System.out.println(subject.isAuthenticated());
        //主体登录，到realm中进行认证、授权
        subject.login(token);
        System.out.println(subject.isAuthenticated());

        System.out.println(subject.hasRole("superAdmin"));
        System.out.println(subject.isPermitted("sys:user:*"));
        System.out.println(subject.isPermitted("sys:*"));
        subject.logout();
        System.out.println(subject.isAuthenticated());

    }
}
