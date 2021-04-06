package com.penghy.gymnasium.controller.student;

import com.penghy.gymnasium.core.entity.Field;
import com.penghy.gymnasium.core.service.impl.FieldServiceImp;
import com.penghy.gymnasium.core.service.vo.PageVo;
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
@Controller("s_fieldController")
public class FieldController {
    @Resource
    private FieldServiceImp fieldServiceImp;

    @RequestMapping("/student/field/list")
    @PreAuthorize("hasAnyRole('student')")
    public String List() {
        return "/pages/view/student/fieldList";
    }

    @RequestMapping("/student/field/getAllFields")
    @PreAuthorize("hasAnyRole('student')")
    @ResponseBody
    public Object getAllFields() {
        return new PageVo<Field>().toPageDTO(fieldServiceImp.getAllFields());
    }

    @RequestMapping("/student/field/getFieldByNameLike")
    @PreAuthorize("hasAnyRole('student')")
    @ResponseBody
    public Object getFieldByNameLike(String name) {
        return new PageVo<Field>().toPageDTO(fieldServiceImp.getFieldByNameLike(name));
    }
}
