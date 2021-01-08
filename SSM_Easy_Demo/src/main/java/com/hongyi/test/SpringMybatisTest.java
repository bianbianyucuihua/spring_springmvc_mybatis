package com.hongyi.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hongyi.pojo.User;
import com.hongyi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringMybatisTest {
    @Autowired
    public UserService userService;

    @Test
    public void test1(){
        User user = userService.getById(1000);
        System.out.println(user);
    }
    @Test
    public void test2(){
        boolean b = userService.removeById(57);
        System.out.println(b);
    }
    @Test
    public void test3(){
        /*User u = new User();
        u.setUsername("张三");
        u.setSex("男");*/
//        QueryWrapper wrapper = new QueryWrapper(u);
        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("username","张三");
//        wrapper.eq("sex","男");
        wrapper.like(true,"username","王");
//        User one = userService.getOne(wrapper);
        List list = userService.list(wrapper);
        System.out.println(list);
//        System.out.println(one);
    }
    @Test
    public void test4(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username","张三").or().eq("address","北京");
        /*List<Integer> list = new ArrayList<>();
        list.add(56);
        list.add(58);
        boolean b = userService.removeByIds(list);
        System.out.println(b);*/
        List<User> list = userService.list(wrapper);
        System.out.println(list);
    }
    @Test
    public void test5(){
        IPage<User> info = new Page<>(2,100);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("username","测试");
        userService.page(info,wrapper);
//        userService.page(info);

        System.out.println(info.getRecords());
    }
}
