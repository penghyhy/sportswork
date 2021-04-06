package com.penghy.gymnasium.controller.equipmentAdmin;

import com.penghy.gymnasium.core.entity.Equipment;
import com.penghy.gymnasium.core.service.impl.EquipmentServiceImp;
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
@Controller("ea_equipmentController")
public class EquipmentController {
    @Resource
    private EquipmentServiceImp equipmentServiceImp;

    @RequestMapping("/equipment_admin/equipment/list")
    @PreAuthorize("hasAnyRole('equipment_admin')")
    public String List() {
        return "/pages/view/equipment_admin/equipment/list";
    }

    @RequestMapping("/equipment_admin/equipment/getAllEquipments")
    @PreAuthorize("hasAnyRole('equipment_admin')")
    @ResponseBody
    public Object getAllEquipments() {
        return new PageVo<Equipment>().toPageDTO(equipmentServiceImp.getAllEquipments());
    }

    @RequestMapping("/equipment_admin/equipment/getEquipmentByNameLike")
    @PreAuthorize("hasAnyRole('equipment_admin')")
    @ResponseBody
    public Object getEquipmentByNameLike(String name) {
        return new PageVo<Equipment>().toPageDTO(equipmentServiceImp.getEquipmentByNameLike(name));
    }
}
