package com.penghy.gymnasium.controller.teacher;

import com.penghy.gymnasium.core.entity.User;
import com.penghy.gymnasium.core.service.impl.TeacherServiceImp;
import com.penghy.gymnasium.core.service.impl.UserServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
@Controller("t_teacherController")
public class TeacherController {
    @Resource
    private UserServiceImp userServiceImp;

    @Resource
    private TeacherServiceImp teacherServiceImp;


    @RequestMapping({"/teacher/details"})
    @PreAuthorize("hasAnyRole('teacher')")
    public String details() {
        return "pages/view/teacher/details";
    }

    @RequestMapping("/teacher/details/getTeacher")
    @PreAuthorize("hasAnyRole('teacher')")
    @ResponseBody
    public Object getTeacher() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        User user = userServiceImp.getUser(userDetails.getUsername());
        return teacherServiceImp.getTeacher(user.getRoleId());
    }
}
