package com.penghy.gymnasium.core.service.impl;

import com.penghy.gymnasium.core.entity.FieldLease;
import com.penghy.gymnasium.core.entity.TimeAxis;
import com.penghy.gymnasium.core.mapper.FieldLeaseMapper;
import com.penghy.gymnasium.core.mapper.FieldMapper;
import com.penghy.gymnasium.core.mapper.StudentMapper;
import com.penghy.gymnasium.core.service.IFieldLeaseService;
import com.penghy.gymnasium.core.service.vo.FieldLeaseVo;
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
public class FieldLeaseServiceImp implements IFieldLeaseService {
    @Resource
    private FieldLeaseMapper fieldLeaseMapper;
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private FieldMapper fieldMapper;

    @Override
    public void addFieldLease(FieldLeaseVo fieldLeaseDTO) {
        Long time = System.currentTimeMillis();
        FieldLease fieldLease = new FieldLease().setBorrowTime(time)
                .setExpire(0)
                .setLendingTime(fieldLeaseDTO.getLendingTime())
                .setFieldId(fieldLeaseDTO.getFieldId())
                .setStudentId(studentMapper.getStudentByNumber(
                        fieldLeaseDTO.getStudentNumber()).getId());
        fieldLeaseMapper.addFieldLease(fieldLease);
        fieldMapper.setFieldState(fieldLeaseDTO.getFieldId(), 1);

//        MyTimerTask timerTask = new MyTimerTask().setFieldLease(fieldLease.setExpire(1))
//                .setFieldId(fieldLeaseDTO.getFieldId())
//                .setFieldLeaseMapper(fieldLeaseMapper)
//                .setFieldMapper(fieldMapper);
//        Timer timer = new Timer();
//        timer.schedule(timerTask,fieldLease.lendingToTimeStamp());         //第二参数为多少时间后（1000为1秒）

        Long endTime = time + fieldLease.lendingToTimeStamp();
        TimeAxis timeAxis = new TimeAxis();timeAxis.setStartTime(time);
        timeAxis.setEndTime(endTime);
        timeAxis.setFieldId(fieldLeaseDTO.getFieldId());
        timeAxis.setFieldLeaseId(fieldLease.getId());
        fieldMapper.addTimeAxis(timeAxis);
    }

    @Override
    public FieldLease getFieldLease(String id) {
        return fieldLeaseMapper.getFieldLease(id);
    }

    @Override
    public List<FieldLease> getFieldLeaseByFieldNameLikeOrStudentNumber(String fieldName, String studentNumber) {
        List<FieldLease> fieldLeaseList =
                fieldLeaseMapper.getFieldLeaseByFieldNameLikeOrStudentNumber(fieldName, studentNumber);
        return getExpire(fieldLeaseList);
    }

    @Override
    public List<FieldLease> getAllFieldLeases() {
        List<FieldLease> fieldLeaseList = fieldLeaseMapper.getAllFieldLeases();
        return getExpire(fieldLeaseList);
    }

    private List<FieldLease> getExpire(List<FieldLease> fieldLeaseList) {
        Long time = System.currentTimeMillis();
        for (FieldLease fieldLease : fieldLeaseList) {
            if (time >= fieldLease.getBorrowTime() && time <= fieldLease.getExpirationTime()) {
                fieldLease.setExpire(0);
            } else if (time > fieldLease.getExpirationTime()) {
                fieldLease.setExpire(1);
            } else if (time < fieldLease.getBorrowTime()) {
                fieldLease.setExpire(2);
            }
        }
        return fieldLeaseList;
    }

    @Override
    public void deleteFieldLease(String id) {
        fieldLeaseMapper.deleteFieldLease(id);
    }

    @Override
    public void setFieldLease(FieldLease fieldLease) {
        fieldLeaseMapper.setFieldLease(fieldLease);
    }

    @Override
    public long getCount() {
        return fieldLeaseMapper.getCount();
    }
}
