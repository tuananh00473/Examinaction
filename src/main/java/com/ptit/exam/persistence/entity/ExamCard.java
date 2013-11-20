package com.ptit.exam.persistence.entity;

import javax.persistence.*;

/**
 * User: thuongntt
 * Date: 10/18/13
 * Time: 10:54 AM
 */
@Entity
@Table(name = "exam_card")
public class ExamCard
{
    public static String EXAM_CARD_ID = "id";
    public static String EXAM_CARD_SUBJECT_ID = "subjectId";
    public static String EXAM_CARD_STUDENT_ID = "studentId";
    public static String EXAM_CARD_ACTIVE = "canDoExam";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "can_do_exam")
    private boolean canDoExam;

    public ExamCard()
    {
    }

    public ExamCard(Long subjectId, Long studentId)
    {
        this.subjectId = subjectId;
        this.studentId = studentId;
        this.canDoExam = true;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getSubjectId()
    {
        return subjectId;
    }

    public void setSubjectId(Long subjectId)
    {
        this.subjectId = subjectId;
    }

    public Long getStudentId()
    {
        return studentId;
    }

    public void setStudentId(Long studentId)
    {
        this.studentId = studentId;
    }

    public boolean isCanDoExam()
    {
        return canDoExam;
    }

    public void setCanDoExam(boolean canDoExam)
    {
        this.canDoExam = canDoExam;
    }

    @Override
    public boolean equals(Object obj)
    {
        ExamCard examCard = (ExamCard) obj;
        if (subjectId.equals(examCard.getSubjectId())
                && studentId.equals(examCard.getStudentId())
                && (canDoExam && examCard.isCanDoExam()))
        {
            return true;
        }
        return false;
    }
}
