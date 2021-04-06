package com.penghy.gymnasium.core.mapper;

import com.penghy.gymnasium.core.entity.UserRole;
import org.apache.ibatis.annotations.Param;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
public interface UserRoleMapper {
    void addUserRole(UserRole userRole);

    void delUserRole(@Param("id") String id);

    void delUserRoleByUser(@Param("userId") String userId);

    long getCount();
}
