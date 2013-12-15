package com.ptit.exam.persistence.entity;

import javax.persistence.*;

/**
 * User: thuongntt
 * Date: 10/18/13
 * Time: 10:35 AM
 */
@Entity
@Table(name = "exams")
public class Exam {


    public static String EXAM_NAME = "examName";
    public static String EXAM_CODE = "examCode";
    public static String EXAM_SUBJECT_CODE = "subjectCode";
    public static String EXAM_TOTAL_TIME = "totalTime";
    public static String EXAM_TOTAL_EASY_QUESTION = "totalEasyQuestion";
    public static String EXAM_TOTAL_MEDIUM_QUESTION = "totalMediumQuestion";
    public static String EXAM_TOTAL_HARD_QUESTION = "totalHardQuestion";
    public static String EXAM_IS_ACTIVE = "active";


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "subject_code")
    private String subjectCode;

    @Column(name = "exam_code")
    private String examCode;

    @Column(name = "exam_name")
    private String examName;

    @Column(name = "total_time")
    private Long totalTime;

    @Column(name = "total_hard_question")
    private int totalHardQuestion;

    @Column(name = "total_medium_question")
    private int totalMediumQuestion;

    @Column(name = "total_easy_question")
    private int totalEasyQuestion;

    @Column(name = "active")
    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getExamCode() {
        return examCode;
    }

    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Long totalTime) {
        this.totalTime = totalTime;
    }

    public int getTotalHardQuestion() {
        return totalHardQuestion;
    }

    public void setTotalHardQuestion(int totalHardQuestion) {
        this.totalHardQuestion = totalHardQuestion;
    }

    public int getTotalMediumQuestion() {
        return totalMediumQuestion;
    }

    public void setTotalMediumQuestion(int totalMediumQuestion) {
        this.totalMediumQuestion = totalMediumQuestion;
    }

    public int getTotalEasyQuestion() {
        return totalEasyQuestion;
    }

    public void setTotalEasyQuestion(int totalEasyQuestion) {
        this.totalEasyQuestion = totalEasyQuestion;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getTotalQuestion() {
        return totalEasyQuestion + totalMediumQuestion + totalHardQuestion;
    }

    @Override
    public String toString() {
        return examName;
    }
}


