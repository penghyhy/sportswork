package com.penghy.gymnasium.core.service;

import com.penghy.gymnasium.core.entity.User;
import com.penghy.gymnasium.core.service.vo.UserVo;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/3 13:45
 * @description
 */
public interface IUserService {
    boolean addUser(UserVo userDTO);
    void delUser(String username);
    void stopUser(User user);
    void setUser(UserVo UserDTO);
    List<User> getAllUsers();
    User getUserByUsername(String username);
    User getUserByOpenId(String openId);
    User getUser(String id);
    Integer getUsersCount();
    Integer getNewUserId();


    void setOpenId(User user);
    void setUsername(User user);
    void setPassword(User user);
    void setPhone(User user);

    void addUserRole(User user);
}
