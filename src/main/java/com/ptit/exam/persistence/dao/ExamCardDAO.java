package com.ptit.exam.persistence.dao;

import com.ptit.exam.persistence.entity.ExamCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * User: thuongntt
 * Date: 10/9/13
 * Time: 11:46 PM
 */
public interface ExamCardDAO extends JpaRepository<ExamCard, Long> {
    public ExamCard findByStudentIdAndSubjectId(Long studentId, Long subjectId);

    public List<ExamCard> findByStudentId(Long studentId);

    public List<ExamCard> findBySubjectId(Long subjectId);

    //    @Query(value = "DELETE FROM ExamCard ec LEFT JOIN Student st, Subject su WHERE su.id = ec.subjectId AND st.id = ec.studentId AND su.id = :id AND st.course = :course")
    @Query(value = "DELETE FROM ExamCard ec")
    public void removeBySubjectIdAndCourse(@Param("id") Long id, @Param("course") String course);
}
