package com.penghy.gymnasium.controller.admin;

import com.penghy.gymnasium.core.entity.Teacher;
import com.penghy.gymnasium.core.service.vo.PageVo;
import com.penghy.gymnasium.core.service.impl.TeacherServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
@Slf4j
@Controller("teacherController")
public class TeacherController {
    @Resource
    private TeacherServiceImp teacherServiceImp;

    @RequestMapping("/admin/teacher/list")
    @PreAuthorize("hasAnyRole('admin')")
    public String List() {
        return "/pages/view/admin/teacher/list";
    }

    @RequestMapping("/admin/teacher/getAllTeachers")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getAllTeachers() {
        return new PageVo<Teacher>().toPageDTO(teacherServiceImp.getAllTeachers());
    }

    @RequestMapping(value = "/admin/teacher/add", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String add(Teacher teacher) {
        teacherServiceImp.addTeacher(teacher);
        return "success";
    }

    @RequestMapping(value = "/admin/teacher/edit", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String edit(Teacher teacher) {
        teacherServiceImp.setTeacher(teacher);
        return "success";
    }

    @RequestMapping(value = "/admin/teacher/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String delete(@RequestParam String id) {
        teacherServiceImp.deleteTeacher(id);
        return "true";
    }
}
