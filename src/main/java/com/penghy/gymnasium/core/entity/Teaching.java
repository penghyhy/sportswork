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
public class Teaching extends BaseEntity {

    public String getId() {
        return this.id;
    }

    public Teaching setId(String id) {
        this.id = id;
        return this;
    }

    private String teacherId;
    private String courseId;
    private Teacher teacher;
    private Course course;
    private String semester;
    private int state;
    private int week;   //星期
    private int timeArrange;   //节课时间安排
    private Field field;   //安排场地

    public boolean getStateBoolean() {
        return state == 0;
    }
}
