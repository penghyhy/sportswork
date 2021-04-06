package com.penghy.gymnasium.controller.admin;

import com.penghy.gymnasium.core.entity.Field;
import com.penghy.gymnasium.core.service.vo.PageVo;
import com.penghy.gymnasium.core.service.impl.FieldServiceImp;
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
@Controller("fieldController")
public class FieldController {
    @Resource
    private FieldServiceImp fieldServiceImp;

    @RequestMapping("/admin/field/list")
    @PreAuthorize("hasAnyRole('admin')")
    public String List() {
        return "/pages/view/admin/field/list";
    }

    @RequestMapping("/admin/field/getAllFields")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getAllFields() {
        return new PageVo<Field>().toPageDTO(fieldServiceImp.getAllFields());
    }

    @RequestMapping("/admin/field/getFieldByNameLike")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getFieldByNameLike(String name) {
        return new PageVo<Field>().toPageDTO(fieldServiceImp.getFieldByNameLike(name));
    }

    @RequestMapping(value = "/admin/field/add", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String add(Field field) {
        fieldServiceImp.addField(field);
        return "success";
    }


    @RequestMapping(value = "/admin/field/edit", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String edit(Field field) {
        fieldServiceImp.setField(field);
        return "success";
    }

    @RequestMapping(value = "/admin/field/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String delete(@RequestParam String id) {
        fieldServiceImp.deleteField(id);
        return "true";
    }
}
