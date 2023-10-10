package com.mvc;

import com.sukai.entity.User;
import com.sukai.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/application-context.xml"})
public class test {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void testUserService(){
        User user = userService.findByUserName("admin");
        System.out.println(user.getUserName());
    }
}
