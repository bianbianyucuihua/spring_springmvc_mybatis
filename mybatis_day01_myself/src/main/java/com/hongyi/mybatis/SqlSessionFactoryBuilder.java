package com.hongyi.mybatis;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream config){
        return new DefaultSqlSessionFacory(config);
    }
}
