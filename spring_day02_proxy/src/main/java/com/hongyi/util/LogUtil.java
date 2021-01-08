package com.hongyi.util;

import org.springframework.stereotype.Component;

@Component
public class LogUtil {
    public static void start(){
        System.out.println("开始记录日志");
    }
    public static void end(){
        System.out.println("记录日志结束");
    }
}
