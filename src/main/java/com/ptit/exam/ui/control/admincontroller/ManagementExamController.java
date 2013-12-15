package com.ptit.exam.ui.control.admincontroller;

import com.ptit.exam.business.AnswerService;
import com.ptit.exam.business.ExamService;
import com.ptit.exam.business.QuestionService;
import com.ptit.exam.business.SubjectService;
import com.ptit.exam.business.common.TableBinding;
import com.ptit.exam.business.common.TextAreaEditor;
import com.ptit.exam.business.common.TextAreaRenderer;
import com.ptit.exam.persistence.entity.Exam;
import com.ptit.exam.persistence.entity.Subject;
import com.ptit.exam.ui.view.admin.MainAdminGUI;
import com.ptit.exam.ui.view.admin.ManagementExamGUI;
import com.ptit.exam.ui.view.admin.NewExaminationGUI;
import com.ptit.exam.util.ComboboxManager;
import com.ptit.exam.util.GlobalValues;
import com.ptit.exam.util.MessageManager;
import org.jdesktop.observablecollections.ObservableCollections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * User: thuongntt
 * Date: 10/21/13
 * Time: 10:56 AM
 */
@Component
public class ManagementExamController {
    @Autowired
    MainAdminGUI mainAdminGUI;

    @Autowired
    MainAdminController mainAdminController;

    @Autowired
    NewExamController newExamController;

    @Autowired
    ExamService examService;

    @Autowired
    SubjectService subjectService;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    private ManagementExamGUI managementExamGUI;
    private NewExaminationGUI newExaminationGUI;

    private List<Exam> examList;
    private JTable managementExamTable;
    private JScrollPane managementExamScrollPanel;
    private List<Subject> subjectList;


    private boolean editInfo;

    public void doSetUp(Exam exam) {
        setUpView(exam);
        setUpActionListenner();

    }

    private void setUpActionListenner() {
        if (GlobalValues.MANAGEMENT_EXAM_ADD_ACTION) {
            managementExamGUI.getBtnAddExam().addActionListener(actionListener);
            managementExamGUI.getBtnEditExam().addActionListener(actionListener);
            managementExamGUI.getBtnDeleteExam().addActionListener(actionListener);
            managementExamGUI.getBtnSave().addActionListener(actionListener);
            managementExamGUI.getBtnCancel().addActionListener(actionListener);
            managementExamGUI.getComboBoxSubject().addItemListener(itemListener);
        }
        GlobalValues.MANAGEMENT_EXAM_ADD_ACTION = false;
    }

    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == managementExamGUI.getBtnAddExam()) {
                doAddExam();
                return;
            }
            if (e.getSource() == managementExamGUI.getBtnEditExam()) {
                doEditExam();
                return;
            }
            if (e.getSource() == managementExamGUI.getBtnDeleteExam()) {
                doDeleteExam();
                return;
            }
            if (e.getSource() == managementExamGUI.getBtnSave()) {
                doSave();
                return;
            }
            if (e.getSource() == managementExamGUI.getBtnCancel()) {
                doCancel();
                return;
            }
        }
    };

    private void doCancel() {
        setExamList();
    }

    private void doSave() {
        for (Exam exam : examList) {
            examService.save(exam);
        }
    }

    private ItemListener itemListener = new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            setExamList();
        }
    };

    private void setExamList() {
        String subjectName = managementExamGUI.getComboBoxSubject().getSelectedItem().toString();
        examList = ("".equals(subjectName)) ? ObservableCollections.observableList(new ArrayList<Exam>()) : examService.findBySubjectName(subjectName);
        doBindingExam(examList, managementExamTable, managementExamScrollPanel);
    }

    private void doAddExam() {
        newExamController.doSetUp(new Exam());
        newExaminationGUI.resetExportExamGUI();
        mainAdminController.doShowNewExamCard();
    }

    private void doEditExam() {
        int select = managementExamTable.getSelectedRow();
        if (-1 == select) {
            MessageManager.show("Hãy chọn đề thi bạn muốn sửa.");
        } else {
            doSetUpEditExam(examList.get(select));
            mainAdminController.doShowExportExamCard();
        }
    }

    private void doDeleteExam() {
        int select = managementExamTable.getSelectedRow();
        if (-1 == select) {
            MessageManager.show("Hãy chọn đề thi bạn muốn xóa.");
        } else {
            int k = MessageManager.showConfirm("Bạn chắc chắn muốn xóa?");
            if (0 == k) {
                examService.delete(examList.get(select));
                examList.remove(select);
                doBindingExam(examList, managementExamTable, managementExamScrollPanel);
            }
        }
    }

    private void doSetUpEditExam(Exam exam) {
        newExamController.doSetUp(exam);
        newExaminationGUI.mappingInfoToField(managementExamGUI.getComboBoxSubject().getSelectedIndex(), exam);
    }

    private void setUpView(Exam exam) {
        managementExamGUI = mainAdminGUI.getManagementExamGUI();
        newExaminationGUI = mainAdminGUI.getNewExaminationGUI();

        subjectList = subjectService.getAll();
        ComboboxManager.setListSubject(managementExamGUI.getComboBoxSubject(), subjectList);

        managementExamTable = managementExamGUI.getManagementExamTable();
        managementExamScrollPanel = managementExamGUI.getManagementExamScrollPanel();

        resetView(exam);
    }

    private void resetView(Exam exam) {
        if (null == exam) {
            examList = ObservableCollections.observableList(new ArrayList<Exam>());
        } else {
            updateExamList(examList, exam);
            int index = newExaminationGUI.getComboBoxSubject().getSelectedIndex();
            managementExamGUI.getComboBoxSubject().setSelectedIndex(index);
        }
        doBindingExam(examList, managementExamTable, managementExamScrollPanel);
    }

    private void updateExamList(List<Exam> examList, Exam exam) {
        for (Exam examItem : examList) {
            if (exam.getId() == examItem.getId()) {
                examList.remove(examItem);
                examList.add(exam);
                break;
            }
        }
    }

    private void doBindingExam(List<Exam> examList, JTable table, JScrollPane scrollPane) {
        Collections.sort(examList, new Comparator<Exam>() {
            public int compare(Exam exam1, Exam exam2) {
                return exam1.getId().compareTo(exam2.getId());
            }
        });
        TableBinding.bindingManagementExam(examList, table, scrollPane);

        TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
        TextAreaEditor textEditor = new TextAreaEditor();

        textEditor.setEditAble(false);
        TableColumnModel cmodel = managementExamTable.getColumnModel();
        cmodel.getColumn(0).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(0).setCellEditor(textEditor);
        cmodel.getColumn(1).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(1).setCellEditor(textEditor);
        cmodel.getColumn(2).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(2).setCellEditor(textEditor);
        cmodel.getColumn(3).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(3).setCellEditor(textEditor);
        cmodel.getColumn(4).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(4).setCellEditor(textEditor);
        cmodel.getColumn(5).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(5).setCellEditor(textEditor);
        cmodel.getColumn(6).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(6).setCellEditor(textEditor);
        cmodel.getColumn(7).setCellRenderer(table.getDefaultRenderer(Boolean.class));
        cmodel.getColumn(7).setCellEditor(table.getDefaultEditor(Boolean.class));

        JTableHeader header = managementExamTable.getTableHeader();
        header.setPreferredSize(new Dimension(10000, 30));
        managementExamTable.getTableHeader().setReorderingAllowed(false);
        managementExamTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        managementExamTable.repaint();
    }
}
