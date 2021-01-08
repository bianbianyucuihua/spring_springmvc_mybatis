package com.hongyi.demo;

public class Demo01Factory {
    private static Demo01 d = new Demo01();
    public static Demo01 getDemo01(){
        return d;
    }

}
