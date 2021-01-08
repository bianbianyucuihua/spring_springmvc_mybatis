package com.hongyi.dao;

import com.hongyi.pojo.Account;
import com.hongyi.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
@CacheNamespace(blocking = true)
public interface AccountDao {
    @Select("select * from account")
    @Results(id = "accountAll",value = {
            @Result(property = "id",column = "id"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "money",column = "money"),
            @Result(property = "user",javaType =User.class,
                    column = "uid",
                    one=@One(select="com.hongyi.dao.UserDao.SelectUserById",fetchType = FetchType.EAGER)
            ),
    })
    public List<Account> findAccountAll();
    @Select("select * from account where uid=#{id}")
    public List<Account> findAccountByUserId(Integer id);
}
