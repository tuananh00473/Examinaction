package com.ptit.exam.persistence.entity;

import java.io.Serializable;

/**
 * User: Admin
 * Date: 11/24/13
 * Time: 2:45 PM
 */
public class ResultDTOBinding implements Serializable {


    public static final String EXAM_NAME = "examName";
    public static final String STUDENT_CODE = "studentCode";
    public static final String STUDENT_FIRST_NAME = "studentFirstName";
    public static final String STUDENT_LAST_NAME = "studentLastName";
    public static final String FACULTY = "faculty";
    public static final String CLASS_ROOM = "classRoom";
    public static final String NAME_SUBJECT = "subjectName";
    public static final String SOCRE = "score";
    public static final String MAX_SCORE = "maxScore";

    private String studentFirstName;
    private String studentLastName;
    private String studentCode;
    private String faculty;
    private String classRoom;
    private String subjectName;
    private String examName;
    private int score;
    private int maxScore;

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }
}
