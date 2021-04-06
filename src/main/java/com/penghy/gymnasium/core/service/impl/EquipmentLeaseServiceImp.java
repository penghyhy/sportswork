package com.penghy.gymnasium.core.service.impl;

import com.penghy.gymnasium.core.entity.Equipment;
import com.penghy.gymnasium.core.entity.EquipmentLease;
import com.penghy.gymnasium.core.mapper.EquipmentLeaseMapper;
import com.penghy.gymnasium.core.mapper.EquipmentMapper;
import com.penghy.gymnasium.core.mapper.StudentMapper;
import com.penghy.gymnasium.core.service.IEquipmentLeaseService;
import com.penghy.gymnasium.core.service.vo.EquipmentLeaseVo;
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
public class EquipmentLeaseServiceImp implements IEquipmentLeaseService {
    @Resource
    private EquipmentLeaseMapper equipmentLeaseMapper;
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private EquipmentMapper equipmentMapper;

    @Override
    public void addEquipmentLease(EquipmentLeaseVo equipmentLeaseVo) {
        Equipment equipment = equipmentMapper.getEquipment(equipmentLeaseVo.getEquipmentId());
        if ("".equals(equipmentLeaseVo.getStudentNumber()) || equipmentLeaseVo.getStudentNumber() == null) {
            throw new RuntimeException("学生学号不能为空");
        }
        if (equipment.getCount() - equipment.getLend() < equipmentLeaseVo.getNumber()) {
            throw new RuntimeException("器材数量不足");
        } else {
            Long time = System.currentTimeMillis();
            EquipmentLease equipmentLease = new EquipmentLease().setBorrowTime(time)
                    .setState(0)
                    .setNumber(equipmentLeaseVo.getNumber())
                    .setEquipmentId(equipmentLeaseVo.getEquipmentId())
                    .setStudentId(studentMapper.getStudentByNumber(
                            equipmentLeaseVo.getStudentNumber()).getId());
            equipment.setLend(equipment.getLend() + equipmentLeaseVo.getNumber());
            equipmentLeaseMapper.addEquipmentLease(equipmentLease);
            equipmentMapper.setEquipmentLend(equipment);
        }
    }

    @Override
    public void returnEquipment(String equipmentLeaseId) {
        EquipmentLease equipmentLease = equipmentLeaseMapper.getEquipmentLease(equipmentLeaseId)
                .setReturnTime(System.currentTimeMillis())
                .setState(1);
        Equipment equipment = equipmentMapper.getEquipment(equipmentLease.getEquipmentId());
        equipmentMapper.setEquipmentLend(equipment.setLend(equipment.getLend() - equipmentLease.getNumber()));
        equipmentLeaseMapper.setReturn(equipmentLease);
    }

    @Override
    public EquipmentLease getEquipmentLease(String id) {
        return equipmentLeaseMapper.getEquipmentLease(id);
    }

    @Override
    public List<EquipmentLease> getEquipmentLeaseByEquipmentNameOrStudentNumber(String equipmentName, String studentNumber) {
        return equipmentLeaseMapper.getEquipmentLeaseByEquipmentNameOrStudentNumber(equipmentName, studentNumber);
    }

    @Override
    public List<EquipmentLease> getAllEquipmentLeases() {
        return equipmentLeaseMapper.getAllEquipmentLeases();
    }

    @Override
    public void deleteEquipmentLease(String id) {
        equipmentLeaseMapper.deleteEquipmentLease(id);
    }

    @Override
    public void setEquipmentLease(EquipmentLease equipmentLease) {
        equipmentLeaseMapper.setEquipmentLease(equipmentLease);
    }

    @Override
    public long getCount() {
        return equipmentLeaseMapper.getCount();
    }
}
