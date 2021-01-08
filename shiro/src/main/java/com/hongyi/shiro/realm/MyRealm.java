package com.hongyi.shiro.realm;

import com.hongyi.shiro.util.MD5Util;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

import java.util.ArrayList;
import java.util.List;

public class MyRealm extends AuthorizingRealm {

    /**
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("开始认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = new String(token.getPassword());

        //通过用户名到数据库查询，加密后的密码和加密用的盐
        //密码：cfecd013b8540b1e3eebf3f5504ac5b6
        String salt = "bdd66914-7020-44c7-9806-96305d608c2a";
        String p = MD5Util.Md5(password, salt);
        System.out.println(p);

        if(!(username.equals("zhoujin")&&p.equals("cfecd013b8540b1e3eebf3f5504ac5b6"))){
            throw new UnknownAccountException("账户不存在异常");
        }
        SimpleAuthenticationInfo authenticationInfo =
                new SimpleAuthenticationInfo(token.getPrincipal(),token.getCredentials(),getName());
        return authenticationInfo;
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        /**
         * 获取用户的身份信息
         * 从数据库查询当前用户所具有的角色和权限
         */
        //获取身份信息
        SimplePrincipalCollection p = (SimplePrincipalCollection)principalCollection;
        Object principal = p.getPrimaryPrincipal();
        System.out.println("开始授权");
        //查到了数据库
        List<String> roles = new ArrayList<>();
        roles.add("admin");
        roles.add("superAdmin");
        List<String> permissions = new ArrayList<>();
        permissions.add("sys:*");
        permissions.add("cms:*");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(roles);
        authorizationInfo.addStringPermissions(permissions);
        return authorizationInfo;
    }


}
