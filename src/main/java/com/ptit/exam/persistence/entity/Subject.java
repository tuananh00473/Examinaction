package com.ptit.exam.persistence.entity;

import javax.persistence.*;

/**
 * User: thuongntt
 * Date: 9/24/13
 * Time: 8:39 PM
 */
@Entity
@Table(name = "subjects")
public class Subject {

    public static String SUBJECT_CODE = "subjectCode";
    public static String SUBJECT_NAME = "subjectName";
    public static String SUBJECT_FACULTY = "faculty";
    public static String SUBJECT_UNIT_STUDY = "unitOfStudy";
    public static String SUBJECT_DESCRIPTION = "subjectDesc";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "subject_code")
    private String subjectCode;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "unit_study")
    private Long unitOfStudy;

    @Column(name = "subject_description")
    private String subjectDescription;

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

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Long getUnitOfStudy() {
        return unitOfStudy;
    }

    public void setUnitOfStudy(Long unitOfStudy) {
        this.unitOfStudy = unitOfStudy;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }

    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription = subjectDescription;
    }
}
