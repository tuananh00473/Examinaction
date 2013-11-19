package com.ptit.exam.business;

import com.ptit.exam.persistence.entity.ExamCard;

import java.util.List;

/**
 * User: thuongntt
 * Date: 10/9/13
 * Time: 11:48 PM
 */
public interface ExamCardService
{
    public ExamCard findById(Long id);

    public ExamCard save(ExamCard result);

    public void deleteById(Long id);

    public void delete(ExamCard mark);

    public List<ExamCard> getAll();

    public ExamCard findByStudentIdAndSubjectId(Long studentId, Long subjectId);

    public void deActiveSubject(String course, String faculty, Long subjectId);

    public List<ExamCard> findBySubjectNameAndClassRoom(String classRoom, String subjectName);

    public List<ExamCard> findByStudentId(Long studentId);
}
