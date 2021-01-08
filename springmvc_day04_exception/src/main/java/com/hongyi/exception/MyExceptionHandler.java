package com.hongyi.exception;

import com.hongyi.util.MyselfException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException
            (HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = null;
//        if(ex instanceof MyselfException){
            String message = ex.getMessage();
            modelAndView = new ModelAndView();
            modelAndView.setViewName("error");
            modelAndView.addObject("msg",message);
//        }
        return modelAndView;
    }
}
