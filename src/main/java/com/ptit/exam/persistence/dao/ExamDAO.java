package com.ptit.exam.persistence.dao;

import com.ptit.exam.persistence.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * User: thuongntt
 * Date: 9/25/13
 * Time: 10:37 AM
 */
public interface ExamDAO extends JpaRepository<Exam, Long> {
    public Exam findByExamCode(String examCode);

    public Exam findByExamName(String examName);

    public List<Exam> findBySubjectCode(String subjectCode);

    @Query(value = "select e " +
            "from Exam e, Subject su " +
            "where e.subjectCode = su.subjectCode " +
            "and su.subjectName = :subjectName")

    public List<Exam> findBySubjectName(@Param("subjectName") String subjectName);

}
