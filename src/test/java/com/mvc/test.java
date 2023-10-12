package com.mvc;

import com.sukai.datasource.DataSource;
import com.sukai.entity.User;
import com.sukai.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/application-context.xml"})
public class test {

    @Autowired
    private UserService userService;

    @Test
    public void testUserService() {
        User user = userService.findByUserName("slave");
        System.out.println(user.getUserName());
    }

    @Test
    @Transactional
    public void createUser() {
        User user = new User();
        user.setUserName("boss");
        user.setPassWord("123");
        userService.addUser(user);
        int res = 1 / 0;
    }
}
