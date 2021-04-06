package com.penghy.gymnasium.core.mapper;

import com.penghy.gymnasium.core.entity.Teaching;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
public interface TeachingMapper {
    void addTeaching(Teaching teaching);

    Teaching getTeaching(@Param("id") String id);

    List<Teaching> getAllTeachings();

    List<Teaching> getTeachingsByTeacher(@Param("teacherId") String teacherId);

    List<Teaching> getTeachingsByWeek(@Param("week") int week);

    List<Teaching> getTeachingsBySemester(@Param("semester") String semester);

    List<Teaching> getTeachingsByCourse(@Param("courseId") String courseId);

    List<Teaching> getTeachingsByCourseOrTeacher(@Param("courseName") String courseName, @Param("teacherName") String teacherName);

    void deleteTeaching(@Param("id") String id);

    void setTeaching(Teaching teaching);

    void stopTeaching(Teaching teaching);

    long getCount();
}
