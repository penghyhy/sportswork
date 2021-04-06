package com.penghy.gymnasium.core.service.impl;

import com.penghy.gymnasium.core.entity.Role;
import com.penghy.gymnasium.core.mapper.RoleMapper;
import com.penghy.gymnasium.core.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */

@Slf4j
@Service
@Transactional
public class RoleServiceImp implements IRoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public void addRole(Role role) {
        roleMapper.addRole(role);
    }

    @Override
    public Role getRole(String id) {
        return roleMapper.getRole(id);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleMapper.getRoleByName(name);
    }

    @Override
    public Role getRoleByDescription(String description) {
        return roleMapper.getRoleByDescription(description);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    @Override
    public List<Role> getRolesByUser(String userId) {
        return roleMapper.getRolesByUser(userId);
    }

    @Override
    public void deleteRole(String id) {
        roleMapper.deleteRole(id);
    }

    @Override
    public void setRole(Role role) {
        roleMapper.setRole(role);
    }

    @Override
    public long getCount() {
        return roleMapper.getCount();
    }
}
