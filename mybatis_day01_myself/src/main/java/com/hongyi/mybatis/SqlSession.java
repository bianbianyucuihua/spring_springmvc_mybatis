package com.hongyi.mybatis;

public interface SqlSession {
    public<T> T getMapper(Class<T> daoInterfaceImpl);
}
