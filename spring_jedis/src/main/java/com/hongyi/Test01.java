package com.hongyi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class Test01 {
    @Autowired
    public StringRedisTemplate stringRedisTemplate;
    @Autowired
    public RedisTemplate redisTemplate;
   @Test
    public void test1() throws IOException {
       User u = new User();
       u.setId(1);
       u.setName("周进");
       u.setAge(18);
       ObjectMapper mapper = new ObjectMapper();
       String s = mapper.writeValueAsString(u);
       stringRedisTemplate.opsForValue().set("user",s);

       String user = stringRedisTemplate.opsForValue().get("user");
       User user1 = mapper.readValue(user, User.class);
       System.out.println(user1);
   }
   @Test
    public void test2(){
       User u = new User();
       u.setId(1);
       u.setName("周进");
       u.setAge(18);
       redisTemplate.opsForValue().set("user2",u);
//       User user1 = (User) redisTemplate.opsForValue().get("user1");
//       System.out.println(user1);
       User user2 = (User)redisTemplate.opsForValue().get("user2");
       System.out.println(user2);
   }
}
