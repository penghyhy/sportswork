package com.penghy.gymnasium.controller.equipmentAdmin;

import com.penghy.gymnasium.core.entity.FieldLease;
import com.penghy.gymnasium.core.service.impl.FieldLeaseServiceImp;
import com.penghy.gymnasium.core.service.vo.FieldLeaseVo;
import com.penghy.gymnasium.core.service.vo.PageVo;
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
@Controller("ea_fieldLeaseController")
public class FieldLeaseController {
    @Resource
    private FieldLeaseServiceImp fieldLeaseServiceImp;

    @RequestMapping("/equipment_admin/fieldLease/list")
    @PreAuthorize("hasAnyRole('equipment_admin')")
    public String List() {
        return "/pages/view/equipment_admin/fieldLease/list";
    }

    @RequestMapping("/equipment_admin/fieldLease/getAllFieldLeases")
    @PreAuthorize("hasAnyRole('equipment_admin')")
    @ResponseBody
    public Object getAllFieldLeases() {
        return new PageVo<FieldLease>().toPageDTO(fieldLeaseServiceImp.getAllFieldLeases());
    }

    @RequestMapping("/equipment_admin/fieldLease/getFieldLeasesByFieldOrStudent")
    @PreAuthorize("hasAnyRole('equipment_admin')")
    @ResponseBody
    public Object getFieldLeasesByFieldOrStudent(String fieldName, String studentNumber) {
        return new PageVo<FieldLease>().toPageDTO(
                fieldLeaseServiceImp.getFieldLeaseByFieldNameLikeOrStudentNumber(fieldName, studentNumber));
    }

    @RequestMapping(value = "/equipment_admin/field/addLease", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('equipment_admin')")
    @ResponseBody
    public String addLease(FieldLeaseVo fieldLeaseDTO) {
        fieldLeaseServiceImp.addFieldLease(fieldLeaseDTO);
        return "success";
    }


    @RequestMapping(value = "/equipment_admin/fieldLease/edit", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('equipment_admin')")
    @ResponseBody
    public String edit(FieldLease fieldLease) {
        fieldLeaseServiceImp.setFieldLease(fieldLease);
        return "success";
    }

    @RequestMapping(value = "/equipment_admin/fieldLease/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('equipment_admin')")
    @ResponseBody
    public String delete(@RequestParam String id) {
        fieldLeaseServiceImp.deleteFieldLease(id);
        return "true";
    }
}
