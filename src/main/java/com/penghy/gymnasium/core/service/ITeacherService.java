package com.penghy.gymnasium.core.service;

import com.penghy.gymnasium.core.entity.Teacher;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/3 12:02
 * @description
 */
public interface ITeacherService {
    Teacher addTeacher(Teacher teacher);
    Teacher getTeacher(String id);
    Teacher getTeacherByNumber(String number);
    List<Teacher> getAllTeachers();
    void deleteTeacher(String id);
    Teacher setTeacher(Teacher teacher);
}
