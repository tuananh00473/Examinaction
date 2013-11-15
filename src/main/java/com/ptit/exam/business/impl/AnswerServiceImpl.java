package com.ptit.exam.business.impl;

import com.ptit.exam.business.AnswerService;
import com.ptit.exam.persistence.dao.AnswerDAO;
import com.ptit.exam.persistence.entity.Answer;
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
    public List<Answer> getListAnswer(Long questionId) {

        return answerDAO.findByQuestionId(questionId);
    }

    @Override
    public void deleteByQuestionId(Long questionId) {
        List<Answer> answers = answerDAO.findByQuestionId(questionId);
        for (Answer answer : answers) {
            answerDAO.delete(answer);
        }
    }
}
