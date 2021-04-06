package com.penghy.gymnasium.core.mapper;

import com.penghy.gymnasium.core.entity.Field;
import com.penghy.gymnasium.core.entity.TimeAxis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
public interface FieldMapper {
    void addField(Field field);

    Field getField(@Param("id") String id);

    List<Field> getFieldByNameLike(@Param("parameter") String parameter);

    List<Field> getAllFields();

    void deleteField(@Param("id") String id);

    void setField(Field field);

    void setFieldState(@Param("id") String id, @Param("state") int state);

    long getCount();

    void addTimeAxis(TimeAxis timeAixs);
}
