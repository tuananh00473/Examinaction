package com.ptit.exam.business.impl;

import com.ptit.exam.business.ExamCardService;
import com.ptit.exam.persistence.dao.ExamCardDAO;
import com.ptit.exam.persistence.entity.ExamCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: thuongntt
 * Date: 10/9/13
 * Time: 11:49 PM
 */
@Component("resultService")
public class ExamCardServiceImpl implements ExamCardService {
    @Autowired
    ExamCardDAO resultDAO;

    @Override
    public ExamCard findById(Long id) {
        return resultDAO.findOne(id);
    }

    @Override
    public ExamCard save(ExamCard result) {
        return resultDAO.saveAndFlush(result);
    }

    @Override
    public void deleteById(Long id) {
        resultDAO.delete(id);
    }

    @Override
    public void delete(ExamCard result) {
        resultDAO.delete(result);
    }

    @Override
    public List<ExamCard> getAll() {
        return resultDAO.findAll();
    }

    @Override
    public ExamCard findByStudentIdAndSubjectId(Long studentId, Long subjectId) {
        return resultDAO.findByStudentIdAndSubjectId(studentId, subjectId);
    }


}
