package com.penghy.gymnasium.core.service;

import com.penghy.gymnasium.core.entity.Student;

import java.util.List;

/**
 * @author dengwei
 * @date 2020/2/3 11:40
 * @description
 */
public interface IStudentService {
    Student addStudent(Student student);
    Student getStudent(String id);
    List<Student> getAllStudents();
    void deleteStudent(String id);
    Student setStudent(Student student);
}
