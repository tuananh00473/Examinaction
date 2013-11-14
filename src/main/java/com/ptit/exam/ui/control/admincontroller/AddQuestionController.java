package com.ptit.exam.ui.control.admincontroller;

import com.ptit.exam.business.AnswerService;
import com.ptit.exam.business.QuestionService;
import com.ptit.exam.persistence.entity.Question;
import com.ptit.exam.ui.view.admin.MainAdminGUI;
import com.ptit.exam.ui.view.admin.NewQuestionGUI;
import com.ptit.exam.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;

/**
 * User: thuongntt
 * Date: 11/13/13
 * Time: 10:28 PM
 */

@Component
public class AddQuestionController
{

    @Autowired
    MainAdminController mainAdminController;

    @Autowired
    QuestionBankController questionBankController;

    @Autowired
    MainAdminGUI mainAdminGUI;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    private NewQuestionGUI newQuestionGUI;

    public void doSetUp()
    {
        newQuestionGUI = mainAdminGUI.getNewQuestionGUI();

        newQuestionGUI.getCbLevel().setModel(new DefaultComboBoxModel(Constants.level));

        newQuestionGUI.getBtnSave().addActionListener(actionListener);
        newQuestionGUI.getBtnCancel().addActionListener(actionListener);
        newQuestionGUI.getBtnBrowser().addActionListener(actionListener);

    }

    private ActionListener actionListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == newQuestionGUI.getBtnSave())
            {
                if (newQuestionGUI.invalidForm())
                {
                    showMessage("Dữ liệu không được chấp nhận.");
                }
                else
                {
                    Question questionInput = newQuestionGUI.getQuestionInfo();
                    Question question = questionService.save(questionInput);
                    answerService.save(newQuestionGUI.getAnswer1(question));
                    answerService.save(newQuestionGUI.getAnswer2(question));
                    answerService.save(newQuestionGUI.getAnswer3(question));
                    answerService.save(newQuestionGUI.getAnswer4(question));
                    showMessage("Dữ liệu đã được lưu trữ.");

                    questionBankController.doSetUp();
                    mainAdminController.doShowQuestionBankCard();
                }
            }
            if (e.getSource() == newQuestionGUI.getBtnCancel())
            {
                questionBankController.doSetUp();
                mainAdminController.doShowQuestionBankCard();
            }
            if (e.getSource() == newQuestionGUI.getBtnBrowser())
            {
                doLoadLocation();
            }
        }
    };

    private void doLoadLocation()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnVal = chooser.showOpenDialog(newQuestionGUI);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            String path = chooser.getSelectedFile().getAbsolutePath();
            path = path.replaceAll(Matcher.quoteReplacement("\\"), "/");
            newQuestionGUI.getTxtUrlImage().setText(path);
        }
    }

    public void showMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }
}