package com.ptit.exam.ui.control.admincontroller;

import com.ptit.exam.business.ExamService;
import com.ptit.exam.business.common.TableBinding;
import com.ptit.exam.business.common.TextAreaEditor;
import com.ptit.exam.business.common.TextAreaRenderer;
import com.ptit.exam.persistence.entity.Exam;
import com.ptit.exam.ui.view.admin.ExportExamination;
import com.ptit.exam.ui.view.admin.MainAdminGUI;
import com.ptit.exam.ui.view.admin.ManagermentExamGUI;
import com.ptit.exam.util.Constants;
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
import java.util.List;

/**
 * User: thuongntt
 * Date: 10/21/13
 * Time: 10:56 AM
 */
@Component
public class ManagementExamController
{
    @Autowired
    MainAdminGUI mainAdminGUI;

    @Autowired
    MainAdminController mainAdminController;

    @Autowired
    ExportExamController exportExamController;

    @Autowired
    ExamService examService;

    private ManagermentExamGUI managementExamGUI;
    private ExportExamination exportExamination;

    private List<Exam> examList;
    private JTable managementExamTable;
    private JScrollPane managementExamScrollPanel;

    //    private Set<String> stringSet = new HashSet<String>();

    public void doSetUp()
    {
        setUpView();
        setUpActionListenner();
    }

    private void setUpActionListenner()
    {
        if (GlobalValues.MANAGEMENT_EXAM_ADD_ACTION)
        {
            managementExamGUI.getBtnAddExam().addActionListener(actionListener);
            managementExamGUI.getBtnEditExam().addActionListener(actionListener);
            managementExamGUI.getBtnDeleteExam().addActionListener(actionListener);
            managementExamGUI.getComboBoxSubject().addItemListener(itemListener);
        }
        GlobalValues.MANAGEMENT_EXAM_ADD_ACTION = false;
    }

    private ActionListener actionListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == managementExamGUI.getBtnAddExam())
            {
                doAddExam();
            }
            if (e.getSource() == managementExamGUI.getBtnEditExam())
            {
                doEditExam();
            }
            if (e.getSource() == managementExamGUI.getBtnDeleteExam())
            {
                doDeleteExam();
            }
        }
    };

    private ItemListener itemListener = new ItemListener()
    {
        @Override
        public void itemStateChanged(ItemEvent e)
        {
            String subjectCode = managementExamGUI.getComboBoxSubject().getSelectedItem().toString();
            examList = ("".equals(subjectCode)) ? ObservableCollections.observableList(new ArrayList<Exam>()) : examService.findBySubjectCode(subjectCode);
            doBindingExam(examList, managementExamTable, managementExamScrollPanel);
        }
    };

    private void doAddExam()
    {
        exportExamController.doSetUp(new Exam());
        exportExamination.resetExportExamGUI();
        mainAdminController.doShowExportExamCard();
    }

    private void doEditExam()
    {
        int select = managementExamTable.getSelectedRow();
        if (-1 == select)
        {
            MessageManager.show("Hãy chọn đề thi bạn muốn sửa.");
        }
        else
        {
            doSetUpEditExam(examList.get(select));
            mainAdminController.doShowExportExamCard();
        }
    }

    private void doDeleteExam()
    {
        int select = managementExamTable.getSelectedRow();
        if (-1 == select)
        {
            MessageManager.show("Hãy chọn đề thi bạn muốn xóa.");
        }
        else
        {
            int k = MessageManager.showConfirm("Bạn chắc chắn muốn xóa?");
            if (0 == k)
            {
                examService.delete(examList.get(select));
                examList.remove(select);
                doBindingExam(examList, managementExamTable, managementExamScrollPanel);
            }
        }
    }

    private void doSetUpEditExam(Exam exam)
    {
        exportExamController.doSetUp(exam);
        exportExamination.mappingInfoToField(exam);
    }

    private void setUpView()
    {
        managementExamGUI = mainAdminGUI.getManagermentExamGUI();
        exportExamination = mainAdminGUI.getExportExaminationGUI();

        managementExamGUI.getComboBoxSubject().setModel(new DefaultComboBoxModel(Constants.subjects));

        managementExamTable = managementExamGUI.getManagementExamTable();
        managementExamScrollPanel = managementExamGUI.getManagementExamScrollpanel();
    }

    private void doBindingExam(List<Exam> examList, JTable table, JScrollPane scrollPane)
    {
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
