package com.penghy.gymnasium.core.service.tool;

import com.penghy.gymnasium.core.entity.FieldLease;
import com.penghy.gymnasium.core.mapper.FieldLeaseMapper;
import com.penghy.gymnasium.core.mapper.FieldMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.TimerTask;

/**
 * @author HY-001
 * @date 2020-07-06 12:12:12
 * @description
 */
@Slf4j
@Service
@Transactional
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class MyTimerTask extends TimerTask {
    private FieldLease fieldLease;
    private String fieldId;
    private FieldLeaseMapper fieldLeaseMapper;
    private FieldMapper fieldMapper;

    @Override
    public void run() {
        fieldLeaseMapper.setFieldLease(fieldLease);
        fieldMapper.setFieldState(fieldId, 0);
    }

    public MyTimerTask setFieldLease(FieldLease fieldLease) {
        this.fieldLease = fieldLease;
        return this;
    }

    public MyTimerTask setFieldId(String fieldId) {
        this.fieldId = fieldId;
        return this;
    }

    public MyTimerTask setFieldLeaseMapper(FieldLeaseMapper fieldLeaseMapper) {
        this.fieldLeaseMapper = fieldLeaseMapper;
        return this;
    }

    public MyTimerTask setFieldMapper(FieldMapper fieldMapper) {
        this.fieldMapper = fieldMapper;
        return this;
    }
}
