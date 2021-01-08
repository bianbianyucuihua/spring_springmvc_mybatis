package com.hongyi.service.impl;

import com.hongyi.dao.UserDao;
import com.hongyi.pojo.User;
import com.hongyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public List<User> findAll() {
        return userDao.selectAll();
    }

    @Override
    public User findUserById(Integer id) {
        Object user = redisTemplate.opsForValue().get("user:"+id);
        if(user!=null){
            User u = (User)user;
            System.out.println("redis查询");
            return u;
        }
        System.out.println("mysql查询");
        User user1 = userDao.selectUserById(id);
        redisTemplate.opsForValue().set("user:"+id,user1);
        return user1;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addUser(User user) {
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int delUserById(Integer id) {
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateUser(User user) {
        return 0;
    }
}
