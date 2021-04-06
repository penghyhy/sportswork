package com.penghy.gymnasium.controller.admin;

import com.penghy.gymnasium.core.entity.Role;
import com.penghy.gymnasium.core.entity.User;
import com.penghy.gymnasium.core.service.impl.RoleServiceImp;
import com.penghy.gymnasium.core.service.impl.UserServiceImp;
import com.penghy.gymnasium.core.service.vo.PageVo;
import com.penghy.gymnasium.core.service.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
@Slf4j
@Controller("userEntityController")
public class UserController {
    @Resource
    private UserServiceImp userServiceImp;
    @Resource
    private RoleServiceImp roleServiceImp;

    @RequestMapping("/admin/user/list")
    @PreAuthorize("hasAnyRole('admin')")
    public String List() {
        return "/pages/view/admin/user/list";
    }

    @RequestMapping("/admin/user/getAllUsers")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getAllUsers() {
        return new PageVo<UserVo>().toPageDTO(
                UserVo.UserDTOList(userServiceImp.getAllUsers()));
    }

    @RequestMapping(value = "/admin/user/add", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String add(UserVo userDTO) {
        userServiceImp.addUser(userDTO);
        return "success";
    }


    @RequestMapping(value = "/admin/user/edit", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String edit(UserVo userDTO) {
        userServiceImp.setUser(userDTO);
        return "success";
    }

    @RequestMapping("/admin/user/getAllRoles")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getAllRoles() {
        return new PageVo<Role>().toPageDTO(roleServiceImp.getAllRoles());
    }

    @RequestMapping(value = "/admin/user/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String delete(@RequestParam String username) {
        userServiceImp.delUser(username);
        return "true";
    }

    @RequestMapping(value = "/admin/user/stop", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object stop(@RequestBody User user) {
        userServiceImp.stopUser(user);
        return "true";
    }

}
