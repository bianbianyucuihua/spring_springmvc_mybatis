package com.hongyi.mybatis;

import java.io.InputStream;

public class DefaultSqlSessionFacory implements SqlSessionFactory {
    private InputStream config;

    public DefaultSqlSessionFacory(InputStream config){
        this.config=config;
    }
    public SqlSession openSession() {
        /*
            解析In流
         */
        return new DefaultSqlSession();
    }
}
