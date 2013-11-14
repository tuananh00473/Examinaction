package com.ptit.exam.persistence.dao;

import com.ptit.exam.persistence.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * User: thuongntt
 * Date: 9/25/13
 * Time: 10:37 AM
 */
public interface ExamDAO extends JpaRepository<Exam, Long>
{
    public Exam findByExamCode(String examCode);

    public Exam findByExamName(String examName);

    public List<Exam> findBySubjectCode(String subjectCode);

}
