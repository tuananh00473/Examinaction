package com.ptit.exam.ui.control.admincontroller;

import com.ptit.exam.business.SubjectService;
import com.ptit.exam.persistence.entity.Subject;
import com.ptit.exam.ui.view.admin.MainAdminGUI;
import com.ptit.exam.ui.view.admin.NewSubjectGUI;
import com.ptit.exam.util.Constants;
import com.ptit.exam.util.GlobalValues;
import com.ptit.exam.util.MessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: anhnt
 * Date: 11/15/13
 * Time: 1:49 PM
 */

@Component
public class AddSubjectController
{
    @Autowired
    MainAdminController mainAdminController;

    @Autowired
    MainAdminGUI mainAdminGUI;

    @Autowired
    SubjectService subjectService;

    @Autowired
    ManagementSubjectController managementSubjectController;

    private NewSubjectGUI newSubjectGUI;
    private Subject subject;

    public void doSetUp(Subject subject)
    {
        this.subject = subject;

        newSubjectGUI = mainAdminGUI.getNewSubjectGUI();

        newSubjectGUI.getComboBoxFaculty().setModel(new DefaultComboBoxModel(Constants.facultyList));
        newSubjectGUI.getComboBoxUnitStudy().setModel(new DefaultComboBoxModel(Constants.unitOfStudy));

        setUpActionListener();
    }

    private void setUpActionListener()
    {
        if (GlobalValues.NEW_SUBJECT_ADD_ACTION)
        {
            newSubjectGUI.getBtnSave().addActionListener(actionListener);
            newSubjectGUI.getBtnCancel().addActionListener(actionListener);
        }
        GlobalValues.NEW_SUBJECT_ADD_ACTION = false;
    }

    private ActionListener actionListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == newSubjectGUI.getBtnSave())
            {
                if (newSubjectGUI.invalidForm())
                {
                    MessageManager.show("Thông tin về môn học không hợp lệ.");
                }
                else
                {
                    subject = newSubjectGUI.getSubjectInfo(subject);
                    subjectService.save(subject);

                    MessageManager.show("Đã lưu thành công.");

                    managementSubjectController.doSetUp();
                    mainAdminController.doShowManagementSubjectGUI();
                }
            }
            if (e.getSource() == newSubjectGUI.getBtnCancel())
            {
                managementSubjectController.doSetUp();
                mainAdminController.doShowManagementSubjectGUI();
            }
        }
    };
}
