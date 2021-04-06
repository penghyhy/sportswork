package com.penghy.gymnasium.core.baseEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseEntity implements Serializable {
    /**
     * 全局唯一Id
     */

    protected String id;
}
