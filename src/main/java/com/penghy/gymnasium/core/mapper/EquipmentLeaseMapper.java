package com.penghy.gymnasium.core.mapper;

import com.penghy.gymnasium.core.entity.EquipmentLease;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
public interface EquipmentLeaseMapper {
    void addEquipmentLease(EquipmentLease equipmentLease);

    EquipmentLease getEquipmentLease(@Param("id") String id);

    List<EquipmentLease> getEquipmentLeaseByEquipmentNameOrStudentNumber(@Param("equipmentName") String equipmentName, @Param("studentNumber") String studentNumber);

    List<EquipmentLease> getAllEquipmentLeases();

    void deleteEquipmentLease(@Param("id") String id);

    void setEquipmentLease(EquipmentLease equipmentLease);

    void setReturn(EquipmentLease equipmentLease);

    long getCount();
}
