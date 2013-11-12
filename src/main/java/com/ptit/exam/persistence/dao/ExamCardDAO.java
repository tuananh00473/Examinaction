package com.ptit.exam.persistence.dao;

import com.ptit.exam.persistence.entity.ExamCard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User: thuongntt
 * Date: 10/9/13
 * Time: 11:46 PM
 */
public interface ExamCardDAO extends JpaRepository<ExamCard, Long> {
    public ExamCard findByStudentIdAndSubjectId(Long studentId, Long subjectId);
}
