package com.ptit.exam.ui.control.usercontroller;

import com.ptit.exam.business.ExamCardService;
import com.ptit.exam.business.ExamService;
import com.ptit.exam.business.ResultService;
import com.ptit.exam.business.SubjectService;
import com.ptit.exam.persistence.entity.Exam;
import com.ptit.exam.persistence.entity.ExamCard;
import com.ptit.exam.persistence.entity.Result;
import com.ptit.exam.persistence.entity.Subject;
import com.ptit.exam.ui.view.student.MainStudentGUI;
import com.ptit.exam.ui.view.student.SettingExamGUI;
import com.ptit.exam.util.GlobalValues;
import com.ptit.exam.util.MessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

/**
 * User: thuongntt
 * Date: 10/8/13
 * Time: 11:46 AM
 */
@Component
public class SettingExamController
{
    @Autowired
    MainStudentGUI mainStudentGUI;

    @Autowired
    SubjectService subjectService;

    @Autowired
    ExamService examService;

    @Autowired
    MainStudentController mainStudentController;

    @Autowired
    ExamController examController;
    @Autowired
    ExamCardService examCardService;
    @Autowired
    ResultService resultService;

    private List<Subject> subjectList;
    private JComboBox cbSubjectExam;
    private SettingExamGUI settingExamGUI;

    public void doSetUp()
    {
        setUpViewSetting();
        setUpActionListener();
    }

    private void setUpActionListener()
    {
        if (GlobalValues.SETTING_EXAM_ADD_ACTION)
        {
            settingExamGUI.getBtnStart().addActionListener(actionListener);
            cbSubjectExam.addItemListener(itemListener);
        }
        GlobalValues.SETTING_EXAM_ADD_ACTION = false;
    }

    private ItemListener itemListener = new ItemListener()
    {
        @Override
        public void itemStateChanged(ItemEvent e)
        {
            GlobalValues.exam = null;
            int indexSelected = cbSubjectExam.getSelectedIndex();
            if (0 != indexSelected)
            {
                Subject subject = subjectList.get(indexSelected - 1);
                GlobalValues.subject = subject;
                List<Exam> examList = examService.findBySubjectCode(subject.getSubjectCode());
                if (0 == examList.size())
                {
                    settingExamGUI.setUpExamInfo(new Exam());
                }
                for (Exam exam : examList)
                {
                    if (exam.isActive())
                    {
                        settingExamGUI.setUpExamInfo(exam);
                        GlobalValues.exam = exam;
                    }
                }
            }
            else
            {
                settingExamGUI.setUpExamInfo(new Exam());
            }
        }
    };

    private ActionListener actionListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == settingExamGUI.getBtnStart())
            {
                if (null == GlobalValues.exam)
                {
                    MessageManager.show("Đề thi chưa được kích hoạt.");
                }
                else
                {
                    ExamCard examCard = examCardService.findByStudentIdAndSubjectId(GlobalValues.student.getId(), GlobalValues.subject.getId());
                    Result result = resultService.findByExamIdAndStudentId(GlobalValues.exam.getId(), GlobalValues.student.getId());
                    if (null != result)
                    {
                        MessageManager.show("Bạn đã thực hiện thi môn này rồi.");
                        return;
                    }
                    if (!examCard.isCanDoExam())
                    {
                        MessageManager.show("Bạn không được phép dự thi môn " + GlobalValues.subject.getSubjectName());
                        return;
                    }
                    examController.doSetUp();
                    mainStudentController.doShowExamCard();
                }
            }
        }
    };

    private void setUpViewSetting()
    {
        settingExamGUI = mainStudentGUI.getSettingExamGUI();
        cbSubjectExam = settingExamGUI.getCbSubjectExam();
        cbSubjectExam.addItem("");
        settingExamGUI.setInfoAboutStudentToField(GlobalValues.student);
        subjectList = subjectService.findByStudentId(GlobalValues.student.getId());
        for (Subject subject : subjectList)
        {
            cbSubjectExam.addItem(subject.getSubjectName());
        }
    }
}
