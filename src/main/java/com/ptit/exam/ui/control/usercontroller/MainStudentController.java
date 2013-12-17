package com.ptit.exam.ui.control.usercontroller;

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
    public static final String EXAM_CARD = "examGUI";
    public static final String RESULT_CARD = "resultGUI";
    public static final String SETTING_EXAM_CARD = "settingExamGUI";
    private static final String INTRODUCE_CARD = "introduceStudentGUI";

    @Autowired
    MainStudentGUI mainStudentGUI;


    public void showCard(String nameCard) {
        mainStudentGUI.getCardLayout().show(mainStudentGUI.getStudentCardPanel(), nameCard);
    }

    public void doShowSettingExamCard() {
        showCard(SETTING_EXAM_CARD);
    }

    public void doShowExamCard() {
        showCard(EXAM_CARD);
    }

    public void doShowResultCard() {
        showCard(RESULT_CARD);
    }

    public void doShowIntroduceCard() {
        showCard(INTRODUCE_CARD);
    }
}
