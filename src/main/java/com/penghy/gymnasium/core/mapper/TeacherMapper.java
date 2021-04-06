package com.penghy.gymnasium.core.mapper;

import com.penghy.gymnasium.core.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
public interface TeacherMapper {
    void addTeacher(Teacher teacher);

    Teacher getTeacher(@Param("id") String id);

    Teacher getTeacherByNumber(@Param("number") String number);

    List<Teacher> getAllTeachers();

    void deleteTeacher(@Param("id") String id);

    void setTeacher(Teacher teacher);

    long getCount();
}
