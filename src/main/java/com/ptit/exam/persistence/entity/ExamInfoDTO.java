package com.ptit.exam.persistence.entity;

/**
 * User: anhnt
 * Date: 11/19/13
 * Time: 4:32 PM
 */
public class ExamInfoDTO
{
    public static final String NAME_SUBJECT = "nameSubject";
    public static final String EXAM_CODE = "examCode";
    public static final String EXAM_NAME = "examName";
    public static final String TOTAL_TIME = "totalTime";
    public static final String DEADLINE_TO_EXAM = "deadLineToExam";

    private String nameSubject;
    private String examCode;
    private String examName;
    private String totalTime;
    private String deadLineToExam;

    public String getNameSubject()
    {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject)
    {
        this.nameSubject = nameSubject;
    }

    public String getExamCode()
    {
        return examCode;
    }

    public void setExamCode(String examCode)
    {
        this.examCode = examCode;
    }

    public String getExamName()
    {
        return examName;
    }

    public void setExamName(String examName)
    {
        this.examName = examName;
    }

    public String getTotalTime()
    {
        return totalTime;
    }

    public void setTotalTime(String totalTime)
    {
        this.totalTime = totalTime;
    }

    public String getDeadLineToExam()
    {
        return deadLineToExam;
    }

    public void setDeadLineToExam(String deadLineToExam)
    {
        this.deadLineToExam = deadLineToExam;
    }
}
