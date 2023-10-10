package com.sukai.service;

import com.sukai.entity.User;

/**
 * @author chengsukai
 */
public interface UserService {

    User findByUserName(String userName);
}
