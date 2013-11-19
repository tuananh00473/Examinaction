package com.ptit.exam.util;

import com.ptit.exam.persistence.entity.Exam;
import com.ptit.exam.persistence.entity.ExamCard;
import com.ptit.exam.persistence.entity.Student;
import com.ptit.exam.persistence.entity.Subject;

/**
 * User: anhnt
 * Date: 11/18/13
 * Time: 3:59 PM
 */
public class GlobalValues
{
    public static Student student;
    public static Subject subject;
    public static Exam exam;
    public static ExamCard examCard;

    public static boolean LOGIN_ADD_ACTION = true;

    public static boolean NEW_QUESTION_ADD_ACTION = true;
    public static boolean NEW_STUDENT_ADD_ACTION = true;
    public static boolean NEW_SUBJECT_ADD_ACTION = true;
    public static boolean NEW_EXAM_ADD_ACTION = true;

    public static boolean MANAGEMENT_STUDENT_ADD_ACTION_TAB1 = true;
    public static boolean MANAGEMENT_STUDENT_ADD_ACTION_TAB2 = true;
    public static boolean MANAGEMENT_EXAM_ADD_ACTION = true;
    public static boolean MANAGEMENT_QUESTION_ADD_ACTION = true;
    public static boolean MANAGEMENT_SUBJECT_ADD_ACTION_TAB1 = true;
    public static boolean MANAGEMENT_SUBJECT_ADD_ACTION_TAB2 = true;

    public static boolean SETTING_EXAM_ADD_ACTION = true;
}
