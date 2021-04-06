package com.penghy.gymnasium.core.service.impl;

import com.penghy.gymnasium.core.entity.Teacher;
import com.penghy.gymnasium.core.mapper.TeacherMapper;
import com.penghy.gymnasium.core.service.ITeacherService;
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
public class TeacherServiceImp implements ITeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public Teacher getTeacherByNumber(String number) {
        return teacherMapper.getTeacherByNumber(number);
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        teacherMapper.addTeacher(teacher);
        return teacher;
    }

    @Override
    public Teacher getTeacher(String id) {
        return teacherMapper.getTeacher(id);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherMapper.getAllTeachers();
    }

    @Override
    public void deleteTeacher(String id) {
        teacherMapper.deleteTeacher(id);
    }

    @Override
    public Teacher setTeacher(Teacher teacher) {
        teacherMapper.setTeacher(teacher);
        return teacher;
    }
}
