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
public class MainAdminController {

    public static final String MANAGEMENT_EXAM_CARD = "managementExamGUI";
    public static final String MANAGEMENT_STUDENT_CARD = "managementStudentGUI";
    public static final String MANAGEMENT_SUBJECT_CARD = "managementSubjectGUI";
    public static final String NEW_EXAM_CARD = "newExaminationGUI";
    public static final String EXPORT_EXAM_CARD = "exportExamGUI";
    public static final String QUESTION_BANK_CARD = "questionBankGUI";
    private static final String NEW_QUESTION_CARD = "newQuestionGUI";
    private static final String NEW_SUBJECT_CARD = "newSubjectGUI";
    private static final String NEW_STUDENT_CARD = "newStudentGUI";
    private static final String INTRODUCE_ADMIN_CARD = "introduceAdminGUI";

    @Autowired
    MainAdminGUI mainAdminGUI;

    @Autowired
    AddSubjectController addSubjectController;

    @Autowired
    AddStudentController addStudentController;

    @Autowired
    AddQuestionController addQuestionController;

    @Autowired
    NewExamController newExamController;

    @Autowired
    QuestionBankController questionBankController;

    @Autowired
    ManagementExamController managementExamController;

    @Autowired
    ManagementStudentController managementStudentController;

    @Autowired
    ManagementSubjectController managementSubjectController;

    public void doShowQuestionBankCard() {
        showCard(QUESTION_BANK_CARD);
    }

    public void doShowNewQuestionCard() {
        showCard(NEW_QUESTION_CARD);
    }

    public void doShowNewExamCard() {
        showCard(NEW_EXAM_CARD);
    }

    public void doShowExportExamCard() {
        showCard(EXPORT_EXAM_CARD);
    }

    public void doShowManagementExamGUI() {
        showCard(MANAGEMENT_EXAM_CARD);
    }

    public void doShowManagementSubjectGUI() {
        showCard(MANAGEMENT_SUBJECT_CARD);
    }

    public void doShowManagementStudentGUI() {
        showCard(MANAGEMENT_STUDENT_CARD);
    }

    public void doShowNewSubjectCard() {
        showCard(NEW_SUBJECT_CARD);
    }

    public void doShowNewStudentCard() {
        showCard(NEW_STUDENT_CARD);
    }

    public void doShowIntroduceAdminCard() {
        showCard(INTRODUCE_ADMIN_CARD);
    }

    public void showCard(String nameCard) {
        mainAdminGUI.getCardLayout().show(mainAdminGUI.getAdminCardPanel(), nameCard);
    }
}
