package com.hongyi.web;

import com.hongyi.util.MyselfException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class ExceptionContoller {
    @RequestMapping("/exception1")
    public String testException1(){
//        int i = 1/0;
        return "success";
    }
}
