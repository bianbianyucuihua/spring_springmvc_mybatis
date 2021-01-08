package com.hongyi.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hongyi.shiro.util.MD5Util;
import com.hongyi.sys.entity.User;
import com.hongyi.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author zhou
 * @since 2020-12-02
 */
@Controller
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    public IUserService userService;

    @RequestMapping("/login")
    public String login(String username,String password){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        User user = userService.getOne(wrapper);
        String salt = user.getSalt();
        String pass = user.getPassword();
        password = MD5Util.Md5(password, salt);
        if(pass.equals(password)){
            return "success";
        }
        return "error";
    }
}
