package com.ptit.exam.business.impl;

import com.ptit.exam.business.QuestionService;
import com.ptit.exam.persistence.dao.QuestionDAO;
import com.ptit.exam.persistence.entity.Exam;
import com.ptit.exam.persistence.entity.Question;
import com.ptit.exam.util.Constants;
import com.ptit.exam.util.NumberManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
    public List<Question> findBySubjectIdAndLevelAndChapter(String subjectCode, int chapter, int level) {
        return questionDAO.findBySubjectCodeAndChapterAndLevel(subjectCode, chapter, level);
    }

    @Override
    public List<Question> findBySubjectIdAndLevel(String subjectCode, int difficult) {
        return questionDAO.findBySubjectCodeAndLevel(subjectCode, difficult);
    }

    @Override
    public List<Question> findBySubjectCode(String subjectCode) {
        return questionDAO.findBySubjectCode(subjectCode);
    }

    @Override
    public List<Question> findByChapter(int value) {
        return questionDAO.findByChapter(value);
    }

    @Override
    public List<Question> findByLevel(int value) {
        return questionDAO.findByLevel(value);
    }

    @Override
    public List<Question> loadRandomExamQuestionList(Exam exam) {
        List<Question> listQuestionEasy = findBySubjectIdAndLevel(exam.getSubjectCode(), Constants.EASY);
        List<Question> listQuestionMedium = findBySubjectIdAndLevel(exam.getSubjectCode(), Constants.MEDIUM);
        List<Question> listQuestionHard = findBySubjectIdAndLevel(exam.getSubjectCode(), Constants.HARD);

        List<Integer> indexEasyRandom = NumberManager.getListRandomNumber(exam.getTotalEasyQuestion(), listQuestionEasy.size());
        List<Integer> indexMediumRandom = NumberManager.getListRandomNumber(exam.getTotalMediumQuestion(), listQuestionMedium.size());
        List<Integer> indexHardRandom = NumberManager.getListRandomNumber(exam.getTotalHardQuestion(), listQuestionHard.size());

        List<Question> listQuestionSelected = new ArrayList<Question>();
        for (Integer i : indexEasyRandom) {
            listQuestionSelected.add(listQuestionEasy.get(i));
        }

        for (Integer i : indexMediumRandom) {
            listQuestionSelected.add(listQuestionMedium.get(i));
        }

        for (Integer i : indexHardRandom) {
            listQuestionSelected.add(listQuestionHard.get(i));
        }

        return listQuestionSelected;
    }

    @Override
    public List<Question> findBySubjectName(String subjectName) {
        return questionDAO.findBySubjectName(subjectName);
    }
}
