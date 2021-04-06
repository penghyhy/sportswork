package com.penghy.gymnasium.core.service;

import com.penghy.gymnasium.core.service.vo.FieldLeaseVo;
import com.penghy.gymnasium.core.entity.FieldLease;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/3/3 21:21
 * @description
 */
public interface IFieldLeaseService {
    void addFieldLease(FieldLeaseVo fieldLeaseVo);
    FieldLease getFieldLease(String id);
    List<FieldLease> getFieldLeaseByFieldNameLikeOrStudentNumber(String fieldName, String studentNumber);
    List<FieldLease> getAllFieldLeases();
    void deleteFieldLease(String id);
    void setFieldLease(FieldLease fieldLease);
    long getCount();
}
