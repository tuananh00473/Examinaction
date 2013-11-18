package com.ptit.exam.ui.control.usercontroller;

import com.ptit.exam.business.ExamCardService;
import com.ptit.exam.business.ExamService;
import com.ptit.exam.business.SubjectService;
import com.ptit.exam.business.common.TableBinding;
import com.ptit.exam.business.common.TextAreaEditor;
import com.ptit.exam.business.common.TextAreaRenderer;
import com.ptit.exam.persistence.entity.Exam;
import com.ptit.exam.persistence.entity.ExamCard;
import com.ptit.exam.persistence.entity.Student;
import com.ptit.exam.persistence.entity.Subject;
import com.ptit.exam.ui.view.student.MainStudentGUI;
import com.ptit.exam.ui.view.student.SettingExamGUI;
import com.ptit.exam.util.GlobalValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
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

    //    @Autowired
//    StudentService studentService;
//
    @Autowired
    SubjectService subjectService;

    @Autowired
    ExamService examService;
    //
//    @Autowired
//    MainStudentController mainStudentController;
//
//    @Autowired
//    ExamQuestionService examQuestionService;
//
//    @Autowired
//    QuestionService questionService;
//
//    @Autowired
//    AnswerService answerService;
//
    @Autowired
    ExamCardService examCardService;

    //    @Autowired
//    ExamController examController;
//
    private Student student;
    private List<Exam> examList;
    private JTable tableExamination;
    private JScrollPane scrollPaneExamination;

    private SettingExamGUI settingExamGUI;

    // private ExamCard examCard;
    private Subject subject;

    //    private Exam exam;
//
//
    public void doSetUp()
    {
//        resetComboBoxSubject();
        settingExamGUI = mainStudentGUI.getSettingExamGUI();
        tableExamination = settingExamGUI.getTableExamination();
        scrollPaneExamination = settingExamGUI.getExaminationScrollPanel();

        resetSettingExamGUI();

        student = GlobalValues.student;
        settingExamGUI.setInfoAboutStudentToField(student);

        List<ExamCard> examCardList = examCardService.findByStudentId(student.getId());
        for (ExamCard examCard : examCardList)
        {
            Subject subject = subjectService.findById(examCard.getSubjectId());
            settingExamGUI.getComboBoxSubject().addItem(subject.getSubjectName());
        }

        settingExamGUI.getComboBoxSubject().addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                String subjectName = settingExamGUI.getComboBoxSubject().getSelectedItem().toString();
                if (!"".equals(subjectName))
                {
                    subject = subjectService.findByFacultyAndSubjectName(student.getFaculty(), subjectName);
                    examList = examService.findBySubjectCode(subject.getSubjectCode());
                    doBindingExamination(examList, tableExamination, scrollPaneExamination);
                }
            }
        });

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

    private void resetSettingExamGUI()
    {
        settingExamGUI.getComboBoxSubject().setModel(new DefaultComboBoxModel(new String[]{""}));
    }

    private void resetResultGUI()
    {
        mainStudentGUI.getResultGUI().getComboBoxSubject().removeAllItems();
        mainStudentGUI.getResultGUI().getComboBoxExamination().removeAllItems();
    }

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
//            exam = examList.get(index);
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
//
//    private void stopEditting() {
//        if (tableExamination.isEditing()) {
//            tableExamination.getCellEditor().stopCellEditing();
//        }
//    }
//
//    private void setUpBindingExamination(Subject subject) {
//
//        List<Exam> exams = examService.findBySubjectRelationExam(subject);
//        if (exams.size() != 0) {
//            examList = ObservableCollections.observableList(exams);
//            doBindingExamination(examList);
//
//        } else {
////            examList = ObservableCollections.observableList(new ArrayList<Exam>());
//            JOptionPane.showMessageDialog(null, "Hiện tại chưa có đề thi cho môn học này.");
//        }
//
//
//    }

    private void doBindingExamination(List<Exam> examList, JTable table, JScrollPane scrollPane)
    {
        TableBinding.bindingExamination(examList, table, scrollPane);

        TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
        TextAreaEditor textEditor = new TextAreaEditor();
        textEditor.setEditAble(false);
        TableColumnModel cmodel = table.getColumnModel();
        cmodel.getColumn(0).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(0).setCellEditor(textEditor);
        cmodel.getColumn(1).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(1).setCellEditor(textEditor);
        cmodel.getColumn(2).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(2).setCellEditor(textEditor);
        cmodel.getColumn(3).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(3).setCellEditor(textEditor);


        JTableHeader header = table.getTableHeader();
        header.setPreferredSize(new Dimension(10000, 30));
        table.getTableHeader().setReorderingAllowed(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.repaint();
    }
}
