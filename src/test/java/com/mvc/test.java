package com.mvc;

import com.sukai.entity.User;
import com.sukai.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/application-context.xml"})
public class test {

    @Autowired
    private UserService userService;

    @Test
    public void testUserService(){
        User user = userService.findByUserName("slave");
        System.out.println(user.getUserName());
    }
}
