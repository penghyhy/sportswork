package com.penghy.gymnasium.controller.student;

import com.penghy.gymnasium.config.SecurityUserInfo;
import com.penghy.gymnasium.core.entity.Teaching;
import com.penghy.gymnasium.core.service.impl.ElectiveServiceImp;
import com.penghy.gymnasium.core.service.impl.TeachingServiceImp;
import com.penghy.gymnasium.core.service.vo.PageVo;
import com.penghy.gymnasium.core.entity.Elective;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
@Slf4j
@Controller("s_electiveController")
public class ElectiveController {
    @Resource
    private ElectiveServiceImp electiveServiceImp;
    @Resource
    private TeachingServiceImp teachingServiceImp;

    @RequestMapping("/student/elective/electiveList")
    @PreAuthorize("hasAnyRole('student')")
    public String electiveList() {
        return "/pages/view/student/electiveList";
    }

    @RequestMapping("/student/elective/getStudentElectives")
    @PreAuthorize("hasAnyRole('student')")
    @ResponseBody
    public Object getStudentElectives() {
        SecurityUserInfo userDetails = (SecurityUserInfo) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return new PageVo<Elective>().toPageDTO(electiveServiceImp.getElectivesByStudent(userDetails.getRoleId()));
    }

    @RequestMapping(value = "/student/teaching/studentElective", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('student')")
    @ResponseBody
    public String studentElective(String teachingId) {
        SecurityUserInfo userDetails = (SecurityUserInfo) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        electiveServiceImp.studentElective(teachingId, userDetails.getRoleId());
        return "true";
    }

    @RequestMapping("/student/teaching/teachingList")
    @PreAuthorize("hasAnyRole('student')")
    public String teachingList() {
        return "/pages/view/student/teachingList";
    }

    @RequestMapping("/student/teaching/getAllTeachings")
    @PreAuthorize("hasAnyRole('student')")
    @ResponseBody
    public Object getAllTeachings() {
        return new PageVo<Teaching>().toPageDTO(teachingServiceImp.getAllTeachings());
    }

    @RequestMapping("/student/teaching/getTeachingsByCourseOrTeacher")
    @PreAuthorize("hasAnyRole('student')")
    @ResponseBody
    public Object getTeachingsByCourseOrTeacher(String courseName, String teacherName) {
        return new PageVo<Teaching>().toPageDTO(
                teachingServiceImp.getTeachingsByCourseOrTeacher(courseName, teacherName));
    }

}
