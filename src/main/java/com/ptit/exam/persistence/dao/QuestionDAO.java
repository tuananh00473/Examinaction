package com.ptit.exam.persistence.dao;

import com.ptit.exam.persistence.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * User: Administrator
 * Date: 8/22/13
 * Time: 9:36 PM
 */
public interface QuestionDAO extends JpaRepository<Question, Long> {
    public List<Question> findBySubjectId(Long subjectId);

    public List<Question> findBySubjectIdAndChapterAndLevel(Long subjectId, int chapter, int level);
}
