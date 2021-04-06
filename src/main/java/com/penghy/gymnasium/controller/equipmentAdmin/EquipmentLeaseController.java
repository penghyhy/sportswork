package com.penghy.gymnasium.controller.equipmentAdmin;

import com.penghy.gymnasium.core.entity.EquipmentLease;
import com.penghy.gymnasium.core.service.impl.EquipmentLeaseServiceImp;
import com.penghy.gymnasium.core.service.vo.EquipmentLeaseVo;
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
@Controller("ea_equipmentLeaseController")
public class EquipmentLeaseController {
    @Resource
    private EquipmentLeaseServiceImp equipmentLeaseServiceImp;

    @RequestMapping("/equipment_admin/equipmentLease/list")
    @PreAuthorize("hasAnyRole('equipment_admin')")
    public String List() {
        return "/pages/view/equipment_admin/equipmentLease/list";
    }

    @RequestMapping("/equipment_admin/equipmentLease/getAllEquipmentLeases")
    @PreAuthorize("hasAnyRole('equipment_admin')")
    @ResponseBody
    public Object getAllEquipmentLeases() {
        return new PageVo<EquipmentLease>().toPageDTO(equipmentLeaseServiceImp.getAllEquipmentLeases());
    }

    @RequestMapping("/equipment_admin/equipmentLease/getEquipmentLeasesByEquipmentOrStudent")
    @PreAuthorize("hasAnyRole('equipment_admin')")
    @ResponseBody
    public Object getEquipmentLeasesByEquipmentOrStudent(String equipmentName, String studentName) {
        return new PageVo<EquipmentLease>().toPageDTO(
                equipmentLeaseServiceImp.getEquipmentLeaseByEquipmentNameOrStudentNumber(equipmentName, studentName));
    }

    @RequestMapping(value = "/equipment_admin/equipment/addLease", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('equipment_admin')")
    @ResponseBody
    public String addLease(EquipmentLeaseVo equipmentLeaseVo) {
        equipmentLeaseServiceImp.addEquipmentLease(equipmentLeaseVo);
        return "success";
    }

    @RequestMapping(value = "/equipment_admin/equipmentLease/returnEquipment", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('equipment_admin')")
    @ResponseBody
    public String returnEquipment(String equipmentLeaseId) {
        equipmentLeaseServiceImp.returnEquipment(equipmentLeaseId);
        return "true";
    }


    @RequestMapping(value = "/equipment_admin/equipmentLease/edit", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('equipment_admin')")
    @ResponseBody
    public String edit(EquipmentLease equipmentLease) {
        equipmentLeaseServiceImp.setEquipmentLease(equipmentLease);
        return "success";
    }

    @RequestMapping(value = "/equipment_admin/equipmentLease/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('equipment_admin')")
    @ResponseBody
    public String delete(@RequestParam String id) {
        equipmentLeaseServiceImp.deleteEquipmentLease(id);
        return "true";
    }
}
