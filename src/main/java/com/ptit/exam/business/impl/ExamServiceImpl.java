package com.ptit.exam.business.impl;

import com.ptit.exam.business.ExamService;
import com.ptit.exam.persistence.dao.ExamDAO;
import com.ptit.exam.persistence.entity.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: thuongntt
 * Date: 9/25/13
 * Time: 10:43 AM
 */
@Component("examService")
public class ExamServiceImpl implements ExamService {

    @Autowired
    ExamDAO examDAO;

    @Override
    public Exam findById(Long id) {
        return examDAO.findOne(id);
    }

    @Override
    public Exam save(Exam Exam) {
        return examDAO.saveAndFlush(Exam);
    }

    @Override
    public void deleteById(Long id) {
        examDAO.delete(id);
    }

    @Override
    public void delete(Exam Exam) {
        examDAO.delete(Exam);
    }

    @Override
    public List<Exam> getAll() {
        return examDAO.findAll();
    }

    @Override
    public List<Exam> findBySubjectCode(String subjectCode) {
        return examDAO.findBySubjectCode(subjectCode);
    }

    @Override
    public List<Exam> findBySubjectName(String subjectName) {
        return examDAO.findBySubjectName(subjectName);
    }
}
