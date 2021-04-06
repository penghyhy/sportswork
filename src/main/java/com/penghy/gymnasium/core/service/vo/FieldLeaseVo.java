package com.penghy.gymnasium.core.service.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author dengwei
 * @date 2020/3/5 21:06
 * @description
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
public class FieldLeaseVo {
    private String studentNumber;
    private String fieldId;
    private double lendingTime;     //借用时长 单位(小时)
}
