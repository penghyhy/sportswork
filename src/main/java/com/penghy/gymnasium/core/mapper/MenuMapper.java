package com.penghy.gymnasium.core.mapper;

import com.penghy.gymnasium.core.help.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
public interface MenuMapper {
    void addMenu(Menu menu);

    Menu getMenu(@Param("id") String id);

    List<Menu> getMenusByRole(@Param("roleId") String roleId);

    List<Menu> getMenusByRoleName(@Param("roleName") String roleName);

    List<Menu> getFirstLevelMenusByRoleName(@Param("roleName") String roleName);

    List<Menu> getAllMenus();

    void deleteMenu(@Param("id") String id);

    void setMenu(Menu menu);

    long getCount();
}
