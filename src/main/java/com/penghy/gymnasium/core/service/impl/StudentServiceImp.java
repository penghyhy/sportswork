package com.penghy.gymnasium.core.service.impl;

import com.penghy.gymnasium.core.entity.Student;
import com.penghy.gymnasium.core.mapper.StudentMapper;
import com.penghy.gymnasium.core.service.IStudentService;
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
public class StudentServiceImp implements IStudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    public Student addStudent(Student student) {
        studentMapper.addStudent(student);
        return student;
    }

    @Override
    public Student getStudent(String id) {
        return studentMapper.getStudent(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.getAllStudents();
    }

    @Override
    public void deleteStudent(String id) {
        studentMapper.deleteStudent(id);
    }

    @Override
    public Student setStudent(Student student) {
        studentMapper.setStudent(student);
        return student;
    }
}
