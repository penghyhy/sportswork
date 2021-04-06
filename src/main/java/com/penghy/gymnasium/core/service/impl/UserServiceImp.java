package com.penghy.gymnasium.core.service.impl;

import com.penghy.gymnasium.core.entity.*;
import com.penghy.gymnasium.core.mapper.*;
import com.penghy.gymnasium.core.entity.*;
import com.penghy.gymnasium.core.mapper.*;
import com.penghy.gymnasium.core.service.IUserService;
import com.penghy.gymnasium.core.service.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */

@Slf4j
@Service
@Transactional
public class UserServiceImp implements IUserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public boolean addUser(UserVo userDTO) {
        if (exist(userDTO.getUsername())) {
            return false;
        }
        User user = new User();
        user.setRegisterTime(new Date().toString());
        user.setIsDel(0);
        userDTO.Assignment(user);
        userMapper.addUser(user);
        Role role = roleMapper.getRoleByName(userDTO.getRoleCode());

        UserRole userRole = new UserRole();
        userRole.setRoleId(role.getId());
        userRole.setUserId(user.getId());
        userRoleMapper.addUserRole(userRole);
        user = userMapper.getUser(user.getId());
        addUserRole(user);    //绑定学生教师id
        return true;
    }

    @Override
    public void delUser(String username) {
        userMapper.delUser(username);
    }

    @Override
    public void stopUser(User user) {
        userMapper.stopUser(user);
    }

    @Override
    public void setUser(UserVo userDTO) {
        User user = userMapper.getUserByUsername(userDTO.getUsername());
        userDTO.Edit(user);
        userMapper.setUser(user);
        Role role = roleMapper.getRoleByName(userDTO.getRoleCode());
        if (!user.getRoleList().contains(role)) {
            userRoleMapper.delUserRoleByUser(user.getId());
            UserRole userRole = new UserRole();
            userRole.setRoleId(role.getId());
            userRole.setUserId(user.getId());
            userRoleMapper.addUserRole(userRole);
        }
        if (userDTO.getRoleCode() == null) {
            userRoleMapper.delUserRoleByUser(user.getId());
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public User getUser(String id) {
        return userMapper.getUser(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public User getUserByOpenId(String openId) {
        return userMapper.getUserByOpenId(openId);
    }

    @Override
    public Integer getUsersCount() {
        return userMapper.getUsersCount();
    }

    @Override
    public Integer getNewUserId() {
        return userMapper.getUsersMaxId() + 1;
    }

    public boolean exist(String username) {
        return getUserByUsername(username) != null;
    }

    public boolean exist(User user) {
        return exist(user.getUsername());
    }


    @Override
    public void setOpenId(User user) {
        userMapper.setOpenId(user);
    }

    @Override
    public void setUsername(User user) {
        userMapper.setUsername(user);
    }

    @Override
    public void setPassword(User user) {
        userMapper.setPassword(user);
    }

    @Override
    public void setPhone(User user) {
        userMapper.setPhone(user);
    }

    @Override
    public void addUserRole(User user) {
        if (user.getRoleId() == null) {
            if (user.getRoleCode().startsWith("ROLE_student")) {
                Student student = new Student();
                student.setNumber(user.getUsername());
                studentMapper.addStudent(student);
                user.setRoleId(student.getId());
            }
            if (user.getRoleCode().startsWith("ROLE_teacher")) {
                Teacher teacher = new Teacher();
                teacher.setNumber(teacher.getNumber());
                teacherMapper.addTeacher(teacher);
                user.setRoleId(teacher.getId());
            }
        }
    }
}
