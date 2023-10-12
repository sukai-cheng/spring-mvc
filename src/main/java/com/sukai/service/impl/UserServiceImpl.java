package com.sukai.service.impl;

import com.sukai.datasource.DataSource;
import com.sukai.entity.User;
import com.sukai.mapper.UserMapper;
import com.sukai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chengsukai
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @DataSource(value = DataSource.SLAVE)
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }

    @Override
    @DataSource(value = DataSource.SLAVE)
    public List<User> findAllUsers() {
        return userMapper.selectAll();
    }

    @Override
    public Boolean addUser(User user){
        return userMapper.addUser(user);
    }
}
