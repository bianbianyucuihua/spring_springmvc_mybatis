package com.hongyi.web;

import com.hongyi.pojo.User;
import com.hongyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;

    @RequestMapping("/findUserById")
    public String getUserById(Integer id, ModelMap map){
        System.out.println("控制器UserController");
        User user = userService.findUserById(id);
        map.addAttribute("user",user);
        return "success";
    }
    @RequestMapping("/findAll")
    public String findAll(ModelMap map){
        System.out.println("控制器UserController");
        List<User> list = userService.findAll();
        map.addAttribute("list",list);
        return "success";
    }
}
