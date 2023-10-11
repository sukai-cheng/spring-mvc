package com.sukai.service;

import com.sukai.entity.User;

import java.util.List;

/**
 * @author chengsukai
 */
public interface UserService {

    User findByUserName(String userName);

    List<User> findAllUsers();
}
