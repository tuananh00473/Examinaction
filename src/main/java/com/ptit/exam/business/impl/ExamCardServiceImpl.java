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
@Component("examCardService")
public class ExamCardServiceImpl implements ExamCardService {
    @Autowired
    ExamCardDAO examCardDAO;

    @Override
    public ExamCard findById(Long id) {
        return examCardDAO.findOne(id);
    }

    @Override
    public ExamCard save(ExamCard result) {
        return examCardDAO.saveAndFlush(result);
    }

    @Override
    public void deleteById(Long id) {
        examCardDAO.delete(id);
    }

    @Override
    public void delete(ExamCard result) {
        examCardDAO.delete(result);
    }

    @Override
    public List<ExamCard> getAll() {
        return examCardDAO.findAll();
    }

    @Override
    public ExamCard findByStudentIdAndSubjectId(Long studentId, Long subjectId) {
        return examCardDAO.findByStudentIdAndSubjectId(studentId, subjectId);
    }

    @Override
    public void deActiveSubject(String course, String faculty, Long subjectId) {
        List<ExamCard> examCardRemoveList = examCardDAO.findBySubjectIdAndCourse(course, faculty, subjectId);
        for (ExamCard examCard : examCardRemoveList) {
            examCardDAO.delete(examCard);
        }
    }

    @Override
    public List<ExamCard> findBySubjectNameAndClassRoom(String classRoom, String subjectName) {
        return examCardDAO.findBySubjectNameAndClassRoom(classRoom, subjectName);
    }

    @Override
    public List<ExamCard> findByStudentId(Long studentId) {
        return examCardDAO.findByStudentId(studentId);
    }

    @Override
    public List<ExamCard> findBySubjectCode(String subjectCode) {
        return examCardDAO.findBySubjectCode(subjectCode);
    }

    @Override
    public List<ExamCard> findByClassRoom(String classRoom) {
        return examCardDAO.findByClassRoom(classRoom);
    }

    @Override
    public List<ExamCard> findBySubjectName(String subjectName) {

        return examCardDAO.findBySubjectName(subjectName);
    }
}
