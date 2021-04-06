package com.penghy.gymnasium.core.service;

import com.penghy.gymnasium.core.entity.EquipmentLease;
import com.penghy.gymnasium.core.service.vo.EquipmentLeaseVo;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/3/3 21:28
 * @description
 */
public interface IEquipmentLeaseService {
    void addEquipmentLease(EquipmentLeaseVo equipmentLeaseVo);
    void returnEquipment(String equipmentLeaseId);
    EquipmentLease getEquipmentLease(String id);
    List<EquipmentLease> getEquipmentLeaseByEquipmentNameOrStudentNumber(String equipmentName, String studentNumber);
    List<EquipmentLease> getAllEquipmentLeases();
    void deleteEquipmentLease(String id);
    void setEquipmentLease(EquipmentLease equipmentLease);
    long getCount();
}
