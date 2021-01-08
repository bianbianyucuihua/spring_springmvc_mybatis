package com.hongyi.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hongyi.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class JSONController {
    //获取前端页面发送的JSON字符串
    @RequestMapping("/getJson1")
    public String getJSON1(@RequestBody String body) throws IOException {
        System.out.println(body);
      /*  ObjectMapper obj = new ObjectMapper();
        User user = obj.readValue(body, User.class);*/
        return "success";
    }
    //获取前端页面发送的JSON字符串并将其转换为JavaBean
    @RequestMapping("/getJson2")
    public void getJSON2(@RequestBody User u) {
        System.out.println(u);
    }
    //响应JSON字符串给前端页面
    @RequestMapping("/getJson3")
    @ResponseBody
    public Map<String,User> getJSON3(@RequestBody String body) {
        System.out.println(body);
        //一系列操作
        Map<String,User> map = new HashMap<>();
//        List<User> list = new ArrayList<>();
        User u1 = new User();
        u1.setId(1);
        u1.setName("张三");
        u1.setAge(10);
        User u2 = new User();
        u2.setId(2);
        u2.setName("李四");
        u2.setAge(20);
        User u3 = new User();
        u3.setId(3);
        u3.setName("王五");
        u3.setAge(30);
//        list.add(u1);
//        list.add(u2);
//        list.add(u3);
        map.put("u1",u1);
        map.put("u2",u2);
        map.put("u3",u3);
        return map;
    }
}
