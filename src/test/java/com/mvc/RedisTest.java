package com.mvc;

import com.sukai.entity.User;
import com.sukai.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/application-context.xml"})
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test1() {
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setUserId(1L);
        user.setUserName("chengsukai");
        user.setPassWord("admin123");
        User user2 = new User();
        user2.setUserId(2L);
        user2.setUserName("jackson");
        user2.setPassWord("asdf");
        userList.add(user);
        userList.add(user2);
        String key = "userList";
        redisUtil.setCacheList(key, userList);

        List<User> cacheObject = redisUtil.getCacheList(key);
        System.out.println(cacheObject);

    }
}
