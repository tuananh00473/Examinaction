package com.ptit.exam.business;

import com.ptit.exam.persistence.entity.Question;

import java.util.List;

/**
 * User: Anhnt
 * Date: 8/25/13
 * Time: 12:27 AM
 */
public interface QuestionService
{
    public Question findById(Long id);

    public Question save(Question question);

    public void deleteById(Long id);

    public void delete(Question question);

    public List<Question> getAll();

    public List<Question> findBySubjectIdAndLevelAndChapter(String subjectCode, int difficult, int chapter);

}
