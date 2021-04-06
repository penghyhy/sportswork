package com.penghy.gymnasium.controller.student;

import com.penghy.gymnasium.config.SecurityUserInfo;
import com.penghy.gymnasium.core.service.impl.StudentServiceImp;
import com.penghy.gymnasium.core.service.impl.UserServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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
@Controller("s_studentController")
public class StudentController {
    @Resource
    private UserServiceImp userServiceImp;

    @Resource
    private StudentServiceImp studentServiceImp;

    @RequestMapping({"/student/details"})
    @PreAuthorize("hasAnyRole('student')")
    public String details() {
        return "pages/view/student/details";
    }

    @RequestMapping("/student/details/getStudent")
    @PreAuthorize("hasAnyRole('student')")
    @ResponseBody
    public Object getStudent() {
        SecurityUserInfo userDetails = (SecurityUserInfo) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return studentServiceImp.getStudent(userDetails.getRoleId());
    }
}
