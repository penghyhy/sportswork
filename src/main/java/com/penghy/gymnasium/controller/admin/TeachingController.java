package com.penghy.gymnasium.controller.admin;

import com.penghy.gymnasium.core.entity.Teaching;
import com.penghy.gymnasium.core.service.vo.PageVo;
import com.penghy.gymnasium.core.service.vo.TeachingVo;
import com.penghy.gymnasium.core.service.impl.TeachingServiceImp;
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
@Controller("teachingController")
public class TeachingController {
    @Resource
    private TeachingServiceImp teachingServiceImp;

    @RequestMapping("/admin/teaching/list")
    @PreAuthorize("hasAnyRole('admin')")
    public String List() {
        return "/pages/view/admin/teaching/list";
    }

    @RequestMapping("/admin/teaching/getAllTeachings")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getAllTeachings() {
        return new PageVo<Teaching>().toPageDTO(teachingServiceImp.getAllTeachings());
    }

    @RequestMapping("/admin/teaching/getTeachingsByCourseOrTeacher")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getTeachingsByCourseOrTeacher(String courseName, String teacherName) {
        return new PageVo<Teaching>().toPageDTO(
                teachingServiceImp.getTeachingsByCourseOrTeacher(courseName, teacherName));
    }

    @RequestMapping(value = "/admin/teaching/add", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String add(TeachingVo teachingDTO) {
        teachingServiceImp.addTeaching(teachingDTO);
        return "success";
    }


    @RequestMapping(value = "/admin/teaching/edit", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String edit(TeachingVo teachingDTO) {
        teachingServiceImp.setTeaching(teachingDTO);
        return "success";
    }

    @RequestMapping(value = "/admin/teaching/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String delete(@RequestParam String id) {
        teachingServiceImp.deleteTeaching(id);
        return "true";
    }

    @RequestMapping(value = "/admin/teaching/stop", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object stop(@RequestBody Teaching teaching) {
        teachingServiceImp.stopTeaching(teaching);
        return "true";
    }
}
