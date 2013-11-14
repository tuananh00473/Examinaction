package com.ptit.exam.persistence.entity;

import javax.persistence.*;

/**
 * User: Administrator
 * Date: 8/22/13
 * Time: 10:31 PM
 */

@Entity
@Table(name = "answers")
public class Answer {

    public static String ANSWER_CORRECT = "correct";
    public static String ANSWER_CONTENT = "content";

    //  ============= Attribute ==============
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "answer_correct")
    private boolean correct;

    @Column(name = "answer_content")
    private String content;

    @Column(name = "question_id")
    private Long questionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    @Override
    public boolean equals(Object obj) {
        Answer answer = (Answer) obj;
        if (questionId == answer.getQuestionId()
                && content.equals(answer.getContent())
                && (correct && answer.isCorrect()))
            return true;
        return false;
    }
}
