package com.hongyi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hongyi.dao.UserDao;
import com.hongyi.pojo.User;
import com.hongyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService {
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean removeById(Serializable id) {
        boolean b = super.removeById(id);
//        int i=1/0;
        return b;
    }
}
