package com.sukai.service;

import com.sukai.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chengsukai
 */
public interface UserService {

    User findByUserName(String userName);

    List<User> findAllUsers();

    Boolean addUser(@Param("user") User user);
}
