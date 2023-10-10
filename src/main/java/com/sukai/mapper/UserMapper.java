package com.sukai.mapper;

import com.sukai.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
public interface UserMapper {
    User findByUserName(@Param("userName") String userName);
}
