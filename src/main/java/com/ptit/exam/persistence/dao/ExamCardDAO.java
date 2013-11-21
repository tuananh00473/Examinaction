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
public interface ExamCardDAO extends JpaRepository<ExamCard, Long>
{
    public ExamCard findByStudentIdAndSubjectId(Long studentId, Long subjectId);

    public List<ExamCard> findByStudentId(Long studentId);

    public List<ExamCard> findBySubjectId(Long subjectId);

    @Query(value = "select ec " +
            "from Subject su, Student st, ExamCard ec " +
            "where su.id = ec.subjectId " +
            "and st.id = ec.studentId " +
            "and st.course = :course " +
            "and su.faculty = :faculty " +
            "and su.id = :id")
    public List<ExamCard> findBySubjectIdAndCourse(@Param("course") String course, @Param("faculty") String faculty, @Param("id") Long id);

    @Query(value = "select ec " +
            "from Subject su, Student st, ExamCard ec " +
            "where su.id = ec.subjectId " +
            "and st.id = ec.studentId " +
            "and st.classRoom = :classRoom " +
            "and su.subjectName = :subjectName")
    public List<ExamCard> findBySubjectNameAndClassRoom(@Param("classRoom") String classRoom, @Param("subjectName") String subjectName);

    @Query(value = "select ec " +
            "from Subject su, ExamCard ec " +
            "where su.id = ec.subjectId " +
            "and su.subjectCode = :subjectCode")
    public List<ExamCard> findBySubjectCode(@Param("subjectCode") String subjectCode);

    @Query(value = "select ec " +
            "from Student st, ExamCard ec " +
            "where st.id = ec.studentId " +
            "and st.classRoom = :classRoom ")
    public List<ExamCard> findByClassRoom(@Param("classRoom") String classRoom);
}
