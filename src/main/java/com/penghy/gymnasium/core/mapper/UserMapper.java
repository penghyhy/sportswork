package com.penghy.gymnasium.core.mapper;

import com.penghy.gymnasium.core.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
public interface UserMapper {
    void addUser(User user);

    void delUser(@Param("username") String username);

    void stopUser(User user);

    void setUser(User user);

    void setOpenId(User user);

    void setUsername(User user);

    void setPassword(User user);

    void setPhone(User user);

    void setUserIsDel(User user);

    List<User> getAllUsers();

    User getUserByOpenId(@Param("openId") String openId);

    User getUserByUsername(@Param("username") String username);

    User getUser(@Param("id") String id);

    Integer getUsersCount();

    Integer getUsersMaxId();
}
