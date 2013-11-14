package com.ptit.exam.business;

import com.ptit.exam.persistence.entity.Exam;

import java.util.List;

/**
 * User: thuongntt
 * Date: 9/25/13
 * Time: 10:40 AM
 */
public interface ExamService
{
    public Exam findById(Long id);

    public Exam save(Exam exam);

    public void deleteById(Long id);

    public void delete(Exam exam);

    public List<Exam> getAll();

    public List<Exam> findBySubjectCode(String subjectCode);
}
