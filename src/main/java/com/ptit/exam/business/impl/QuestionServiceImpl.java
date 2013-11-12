package com.ptit.exam.business.impl;

import com.ptit.exam.business.QuestionService;
import com.ptit.exam.persistence.dao.QuestionDAO;
import com.ptit.exam.persistence.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: Anhnt
 * Date: 8/25/13
 * Time: 12:28 AM
 */

@Component("questionService")
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionDAO questionDAO;

    @Override
    public Question findById(Long id) {
        return questionDAO.findOne(id);
    }

    @Override
    public Question save(Question question) {
        return questionDAO.saveAndFlush(question);
    }

    @Override
    public void deleteById(Long id) {
        questionDAO.delete(id);
    }

    @Override
    public void delete(Question question) {
        questionDAO.delete(question);
    }

    @Override
    public List<Question> getAll() {
        return questionDAO.findAll();
    }

    @Override
    public List<Question> findBySubjectIdAndLevelAndChapter(Long subjectId, int chapter, int level) {
        return questionDAO.findBySubjectIdAndChapterAndLevel(subjectId, chapter, level);
    }


}
