package com.penghy.gymnasium.core.service.impl;

import com.penghy.gymnasium.core.help.Menu;
import com.penghy.gymnasium.core.mapper.MenuMapper;
import com.penghy.gymnasium.core.service.IMenuService;
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
public class MenuServiceImp implements IMenuService {
    @Resource
    private MenuMapper menuMapper;

    @Override
    public void addMenu(Menu menu) {
        menuMapper.addMenu(menu);
    }

    @Override
    public Menu getMenu(String id) {
        return menuMapper.getMenu(id);
    }

    @Override
    public List<Menu> getMenusByRole(String roleId) {
        return menuMapper.getMenusByRole(roleId);
    }

    @Override
    public List<Menu> getFirstLevelMenusByRoleName(String roleName) {
        return menuMapper.getFirstLevelMenusByRoleName(roleName);
    }

    @Override
    public List<Menu> getMenusByRoleName(String roleName) {
        return menuMapper.getMenusByRoleName(roleName);
    }

    @Override
    public void deleteMenu(String id) {
        menuMapper.deleteMenu(id);
    }

    @Override
    public void setMenu(Menu menu) {
        menuMapper.setMenu(menu);
    }
}
