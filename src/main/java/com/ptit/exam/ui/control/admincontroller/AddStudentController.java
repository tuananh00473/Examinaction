package com.ptit.exam.ui.control.admincontroller;

import com.ptit.exam.business.StudentService;
import com.ptit.exam.persistence.entity.Student;
import com.ptit.exam.ui.view.admin.MainAdminGUI;
import com.ptit.exam.ui.view.admin.NewStudentGUI;
import com.ptit.exam.util.ComboboxManager;
import com.ptit.exam.util.Constants;
import com.ptit.exam.util.MessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * User: anhnt
 * Date: 11/15/13
 * Time: 4:57 PM
 */

@Component
public class AddStudentController
{
    @Autowired
    MainAdminController mainAdminController;

    @Autowired
    MainAdminGUI mainAdminGUI;

    @Autowired
    StudentService studentService;

    @Autowired
    ManagementStudentController managementStudentController;

    private NewStudentGUI newStudentGUI;
    private Student student;

    public void doSetUp(Student student)
    {
        this.student = student;

        newStudentGUI = mainAdminGUI.getNewStudentGUI();

        newStudentGUI.getComboBoxFaculty().setModel(new DefaultComboBoxModel(Constants.facultyList));
        newStudentGUI.getComboBoxTrainingSystem().setModel(new DefaultComboBoxModel(Constants.trainingTypes));
        newStudentGUI.getComboBoxCourse().setModel(new DefaultComboBoxModel(Constants.courseList));
        ComboboxManager.setValue(newStudentGUI.getComboBoxDay(), 1, 31);
        ComboboxManager.setValue(newStudentGUI.getComboBoxMonth(), 1, 12);
        ComboboxManager.setValue(newStudentGUI.getComboBoxYear(), 1990, 2013);


        newStudentGUI.getBtnSave().addActionListener(actionListener);
        newStudentGUI.getBtnCancel().addActionListener(actionListener);

        newStudentGUI.getComboBoxMonth().addItemListener(itemListener);
        newStudentGUI.getComboBoxYear().addItemListener(itemListener);
    }

    private ItemListener itemListener = new ItemListener()
    {
        @Override
        public void itemStateChanged(ItemEvent e)
        {
            if (e.getSource() == newStudentGUI.getComboBoxMonth())
            {
                setListDayOfMonth(e);
            }
            if (e.getSource() == newStudentGUI.getComboBoxYear())
            {
                setListDayOfYear(e);
            }
        }
    };

    private void setListDayOfYear(ItemEvent e)
    {
        if (values(e.getItem().toString()) % 4 == 0)
        {
            if (compareOneInList(newStudentGUI.getComboBoxMonth().getSelectedItem().toString(), "2"))
            {
                ComboboxManager.setValue(newStudentGUI.getComboBoxDay(), 1, 28);
            }
            else
            {
                ComboboxManager.setValue(newStudentGUI.getComboBoxDay(), 1, 29);
            }
        }
    }

    private void setListDayOfMonth(ItemEvent e)
    {
        String dayBackUp = newStudentGUI.getComboBoxDay().getSelectedItem().toString();

        if (compareOneInList(e.getItem().toString(), "1", "3", "5", "7", "8", "10", "12"))
        {
            ComboboxManager.setValue(newStudentGUI.getComboBoxDay(), 1, 31);
        }
        if (compareOneInList(e.getItem().toString(), "4", "6", "9", "11"))
        {
            ComboboxManager.setValue(newStudentGUI.getComboBoxDay(), 1, 30);
        }
        if (compareOneInList(e.getItem().toString(), "2"))
        {
            if (values(newStudentGUI.getComboBoxYear().getSelectedItem().toString()) % 4 == 0)
            {
                ComboboxManager.setValue(newStudentGUI.getComboBoxDay(), 1, 28);
            }
            else
            {
                ComboboxManager.setValue(newStudentGUI.getComboBoxDay(), 1, 29);
            }
        }

        newStudentGUI.getComboBoxDay().setSelectedItem(dayBackUp);
    }

    private ActionListener actionListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == newStudentGUI.getBtnSave())
            {
                if (newStudentGUI.invalidForm())
                {
                    MessageManager.show("Thông tin về sinh viên không hợp lệ.");
                }
                else
                {
                    student = newStudentGUI.getSubjectInfo(student);
                    studentService.save(student);

                    MessageManager.show("Đã lưu thành công.");

                    showManagementStudentGUI();
                }
            }
            if (e.getSource() == newStudentGUI.getBtnCancel())
            {
                showManagementStudentGUI();
            }
        }
    };

    private void showManagementStudentGUI()
    {
        managementStudentController.doSetUp();
        mainAdminController.doShowManagementStudentGUI();
    }

    public boolean compareOneInList(String value, String... items)
    {
        for (String item : items)
        {
            if (value.equals(item))
            {
                return true;
            }
        }
        return false;
    }

    private int values(String text)
    {
        return Integer.parseInt(text);
    }
}
