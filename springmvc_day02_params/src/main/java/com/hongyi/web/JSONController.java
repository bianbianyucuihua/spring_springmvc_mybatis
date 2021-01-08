package com.hongyi.web;

import com.hongyi.pojo.User;
import com.hongyi.pojo.User1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class JSONController {
    @RequestMapping("/goJSON")
    public String goJSON(){
        return "jsonParams";
    }
    @RequestMapping("/getJSONData")
    public String getJSONData(@RequestBody User1 user){
        System.out.println(user);
        return "success";
    }
}
