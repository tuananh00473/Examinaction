package com.ptit.exam.ui.control.usercontroller;

import com.ptit.exam.ui.control.ResultController;
import com.ptit.exam.ui.control.SettingExamController;
import com.ptit.exam.ui.view.student.MainStudentGUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User: thuongntt
 * Date: 10/8/13
 * Time: 11:13 AM
 */
@Component
public class MainStudentController {

    @Autowired
    MainStudentGUI mainStudentGUI;

    @Autowired
    SettingExamController settingExamController;

    @Autowired
    ResultController resultController;

    public static final String EXAM_CARD = "examGUI";
    public static final String RESULT_CARD = "resultGUI";
    public static final String SETTING_EXAM_CARD = "settingExamGUI";


    public void showCard(String nameCard) {
        mainStudentGUI.getCardLayout().show(mainStudentGUI.getStudentCardPanel(), nameCard);
    }

    public void doShowSettingExamCard() {
//        settingExamController.doSetUp();   // todo
        showCard(SETTING_EXAM_CARD);
    }

    public void doShowExamCard() {
        showCard(EXAM_CARD);
    }

    public void doShowResultCard() {
//        resultController.setUpResultGUI();    // todo
        showCard(RESULT_CARD);
    }
}
