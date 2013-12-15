package com.ptit.exam.business.impl;

import com.ptit.exam.business.AnswerService;
import com.ptit.exam.persistence.dao.AnswerDAO;
import com.ptit.exam.persistence.entity.Answer;
import com.ptit.exam.persistence.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: Anhnt
 * Date: 9/4/13
 * Time: 2:40 PM
 */
@Component("answerService")
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    AnswerDAO answerDAO;

    @Override
    public Answer findById(Long id) {
        return answerDAO.findOne(id);
    }

    @Override
    public Answer save(Answer answer) {
        return answerDAO.saveAndFlush(answer);
    }

    @Override
    public void deleteById(Long id) {
        answerDAO.delete(id);
    }

    @Override
    public void delete(Answer answer) {
        answerDAO.delete(answer);
    }


    @Override
    public List<Answer> getAll() {
        return answerDAO.findAll();
    }

    @Override
    public List<Answer> findByQuestionId(Long questionId) {

        return answerDAO.findByQuestionId(questionId);
    }

    @Override
    public void deleteByQuestionId(Long questionId) {
        List<Answer> answers = answerDAO.findByQuestionId(questionId);
        for (Answer answer : answers) {
            answerDAO.delete(answer);
        }
    }

    @Override
    public int[] loadCorrectAnswer(List<Question> questionList) {
        int totalQuestionCount = questionList.size();
        int[] correctAnswers = new int[totalQuestionCount];
        for (int i = 0; i < totalQuestionCount; i++) {
            Question question = questionList.get(i);
            List<Answer> answers = findByQuestionId(question.getId());
            question.setAnswerList(answers);

            for (int j = 0; j < 4; j++) {
                if (answers.get(j).isCorrect()) {
                    correctAnswers[i] = j + 1;
                }
            }
        }
        return correctAnswers;
    }
}
