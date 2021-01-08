package com.hongyi.demo;

public class Demo02Factory {
    private static Demo02 d = new Demo02();
    public Demo02 getDemo02(){
        return d;
    }
}
