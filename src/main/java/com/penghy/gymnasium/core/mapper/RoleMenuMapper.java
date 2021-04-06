package com.penghy.gymnasium.core.mapper;

import com.penghy.gymnasium.core.help.RoleMenu;
import org.apache.ibatis.annotations.Param;


/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
public interface RoleMenuMapper {
    void addRoleMenu(RoleMenu roleMenu);

    void deleteRoleMenu(@Param("id") String id);

    long getCount();
}
