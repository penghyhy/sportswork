package com.penghy.gymnasium.core.service.impl;

import com.penghy.gymnasium.core.entity.Field;
import com.penghy.gymnasium.core.entity.TimeAxis;
import com.penghy.gymnasium.core.mapper.FieldMapper;
import com.penghy.gymnasium.core.service.IFieldService;
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
public class FieldServiceImp implements IFieldService {
    @Resource
    private FieldMapper fieldMapper;

    @Override
    public void addField(Field field) {
        field.setState("未借用");
        fieldMapper.addField(field);
    }

    @Override
    public Field getField(String id) {
        return fieldMapper.getField(id);
    }

    @Override
    public List<Field> getFieldByNameLike(String name) {
        return fieldMapper.getFieldByNameLike(name);
    }

    @Override
    public List<Field> getAllFields() {
        List<Field> fieldList = fieldMapper.getAllFields();
        return getState(fieldList);
    }

    private List<Field> getState(List<Field> fieldList) {
        Long time = System.currentTimeMillis();
        for (Field field : fieldList) {
            List<TimeAxis> timeAxes = field.getTimeAxes();
            int k = 0;
            for (TimeAxis timeAxis : timeAxes) {
                if (time >= timeAxis.getStartTime() && time <= timeAxis.getEndTime()) {
                    k = 1;
                }
            }
            if (k == 1) {
                field.setState("1");
            } else {
                field.setState("0");
            }
        }
        return fieldList;
    }

    @Override
    public void deleteField(String id) {
        fieldMapper.deleteField(id);
    }

    @Override
    public void setField(Field field) {
        fieldMapper.setField(field);
    }

    @Override
    public long getCount() {
        return fieldMapper.getCount();
    }
}
