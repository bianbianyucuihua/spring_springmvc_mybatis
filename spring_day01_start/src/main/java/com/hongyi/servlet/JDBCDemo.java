package com.hongyi.servlet;

//import com.mysql.jdbc.Driver;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDemo {
    /*
        降低耦合度：
            1.耦合度只能降低，不能杜绝
            2.使依赖关系在运行时在依赖
     */
    public static void main(String[] args) throws Exception {
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");//利用反射创建Driver对象
        //DriverManager.registerDriver(new Driver());//传统的方式创建Driver对象

        //2.获取连接
        //3.获取执行SQL语句的Statement对象
        //4.执行SQL
        //5.处理结果集
        //6.关闭资源
    }
}
