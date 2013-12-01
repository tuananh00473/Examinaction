package com.ptit.exam.business.impl;

import com.ptit.exam.business.ResultService;
import com.ptit.exam.persistence.dao.ResultDAO;
import com.ptit.exam.persistence.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: Admin
 * Date: 11/24/13
 * Time: 9:06 AM
 */
@Component("resultService")
public class ResultServiceImpl implements ResultService {
    @Autowired
    ResultDAO resultDAO;

    @Override
    public Result save(Result result) {
        return resultDAO.save(result);
    }

    @Override
    public Result findByExamIdAndStudentId(Long examId, Long studentId) {
        return resultDAO.findByExamIdAndStudentId(examId, studentId);
    }

    @Override
    public List<Result> findByFaculty(String faculty) {
        return resultDAO.findByFaculty(faculty);
    }

    @Override
    public List<Result> findByClassRoom(String classRoom) {
        return resultDAO.findByClassRoom(classRoom);
    }

    @Override
    public List<Result> findBySubjectName(String subjectName) {
        return resultDAO.findBySubjectName(subjectName);
    }

    @Override
    public List<Result> findByExamName(String examName) {
        return resultDAO.findByExamName(examName);
    }

    @Override
    public List<Result> getAll() {
        return resultDAO.findAll();
    }
}
