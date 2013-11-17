package com.ptit.exam.persistence.dao;

import com.ptit.exam.persistence.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * User: thuongntt
 * Date: 9/25/13
 * Time: 10:36 AM
 */
public interface SubjectDAO extends JpaRepository<Subject, Long> {
    public List<Subject> findBySubjectName(String nameOfSubject);

    public List<Subject> findByFaculty(String faculty);

    public Subject findByFacultyAndSubjectName(String faculty, String nameOfSubject);

    @Query(value = "select su " +
            "from Subject su, Student st, ExamCard ec " +
            "where su.id = ec.subjectId " +
            "and st.id = ec.studentId " +
            "and st.course = :course " +
            "and su.faculty = :faculty " +
            "and su.id = :id")
    public List<Subject> findByCourseAndFaculty(@Param("course") String course, @Param("faculty") String faculty, @Param("id") Long id);
}
