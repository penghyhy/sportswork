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
public class Elective extends BaseEntity {

    public String getId() {
        return this.id;
    }

    private String studentId;
    private String teachingId;
    private String score;

    private Student student;
    private Teaching teaching;
}
