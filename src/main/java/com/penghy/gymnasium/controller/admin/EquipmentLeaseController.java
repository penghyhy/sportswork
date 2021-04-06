package com.penghy.gymnasium.controller.admin;

import com.penghy.gymnasium.core.entity.EquipmentLease;
import com.penghy.gymnasium.core.service.vo.EquipmentLeaseVo;
import com.penghy.gymnasium.core.service.vo.PageVo;
import com.penghy.gymnasium.core.service.impl.EquipmentLeaseServiceImp;
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
@Controller("equipmentLeaseController")
public class EquipmentLeaseController {
    @Resource
    private EquipmentLeaseServiceImp equipmentLeaseServiceImp;

    @RequestMapping("/admin/equipmentLease/list")
    @PreAuthorize("hasAnyRole('admin')")
    public String List() {
        return "/pages/view/admin/equipmentLease/list";
    }

    @RequestMapping("/admin/equipmentLease/getAllEquipmentLeases")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getAllEquipmentLeases() {
        return new PageVo<EquipmentLease>().toPageDTO(equipmentLeaseServiceImp.getAllEquipmentLeases());
    }

    @RequestMapping("/admin/equipmentLease/getEquipmentLeasesByEquipmentOrStudent")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getEquipmentLeasesByEquipmentOrStudent(String equipmentName, String studentName) {
        return new PageVo<EquipmentLease>().toPageDTO(
                equipmentLeaseServiceImp.getEquipmentLeaseByEquipmentNameOrStudentNumber(equipmentName, studentName));
    }

    @RequestMapping(value = "/admin/equipment/addLease", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String addLease(EquipmentLeaseVo equipmentLeaseVo) {
        equipmentLeaseServiceImp.addEquipmentLease(equipmentLeaseVo);
        return "success";
    }

    @RequestMapping(value = "/admin/equipmentLease/returnEquipment", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String returnEquipment(String equipmentLeaseId) {
        equipmentLeaseServiceImp.returnEquipment(equipmentLeaseId);
        return "true";
    }


    @RequestMapping(value = "/admin/equipmentLease/edit", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String edit(EquipmentLease equipmentLease) {
        equipmentLeaseServiceImp.setEquipmentLease(equipmentLease);
        return "success";
    }

    @RequestMapping(value = "/admin/equipmentLease/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String delete(@RequestParam String id) {
        equipmentLeaseServiceImp.deleteEquipmentLease(id);
        return "true";
    }
}
