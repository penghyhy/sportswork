package com.penghy.gymnasium.controller.admin;

import com.penghy.gymnasium.core.entity.Role;
import com.penghy.gymnasium.core.help.Menu;
import com.penghy.gymnasium.core.service.vo.PageVo;
import com.penghy.gymnasium.core.service.impl.MenuServiceImp;
import com.penghy.gymnasium.core.service.impl.RoleServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
@Slf4j
@Controller("menuController")
public class MenuController {
    @Resource
    private MenuServiceImp menuServiceImp;
    @Resource
    private RoleServiceImp roleServiceImp;

    @RequestMapping("/admin/menu/list")
    @PreAuthorize("hasAnyRole('admin')")
    public String List() {
        return "/pages/view/admin/menu/roleList";
    }

    @RequestMapping("/admin/menu/getMenusByRole")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getMenusByRole(String roleId) {
        return new PageVo<Menu>().toPageDTO(menuServiceImp.getMenusByRole(roleId));
    }

    @RequestMapping("/admin/menu/getAllRole")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getAllRole() {
        return new PageVo<Role>().toPageDTO(roleServiceImp.getAllRoles());
    }
}
