package com.penghy.gymnasium.core.mapper;

import com.penghy.gymnasium.core.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HY-001
 * @date 2020-07-06 17:38:31
 * @description
 */
public interface StudentMapper {
    void addStudent(Student student);

    Student getStudent(@Param("id") String id);

    List<Student> getAllStudents();

    Student getStudentByNumber(@Param("number") String number);

    void deleteStudent(@Param("id") String id);

    void setStudent(Student student);

    long getCount();
}
