package com.penghy.gymnasium.core.service.impl;

import com.penghy.gymnasium.core.entity.Elective;
import com.penghy.gymnasium.core.mapper.ElectiveMapper;
import com.penghy.gymnasium.core.service.IElectiveService;
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
public class ElectiveServiceImp implements IElectiveService {
    @Resource
    private ElectiveMapper electiveMapper;

    @Override
    public Elective addElective(Elective elective) {
        electiveMapper.addElective(elective);
        return elective;
    }

    @Override
    public Elective getElective(String id) {
        return electiveMapper.getElective(id);
    }

    @Override
    public List<Elective> getAllElectives() {
        return electiveMapper.getAllElectives();
    }

    @Override
    public List<Elective> getElectivesByStudent(String studentId) {
        return electiveMapper.getElectivesByStudent(studentId);
    }

    @Override
    public List<Elective> getElectivesByTeaching(String teachingId) {
        return electiveMapper.getElectivesByTeaching(teachingId);
    }

    @Override
    public List<Elective> getElectivesByStudentOrTeacherOrCourse(String studentName, String teacherName, String courseName) {
        return electiveMapper.getElectivesByStudentOrTeacherOrCourse(studentName, teacherName, courseName);
    }

    @Override
    public void deleteElective(String id) {
        electiveMapper.deleteElective(id);
    }

    @Override
    public Elective setElective(Elective elective) {
        electiveMapper.setElective(elective);
        return elective;
    }

    @Override
    public void studentElective(String teachingId, String studentId) {
        if(exist(teachingId,studentId)){
            return;
        }
        Elective elective = new Elective()
                .setStudentId(studentId)
                .setTeachingId(teachingId);
        electiveMapper.addElective(elective);
    }

    public boolean exist(String teachingId, String studentId){
        return electiveMapper.getElectiveByStudentIdAndTeachingId(teachingId,studentId)!= null;
    }

    @Override
    public void teacherScoring(String electiveId, String score) {
        electiveMapper.setScore(electiveId, score);
    }
}
