package com.penghy.gymnasium.core.service.impl;

import com.penghy.gymnasium.core.entity.Course;
import com.penghy.gymnasium.core.mapper.CourseMapper;
import com.penghy.gymnasium.core.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */

@Slf4j
@Service
@Transactional
public class CourseServiceImp implements ICourseService {

    @Resource
    private CourseMapper courseMapper;

    @Override
    public void addCourse(Course course) {
        courseMapper.addCourse(course);
    }

    @Override
    public void deleteCourse(String courseId) {
        courseMapper.deleteCourse(courseId);
    }

    @Override
    public void setCourse(Course course) {
        courseMapper.setCourse(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseMapper.getAllCourses();
    }

    @Override
    public Course getCourse(String courseId) {
        return courseMapper.getCourse(courseId);
    }

    @Override
    public Course getCourseByNumber(String number) {
        return courseMapper.getCourseByNumber(number);
    }
}
