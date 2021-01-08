package com.hongyi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class HelloController{
    @RequestMapping(path = {"/hello"})
    public String getHello(){
        return "Hello";
    }
}
