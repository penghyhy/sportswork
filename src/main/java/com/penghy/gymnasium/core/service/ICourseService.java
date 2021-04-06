package com.penghy.gymnasium.core.service;

import com.penghy.gymnasium.core.entity.Course;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/1/9 15:45
 * @description
 */
public interface ICourseService {
    void addCourse(Course course);
    void deleteCourse(String courseId);
    void setCourse(Course course);
    List<Course> getAllCourses();
    Course getCourse(String courseId);
    Course getCourseByNumber(String number);
}
