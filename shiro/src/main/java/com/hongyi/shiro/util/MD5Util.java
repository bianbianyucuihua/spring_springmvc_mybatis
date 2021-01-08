package com.hongyi.shiro.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Util {
    private final static int hashCount=3;

    public static String Md5(String password,String salt){
        Md5Hash md5Hash = new Md5Hash(password,salt,hashCount);
        return md5Hash.toString();
    }
}
