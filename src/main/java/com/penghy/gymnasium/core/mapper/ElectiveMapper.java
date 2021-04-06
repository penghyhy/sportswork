package com.penghy.gymnasium.core.mapper;

import com.penghy.gymnasium.core.entity.Elective;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
public interface ElectiveMapper {
    void addElective(Elective elective);

    Elective getElective(@Param("id") String id);

    Elective getElectiveByStudentIdAndTeachingId(@Param("teachingId") String teachingId, @Param("studentId") String studentId);

    List<Elective> getAllElectives();

    List<Elective> getElectivesByStudent(@Param("studentId") String studentId);

    List<Elective> getElectivesByTeaching(@Param("teachingId") String teachingId);

    List<Elective> getElectivesByStudentOrTeacherOrCourse(
            @Param("studentName") String studentName, @Param("teacherName") String teacherName, @Param("courseName") String courseName);

    void deleteElective(@Param("id") String id);

    void setElective(Elective elective);

    long getCount();

    void setScore(@Param("id") String id, @Param("score") String score);
}
