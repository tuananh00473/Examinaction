package com.ptit.exam.ui.control.usercontroller;

import com.ptit.exam.business.ExamCardService;
import com.ptit.exam.business.ExamService;
import com.ptit.exam.business.SubjectService;
import com.ptit.exam.business.common.TableBinding;
import com.ptit.exam.business.common.TextAreaEditor;
import com.ptit.exam.business.common.TextAreaRenderer;
import com.ptit.exam.persistence.entity.ExamCard;
import com.ptit.exam.persistence.entity.Student;
import com.ptit.exam.persistence.entity.Subject;
import com.ptit.exam.ui.view.student.MainStudentGUI;
import com.ptit.exam.ui.view.student.SettingExamGUI;
import com.ptit.exam.util.GlobalValues;
import com.ptit.exam.util.MessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    //
//    @Autowired
//    QuestionService questionService;
//
//    @Autowired
//    AnswerService answerService;
//
    @Autowired
    ExamCardService examCardService;

    private Student student;
    private List<Subject> subjectList;
    private JTable tableExamination;
    private JScrollPane scrollPaneExamination;

    private SettingExamGUI settingExamGUI;

    public void doSetUp()
    {
        setUpViewSetting();
        setUpActionListener();

//        settingExamGUI.getComboBoxSubject().addItemListener(new ItemListener()
//        {
//            @Override
//            public void itemStateChanged(ItemEvent e)
//            {
//                String subjectName = settingExamGUI.getComboBoxSubject().getSelectedItem().toString();
//                if (!"".equals(subjectName))
//                {
//                    List<Subject> subject = subjectService.findBySubjectName(subjectName);
//
//                    ExamInfoDTO examInfoDTO = new ExamInfoDTO();
//                    examInfoDTO.setNameSubject(subject.getSubjectName());
//
//                    Exam exam = examService.findBySubjectCode(subject.getSubjectCode());
//
//                    subject = subjectService.findByFacultyAndSubjectName(student.getFaculty(), subjectName);
//                    examCardList = examService.findBySubjectCode(subject.getSubjectCode());
//                    doBindingExamination(examCardList, tableExamination, scrollPaneExamination);
//                }
//            }
//        });

//        Set<String> stringSet = new HashSet<String>();
//        List<Subject> subjectList = subjectService.findByFaculty(student.getFaculty());
//        for (Subject subject : subjectList) {
//            stringSet.add(subject.getSubjectName());
//        }
//
//        for (String s : stringSet) {
//            mainStudentGUI.getSettingExamGUI().getComboBoxSubject().addItem(s.intern());
//        }
//        mainStudentGUI.getSettingExamGUI().getComboBoxSubject().setSelectedIndex(0);
//
//        mainStudentGUI.getSettingExamGUI().getComboBoxSubject().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (mainStudentGUI.getSettingExamGUI().getComboBoxSubject().isPopupVisible()) {
//
//                    subject = subjectService.findBySubjectName(mainStudentGUI.getSettingExamGUI().getComboBoxSubject().getSelectedItem().toString());
//
//                    setUpBindingExamination(subject);
//
//                }
//            }
//        });
//
//
//        stopEditting();
    }

    private void setUpActionListener()
    {
        if (GlobalValues.SETTING_EXAM_ADD_ACTION)
        {
            settingExamGUI.getBtnStart().addActionListener(actionListener);
        }
        GlobalValues.SETTING_EXAM_ADD_ACTION = false;
    }

    private ActionListener actionListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == settingExamGUI.getBtnStart())
            {
                int k = tableExamination.getSelectedRow();
                if (-1 == k)
                {
                    MessageManager.show("Hãy chọn một môn thi để có thể bắt đầu thi.");
                }
                else
                {
                    GlobalValues.subject = subjectList.get(k);
                    int sure = MessageManager.showConfirm("Bạn đã sẵn sàng chưa?");
                    if (0 == sure)
                    {
                        examController.doSetUp();
                        mainStudentController.doShowExamCard();
                    }
                }
            }
        }
    };

    private void setUpViewSetting()
    {
        settingExamGUI = mainStudentGUI.getSettingExamGUI();

        subjectList = new ArrayList<Subject>();
        tableExamination = settingExamGUI.getTableExamination();
        scrollPaneExamination = settingExamGUI.getExaminationScrollPanel();

        student = GlobalValues.student;
        settingExamGUI.setInfoAboutStudentToField(student);

        List<ExamCard> examCardList = examCardService.findByStudentId(student.getId());

        for (ExamCard examCard : examCardList)
        {
            Subject subject = subjectService.findById(examCard.getSubjectId());
            subjectList.add(subject);
        }

        doBindingSubjectToExam(subjectList, tableExamination, scrollPaneExamination);
    }

    private void doBindingSubjectToExam(List<Subject> subjectList, JTable jTable, JScrollPane jScrollPane)
    {
        TableBinding.bindingSubjectToExam(subjectList, jTable, jScrollPane);

        TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
        TextAreaEditor textEditor = new TextAreaEditor();
        textEditor.setEditAble(false);
        TableColumnModel cmodel = jTable.getColumnModel();
        cmodel.getColumn(0).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(0).setCellEditor(textEditor);
        cmodel.getColumn(1).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(1).setCellEditor(textEditor);
        cmodel.getColumn(2).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(2).setCellEditor(textEditor);

        JTableHeader header = jTable.getTableHeader();
        header.setPreferredSize(new Dimension(10000, 30));
        jTable.getTableHeader().setReorderingAllowed(true);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable.repaint();
    }

//    private void resetResultGUI()
//    {
//        mainStudentGUI.getResultGUI().getComboBoxSubject().removeAllItems();
//        mainStudentGUI.getResultGUI().getComboBoxExamination().removeAllItems();
//    }

//
//    private void resetComboBoxSubject() {
//        mainStudentGUI.getSettingExamGUI().getComboBoxSubject().removeAllItems();
//        mainStudentGUI.getSettingExamGUI().getComboBoxSubject().addItem("Chọn môn thi ...");
//    }
//
//    public void doStart() {
//
//        int index = tableExamination.getSelectedRow();
//        if (index != -1) {
//            exam = examCardList.get(index);
//            subject = subjectService.findBySubjectName(mainStudentGUI.getSettingExamGUI().getComboBoxSubject().getSelectedItem().toString());
//            if (exam.isActivate()) {
//                ExamCard result = resultService.findByExamRelationResultAndStudentRelation(exam, student);
//                if (result == null) {
//                    result = new ExamCard();
//                    result.setExamRelationResult(exam);
//                    result.setStudentRelation(student);
//                    examController.showButtonQuestion(exam);
//                    examController.showButtonAnswer(exam);
//                    mainStudentController.doShowExamCard();
//                    examController.setTotalNumberAnswered(0);
//                    examController.doExam(result, exam,student);
//                } else {
//                    JOptionPane.showMessageDialog(null, "Sinh vien nay da thi roi");
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "De thi chua kich hoat");
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Bạn phải chọn 1 môn thi");
//        }
//
//
//    }
//
//    private void setUpBindingExamination(Subject subject) {
//
//        List<Exam> exams = examService.findBySubjectRelationExam(subject);
//        if (exams.size() != 0) {
//            examCardList = ObservableCollections.observableList(exams);
//            doBindingExamination(examCardList);
//
//        } else {
////            examCardList = ObservableCollections.observableList(new ArrayList<Exam>());
//            JOptionPane.showMessageDialog(null, "Hiện tại chưa có đề thi cho môn học này.");
//        }
//
//
//    }
}
