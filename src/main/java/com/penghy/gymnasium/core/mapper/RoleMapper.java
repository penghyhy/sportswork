package com.penghy.gymnasium.core.mapper;

import com.penghy.gymnasium.core.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
public interface RoleMapper {
    void addRole(Role role);

    Role getRole(@Param("id") String id);

    Role getRoleByName(@Param("name") String name);

    Role getRoleByDescription(@Param("description") String description);

    List<Role> getAllRoles();

    List<Role> getRolesByUser(@Param("userId") String userId);

    void deleteRole(@Param("id") String id);

    void setRole(Role role);

    long getCount();
}
