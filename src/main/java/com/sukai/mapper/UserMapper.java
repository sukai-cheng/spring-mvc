package com.sukai.mapper;

import com.sukai.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chengsukai
 */
public interface UserMapper {
    User findByUserName(@Param("userName") String userName);

    List<User> selectAll();

    boolean addUser(@Param("user") User user);
}
