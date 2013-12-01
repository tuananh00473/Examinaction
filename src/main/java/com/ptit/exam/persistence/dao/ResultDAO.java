package com.ptit.exam.persistence.dao;

import com.ptit.exam.persistence.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * User: thuongntt
 * Date: 9/25/13
 * Time: 10:37 AM
 */
public interface ResultDAO extends JpaRepository<Result, Long> {
    public Result findByExamIdAndStudentId(Long examId, Long studentId);

    @Query(value = "select r " +
            "from Student st, Result r " +
            "where st.id = r.studentId " +
            "and st.faculty = :faculty ")
    public List<Result> findByFaculty(@Param("faculty") String faculty);

    @Query(value = "select r " +
            "from Student st, Result r " +
            "where st.id = r.studentId " +
            "and st.classRoom = :classRoom ")
    public List<Result> findByClassRoom(@Param("classRoom") String classRoom);

    @Query(value = "select r " +
            "from Subject su, Exam e, Result r " +
            "where e.id = r.examId " +
            "and e.subjectCode = su.subjectCode " +
            "and su.subjectName = :subjectName ")
    public List<Result> findBySubjectName(@Param("subjectName") String subjectName);

    @Query(value = "select r " +
            "from Result r, Exam e " +
            "where e.id = r.examId " +
            "and e.examName = :examName ")
    public List<Result> findByExamName(@Param("examName") String examName);
}
