package com.hongyi.shiro.util;

import com.hongyi.shiro.realm.MyRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

public class ShiroUtil {
    static{
        DefaultSecurityManager manager = new DefaultSecurityManager();
        //Realm realm = new IniRealm("classpath:shiro.ini");
        //设置缓存管理器
//        CacheManager cacheManager = new MemoryConstrainedCacheManager();
        CacheManager cacheManager = new EhCacheManager();
        //将缓存管理器设置到安全管理
        manager.setCacheManager(cacheManager);
        MyRealm realm = new MyRealm();
        manager.setRealm(realm);
        SecurityUtils.setSecurityManager(manager);
    }

    public static Subject login(String username,String password)throws UnknownAccountException{
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
        }catch (Exception e){
            throw new UnknownAccountException("账户不存在异常");
        }
        return subject;
    }
}
