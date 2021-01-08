package com.hongyi.dao;

import com.hongyi.pojo.Account;
import com.hongyi.pojo.User;
import com.hongyi.pojo.User1;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {
    @Select("select * from user")
    public List<User> findUserAll();
    @Select("Select * from user where id=#{id}")
    public User SelectUserById(Integer id);
    @Insert("insert into user(username,sex,birthday,address) " +
            "values(#{username},#{sex},#{birthday},#{address})")
    @SelectKey(statement="select last_insert_id()",keyProperty="id",
            keyColumn="id",before=false,resultType=Integer.class)
    public int insertUser(User user);
    @Update("update user set username=#{username},sex=#{sex} where id=#{id}")
    public int updateUser(User user);
    @Delete("delete from user where id=#{id}")
    public int deleteUserById(Integer id);
    @Select("select Count(id) from user")
    public int selectCount();
    //@Select("select * from user where username like #{username}")
    @Select("select * from user where username like '%${value}%'")
    public List<User> selectUserByName(String name);

    //@Select("select id userId,username,sex userSex,birthday userBirthday from user")
    @Results(id="user1Map",value={
            @Result(property = "userId",column ="id"),
            @Result(property = "userName",column ="username"),
            @Result(property = "userSex",column ="sex"),
            @Result(property = "userBirthday",column ="birthday"),
            @Result(property = "userAddress",column ="address"),
            @Result(property = "accounts",column = "id",javaType = List.class,
                many=@Many(select="com.hongyi.dao.AccountDao.findAccountByUserId",fetchType = FetchType.LAZY)
            )
    })
    @Select("select * from user")
    public List<User1> findUser1All();

    @ResultMap("user1Map")
    @Select("select * from user where id=#{id}")
    public User1 findUser1ById(Integer id);
}
