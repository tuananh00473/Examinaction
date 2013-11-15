package com.ptit.exam.persistence.dao;

import com.ptit.exam.persistence.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * User: Anhnt
 * Date: 9/4/13
 * Time: 2:29 PM
 */

public interface AnswerDAO extends JpaRepository<Answer, Long> {
    public List<Answer> findByQuestionId(Long questionId);

//    @Query("DELETE FROM Answer a WHERE a.questionId = :questionId")
//    public void deleteByQuestionId(@Param("questionId")Long questionId);
}
