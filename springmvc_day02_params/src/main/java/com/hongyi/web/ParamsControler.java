package com.hongyi.web;

import com.hongyi.pojo.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/user")
public class ParamsControler {

    @RequestMapping("/request1")
    public String getRequestParams1(){
        return "success";
    }
    /*传统方式获取参数*/
    @RequestMapping("/request2")
    public String getRequestParams2(HttpServletRequest request){
        String name = request.getParameter("name");
        System.out.println(name);
        return "success";
    }
    /*spring映射获取参数，形参的变量名必须和前端页面的name属性一致*/
    @RequestMapping("/request3")
    public String getRequestParams3(String name,Integer age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }
    /*使用实体类映射*/
    /*@PathVariable */
    @RequestMapping("/request4")
    public String getRequestParams4(User user){
        System.out.println(user);
        return "success";
    }
    /*使用注解*/
    @RequestMapping("/request5")
    public String getRequestParams5(@RequestParam("name") String username){
        System.out.println(username);
        return "success";
    }
    /*使用注解*/
    @RequestMapping("/request6/{id}")
    public String getRequestParams6(@PathVariable String id){
        System.out.println(id);
        return "success";
    }
    @RequestMapping("/request7")
    public String getRequestParams7(@RequestBody String body){
        System.out.println(body);
        return "success";
    }
    @RequestMapping("/request8")
    public String getRequestParams8(@CookieValue(name="JSESSIONID")String accept){
        System.out.println(accept);
        return "success";
    }
}
