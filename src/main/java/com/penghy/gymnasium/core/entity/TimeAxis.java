package com.penghy.gymnasium.core.entity;

import com.penghy.gymnasium.core.baseEntity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TimeAxis extends BaseEntity {
    private Long startTime;
    private Long endTime;
    private String fieldId;
    private String fieldLeaseId;

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldLeaseId() {
        return fieldLeaseId;
    }

    public void setFieldLeaseId(String fieldLeaseId) {
        this.fieldLeaseId = fieldLeaseId;
    }
}
