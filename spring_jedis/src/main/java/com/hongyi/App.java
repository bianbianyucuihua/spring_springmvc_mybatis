package com.hongyi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class App {
    @Autowired
    public StringRedisTemplate stringRedisTemplate;

    /**
     * 字符串操作
     */
    @Test
    public void test1(){
        ValueOperations<String, String> redisFurStr = stringRedisTemplate.opsForValue();
//        redisFurStr.set("sname","zhangsan");

/*        String sname = redisFurStr.get("sname");
        System.out.println(sname);*/

     /*   Map<String,String> mapNames = new HashMap<>();
        mapNames.put("name1","lisi");
        mapNames.put("name2","王五");
        mapNames.put("name3","zhaoliu");
        redisFurStr.multiSet(mapNames);*/
/*
        List<String> list = new ArrayList<>();
        list.add("name1");
        list.add("name2");
        list.add("name3");
        List<String> list1 = redisFurStr.multiGet(list);
        System.out.println(list1);*/
        //如果存在就更改
        redisFurStr.setIfPresent("age","20");
        //设置缓存时间
        redisFurStr.set("sex","female",10, TimeUnit.SECONDS);
    }
    /**
     * hash操作
     */
    @Test
    public void test2(){
        HashOperations<String, Object, Object> hash = stringRedisTemplate.opsForHash();
        hash.put("hu1","name1","admin1");
        hash.put("hu1","age1","20");
        hash.put("hu1","sex1","man");
        hash.put("hu2","name2","admin2");
        hash.put("hu3","name3","admin3");

//        String name1 = (String)hash.get("hu1", "name1");
//        String name2 = (String)hash.get("hu2", "name2");
//        String name3 = (String)hash.get("hu3", "name3");
//        System.out.println(name1);

//        List<Object> list = new ArrayList<>();
//        list.add("name1");
//        list.add("age1");
//        list.add("sex1");
        Set<Object> hu11 = hash.keys("hu1");
        List<Object> hu1 = hash.multiGet("hu1", hu11);
        System.out.println(hu1);
    }

    /**
     * list操作
     */
    @Test
    public void test3(){
        ListOperations<String, String> list = stringRedisTemplate.opsForList();
        list.leftPushAll("hobby","basketball","football","pingpang");
        List<String> hobby = list.range("hobby", 0, -1);
        System.out.println(hobby);

        Long remove = list.remove("hobby", 1, "football");
    }
    /**
     * set操作
     */
    @Test
    public void test4(){
        SetOperations<String, String> set = stringRedisTemplate.opsForSet();
        set.add("myfriend","panjin","zhoujin","lvxin");
        set.add("yourfriend","panjin","baideng","trump");
        Set<String> myfriend = set.members("myfriend");
        System.out.println(myfriend);
        //交集
        Set<String> intersect = set.intersect("myfriend", "yourfriend");
        System.out.println(intersect);
        //差集
        Set<String> difference = set.difference("myfriend", "yourfriend");
        System.out.println(difference);
        //并集
        Set<String> union = set.union("myfriend", "yourfriend");
        System.out.println(union);

    }
    /**
     * sored_set操作
     */
    @Test
    public void test5(){
        ZSetOperations<String, String> zSet = stringRedisTemplate.opsForZSet();
        zSet.add("students","zhoujin",80);
        zSet.add("students","panjin",18);
        zSet.add("students","admin",20);
        zSet.add("students","tom",89);

        Set<String> students = zSet.range("students", 0, -1);
        System.out.println(students);
    }

    /**
     * key操作
     */
    @Test
    public void test6(){
        Set<String> keys = stringRedisTemplate.keys("*");
        System.out.println(keys);
        Boolean name3 = stringRedisTemplate.hasKey("name3");
        stringRedisTemplate.delete("name3");

        stringRedisTemplate.expire("name2",30,TimeUnit.SECONDS);
    }
}
