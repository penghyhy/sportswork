package com.penghy.gymnasium.core.mapper;

import com.penghy.gymnasium.core.entity.FieldLease;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
public interface FieldLeaseMapper {
    void addFieldLease(FieldLease fieldLease);

    FieldLease getFieldLease(@Param("id") String id);

    List<FieldLease> getFieldLeaseByFieldNameLikeOrStudentNumber(@Param("fieldName") String fieldName, @Param("studentNumber") String studentNumber);

    List<FieldLease> getAllFieldLeases();

    void deleteFieldLease(@Param("id") String id);

    void setFieldLease(FieldLease fieldLease);

    long getCount();
}
