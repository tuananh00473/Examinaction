package com.ptit.exam.ui.control.admincontroller;

import com.ptit.exam.ui.view.admin.MainAdminGUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User: thuongntt
 * Date: 9/22/13
 * Time: 8:45 PM
 */

@Component
public class MainAdminController
{

    public static final String MANAGEMENT_EXAM_CARD = "managermentExamGUI";
    public static final String MANAGEMENT_STUDENT_CARD = "managementStudentGUI";
    public static final String MANAGEMENT_SUBJECT_CARD = "managementSubjectGUI";
    public static final String SCHEDULE_CARD = "scheduleGUI";
    public static final String EXPORT_EXAM_CARD = "exportExaminationGUI";
    public static final String QUESTION_BANK_CARD = "questionBankGUI";
    private static final String NEW_QUESTION_CARD = "newQuestionGUI";

    @Autowired
    MainAdminGUI mainAdminGUI;

    public void doShowQuestionBankCard()
    {
        showCard(QUESTION_BANK_CARD);
    }

    public void doShowScheduleCard()
    {
        showCard(SCHEDULE_CARD);
    }

    public void doShowNewQuestionCard()
    {
        showCard(NEW_QUESTION_CARD);
    }

    public void doShowExportExamCard()
    {

        showCard(EXPORT_EXAM_CARD);
    }

    public void doShowManagementExamGUI()
    {
        showCard(MANAGEMENT_EXAM_CARD);
    }

    public void doShowManagementSubjectGUI()
    {
        showCard(MANAGEMENT_SUBJECT_CARD);
    }

    public void doShowManagementStudentGUI()
    {
        showCard(MANAGEMENT_STUDENT_CARD);
    }

    public void showCard(String nameCard)
    {
        mainAdminGUI.getCardLayout().show(mainAdminGUI.getAdminCardPanel(), nameCard);
    }
}
