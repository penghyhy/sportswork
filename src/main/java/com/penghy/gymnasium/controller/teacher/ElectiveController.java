package com.penghy.gymnasium.controller.teacher;

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
@Controller("t_electiveController")
public class ElectiveController {
    @Resource
    private ElectiveServiceImp electiveServiceImp;
    @Resource
    private TeachingServiceImp teachingServiceImp;

    @RequestMapping("/teacher/getElectivesByTeaching")
    @PreAuthorize("hasAnyRole('teacher')")
    @ResponseBody
    public Object getElectivesByTeaching(String teachingId) {
        return new PageVo<Elective>().toPageDTO(
                electiveServiceImp.getElectivesByTeaching(teachingId));
    }

    @RequestMapping(value = "/teacher/teacherScoring", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('teacher')")
    @ResponseBody
    public String teacherScoring(String electiveId, String score) {
        electiveServiceImp.teacherScoring(electiveId, score);
        return "success";
    }

    @RequestMapping("/teacher/teaching/teachingList")
    @PreAuthorize("hasAnyRole('teacher')")
    public String teachingList() {
        return "/pages/view/teacher/teachingList";
    }

    @RequestMapping("/teacher/teaching/getTeachingsByTeacher")
    @PreAuthorize("hasAnyRole('teacher')")
    @ResponseBody
    public Object getTeachingsByTeacher() {
        SecurityUserInfo userDetails = (SecurityUserInfo) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return new PageVo<Teaching>().toPageDTO(teachingServiceImp.getTeachingsByTeacher(userDetails.getRoleId()));
    }

    @RequestMapping("/teacher/teaching/getTeachingsByCourseOrTeacher")
    @PreAuthorize("hasAnyRole('teacher')")
    @ResponseBody
    public Object getTeachingsByCourseOrTeacher(String courseName, String teacherName) {
        return new PageVo<Teaching>().toPageDTO(
                teachingServiceImp.getTeachingsByCourseOrTeacher(courseName, teacherName));
    }
}
