package com.penghy.gymnasium.core.mapper;

import com.penghy.gymnasium.core.entity.Equipment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
public interface EquipmentMapper {
    void addEquipment(Equipment equipment);

    Equipment getEquipment(@Param("id") String id);

    List<Equipment> getEquipmentByNameLike(String _parameter);

    List<Equipment> getAllEquipments();

    void deleteEquipment(@Param("id") String id);

    void setEquipment(Equipment equipment);

    void setEquipmentLend(Equipment equipment);

    long getCount();
}
