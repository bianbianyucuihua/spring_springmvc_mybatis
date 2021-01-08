package com.hongyi.web;

import com.hongyi.pojo.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class ResponseController {
    /*springmvc默认的跳转方式是转发，因此可以使用请求对象绑定参数的方式响应数据*/
    @RequestMapping("/response1")
    public String response1(HttpServletRequest request) throws IOException {
        //response.getWriter().write("hello");
        request.setAttribute("name","admin");
        return "success";
    }
    @RequestMapping("/response2")
    public ModelAndView response2(){
        ModelAndView modelAndView = new ModelAndView("success");
        User user = new User();
        user.setId(20);
        user.setUsername("张三");
        user.setPhone("12342374824");
        modelAndView.addObject("user",user);
        return modelAndView;
    }
    @RequestMapping("/response3")
    public String response3(ModelMap map){
        User user = new User();
        user.setUsername("李四");
        user.setPhone("12342374824");
        map.addAttribute("user1",user);
        return "success";
    }
    @RequestMapping("/response4")
    public void response4(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/success.jsp");
//        dispatcher.forward(request,response);
        response.sendRedirect(request.getContextPath()+"/success.jsp");
    }
    @RequestMapping("/response5")
    public String response5() {
       // return "redirect:/success.jsp";
        return "forward:/success.jsp";
    }

}
