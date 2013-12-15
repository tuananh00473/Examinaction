package com.ptit.exam.business;

import com.ptit.exam.persistence.entity.Answer;
import com.ptit.exam.persistence.entity.Question;

import java.util.List;

/**
 * User: Anhnt
 * Date: 9/4/13
 * Time: 2:39 PM
 */
public interface AnswerService {
    public Answer findById(Long id);

    public Answer save(Answer answer);

    public void deleteById(Long id);

    public void delete(Answer answer);

    public List<Answer> getAll();

    public List<Answer> findByQuestionId(Long questionId);

    public void deleteByQuestionId(Long questionId);

    public int[] loadCorrectAnswer(List<Question> questionList);
}
