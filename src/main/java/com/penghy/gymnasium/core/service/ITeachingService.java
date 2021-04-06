package com.penghy.gymnasium.core.service;

import com.penghy.gymnasium.core.entity.Teaching;
import com.penghy.gymnasium.core.service.vo.TeachingVo;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/3 12:03
 * @description
 */
public interface ITeachingService {
    Teaching addTeaching(TeachingVo teachingDTO);
    Teaching getTeaching(String id);
    List<Teaching> getAllTeachings();
    List<Teaching> getTeachingsByTeacher(String teacherId);
    List<Teaching> getTeachingsByWeek(int week);
    List<Teaching> getTeachingsBySemester(String semester);
    List<Teaching> getTeachingsByCourse(String courseId);
    List<Teaching> getTeachingsByCourseOrTeacher(String courseName, String teacherName);
    void deleteTeaching(String id);
    void stopTeaching(Teaching teaching);
    Teaching setTeaching(TeachingVo teachingDTO);
}
