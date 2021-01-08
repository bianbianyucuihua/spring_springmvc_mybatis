package com.hongyi.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class SpringContext {
    private HashMap<String,Object> objs;
    //1.读取配置文件
    //2.创建对象
    public SpringContext(String config){
        InputStream in = SpringContext.class.getClassLoader().getResourceAsStream(config);
        Properties p = new Properties();
        try {
            p.load(in);
            objs = new HashMap<String, Object>();
            String userDao = p.getProperty("userDao");
            String userService = p.getProperty("userService");
            objs.put("userDao",Class.forName(userDao).newInstance());
            objs.put("userService",Class.forName(userService).newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //3.提供获取对象的方法
    public Object getBean(String key){
        return objs.get(key);
    }
}
