package com.penghy.gymnasium.core.mapper;

import com.penghy.gymnasium.core.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
public interface CourseMapper {
    void addCourse(Course course);

    Course getCourse(@Param("id") String id);

    Course getCourseByNumber(@Param("id") String id);

    List<Course> getAllCourses();

    void deleteCourse(@Param("id") String id);

    void setCourse(Course course);

    long getCount();
}
