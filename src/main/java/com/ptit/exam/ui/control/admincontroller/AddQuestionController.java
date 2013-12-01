package com.ptit.exam.ui.control.admincontroller;

import com.ptit.exam.business.AnswerService;
import com.ptit.exam.business.QuestionService;
import com.ptit.exam.persistence.entity.Answer;
import com.ptit.exam.persistence.entity.Question;
import com.ptit.exam.ui.view.admin.MainAdminGUI;
import com.ptit.exam.ui.view.admin.NewQuestionGUI;
import com.ptit.exam.util.Constants;
import com.ptit.exam.util.FileChooserManager;
import com.ptit.exam.util.GlobalValues;
import com.ptit.exam.util.MessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * User: thuongntt
 * Date: 11/13/13
 * Time: 10:28 PM
 */

@Component
public class AddQuestionController {

    @Autowired
    MainAdminController mainAdminController;

    @Autowired
    MainAdminGUI mainAdminGUI;

    @Autowired
    QuestionBankController questionBankController;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    private NewQuestionGUI newQuestionGUI;
    private Question question;
    private List<Answer> answerList;

    public void doSetUp(Question question, List<Answer> answerList) {
        this.question = question;
        this.answerList = answerList;

        newQuestionGUI = mainAdminGUI.getNewQuestionGUI();
        newQuestionGUI.getCbLevel().setModel(new DefaultComboBoxModel(Constants.level));

        setUpActionListener();
    }

    private void setUpActionListener() {
        if (GlobalValues.NEW_QUESTION_ADD_ACTION) {
            newQuestionGUI.getBtnSave().addActionListener(actionListener);
            newQuestionGUI.getBtnCancel().addActionListener(actionListener);
            newQuestionGUI.getBtnBrowser().addActionListener(actionListener);
        }
        GlobalValues.NEW_QUESTION_ADD_ACTION = false;
    }

    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == newQuestionGUI.getBtnSave()) {
                doSaveQuestion();
            }
            if (e.getSource() == newQuestionGUI.getBtnCancel()) {
                doCancelAddQuestion();
            }
            if (e.getSource() == newQuestionGUI.getBtnBrowser()) {
                doLoadLocation();
            }
        }
    };

    private void doCancelAddQuestion() {
        questionBankController.doSetUp();
        mainAdminController.doShowQuestionBankCard();
    }

    private void doSaveQuestion() {
        if (newQuestionGUI.invalidForm()) {
            MessageManager.show("Thông tin về câu hỏi không hợp lệ.");
        } else {
            question = newQuestionGUI.getQuestionInfo(question);
            question = questionService.save(question);

            answerService.save(newQuestionGUI.getAnswer1(question, answerList.get(0)));
            answerService.save(newQuestionGUI.getAnswer2(question, answerList.get(1)));
            answerService.save(newQuestionGUI.getAnswer3(question, answerList.get(2)));
            answerService.save(newQuestionGUI.getAnswer4(question, answerList.get(3)));
            MessageManager.show("Đã lưu thành công.");

            questionBankController.doSetUp();
            mainAdminController.doShowQuestionBankCard();
        }
    }

    private void doLoadLocation() {
        String path = FileChooserManager.getFile(newQuestionGUI);
        newQuestionGUI.getTxtUrlImage().setText(path);
    }
}
