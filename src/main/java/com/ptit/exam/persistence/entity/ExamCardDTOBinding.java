package com.ptit.exam.persistence.entity;

/**
 * User: anhnt
 * Date: 11/19/13
 * Time: 4:32 PM
 */
public class ExamCardDTOBinding
{
    public static final String EXAM_ID = "examId";
    public static final String STUDENT_CODE = "studentCode";
    public static final String STUDENT_NAME = "studentName";
    public static final String FACULTY = "faculty";
    public static final String CLASS_ROOM = "classRoom";
    public static final String NAME_SUBJECT = "nameSubject";
    public static final String UNIT_OF_STUDY = "unitOfStudy";
    public static final String CAN_DO_EXAM = "canDoExam";

    private Long examId;
    private String studentCode;
    private String studentName;
    private String faculty;
    private String classRoom;
    private String nameSubject;
    private int unitOfStudy;
    private boolean canDoExam;

    public Long getExamId()
    {
        return examId;
    }

    public void setExamId(Long examId)
    {
        this.examId = examId;
    }

    public String getStudentCode()
    {
        return studentCode;
    }

    public void setStudentCode(String studentCode)
    {
        this.studentCode = studentCode;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public String getFaculty()
    {
        return faculty;
    }

    public void setFaculty(String faculty)
    {
        this.faculty = faculty;
    }

    public String getClassRoom()
    {
        return classRoom;
    }

    public void setClassRoom(String classRoom)
    {
        this.classRoom = classRoom;
    }

    public String getNameSubject()
    {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject)
    {
        this.nameSubject = nameSubject;
    }

    public int getUnitOfStudy()
    {
        return unitOfStudy;
    }

    public void setUnitOfStudy(int unitOfStudy)
    {
        this.unitOfStudy = unitOfStudy;
    }

    public boolean isCanDoExam()
    {
        return canDoExam;
    }

    public void setCanDoExam(boolean canDoExam)
    {
        this.canDoExam = canDoExam;
    }
}
