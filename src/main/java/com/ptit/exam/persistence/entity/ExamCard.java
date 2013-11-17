package com.ptit.exam.persistence.entity;

import javax.persistence.*;

/**
 * User: thuongntt
 * Date: 10/18/13
 * Time: 10:54 AM
 */
@Entity
@Table(name = "exam_card")
public class ExamCard {

    public static String RESULT_ID = "id";
    public static String RESULT_SUBJECT_ID = "subjectId";
    public static String RESULT_STUDENT_ID = "studentId";
    public static String RESULT_SCORE = "score";
    public static String RESULT_MAX_SCORE = "maxScore";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "score")
    private Long score;

    @Column(name = "max_score")
    private Long maxScore;

    public ExamCard(Subject subject, Student student) {
        this.subjectId = subject.getId();
        this.studentId = student.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Long getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Long maxScore) {
        this.maxScore = maxScore;
    }
}
