package com.penghy.gymnasium.core.service.impl;

import com.penghy.gymnasium.core.entity.Equipment;
import com.penghy.gymnasium.core.mapper.EquipmentMapper;
import com.penghy.gymnasium.core.service.IEquipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */

@Slf4j
@Service
@Transactional
public class EquipmentServiceImp implements IEquipmentService {
    @Resource
    private EquipmentMapper equipmentMapper;

    @Override
    public void addEquipment(Equipment equipment) {
        equipment.setLend(0);
        equipmentMapper.addEquipment(equipment);
    }

    @Override
    public Equipment getEquipment(String id) {
        return equipmentMapper.getEquipment(id);
    }

    @Override
    public List<Equipment> getEquipmentByNameLike(String name) {
        return equipmentMapper.getEquipmentByNameLike(name);
    }

    @Override
    public List<Equipment> getAllEquipments() {
        return equipmentMapper.getAllEquipments();
    }

    @Override
    public void deleteEquipment(String id) {
        equipmentMapper.deleteEquipment(id);
    }

    @Override
    public void setEquipment(Equipment equipment) {
        equipmentMapper.setEquipment(equipment);
    }

    @Override
    public long getCount() {
        return equipmentMapper.getCount();
    }
}
