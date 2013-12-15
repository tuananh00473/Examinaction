package com.ptit.exam.persistence.dao;

import com.ptit.exam.persistence.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * User: Administrator
 * Date: 8/22/13
 * Time: 9:36 PM
 */
public interface QuestionDAO extends JpaRepository<Question, Long> {
    public List<Question> findBySubjectCode(String subjectCode);

    public List<Question> findBySubjectCodeAndChapterAndLevel(String subjectCode, int chapter, int level);

    public List<Question> findByChapter(int value);

    public List<Question> findByLevel(int value);

    public List<Question> findBySubjectCodeAndLevel(String subjectCode, int difficult);

    @Query(value = "select q " +
            "from Question q, Subject su " +
            "where q.subjectCode = su.subjectCode " +
            "and su.subjectName = :subjectName")
    public List<Question> findBySubjectName(@Param("subjectName") String subjectName);
}
