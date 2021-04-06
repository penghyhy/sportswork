package com.penghy.gymnasium.controller.admin;

import com.penghy.gymnasium.core.entity.Elective;
import com.penghy.gymnasium.core.service.vo.PageVo;
import com.penghy.gymnasium.core.service.impl.ElectiveServiceImp;
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
@Controller("electiveController")
public class ElectiveController {
    @Resource
    private ElectiveServiceImp electiveServiceImp;

    @RequestMapping("/admin/elective/list")
    @PreAuthorize("hasAnyRole('admin')")
    public String List() {
        return "/pages/view/admin/elective/list";
    }

    @RequestMapping("/admin/elective/getAllElectives")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getAllElectives() {
        return new PageVo<Elective>().toPageDTO(electiveServiceImp.getAllElectives());
    }

    @RequestMapping("/admin/elective/getElectivesByStudentOrTeacherOrCourse")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getElectivesByStudentOrTeacherOrCourse(String studentName, String teacherName, String courseName) {
        return new PageVo<Elective>().toPageDTO(
                electiveServiceImp.getElectivesByStudentOrTeacherOrCourse(
                        studentName, teacherName, courseName));
    }

    @RequestMapping(value = "/admin/elective/add", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String add(Elective elective) {
        electiveServiceImp.addElective(elective);
        return "success";
    }


    @RequestMapping(value = "/admin/elective/edit", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String edit(Elective elective) {
        electiveServiceImp.setElective(elective);
        return "success";
    }

    @RequestMapping(value = "/admin/elective/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String delete(@RequestParam String id) {
        electiveServiceImp.deleteElective(id);
        return "true";
    }
}
