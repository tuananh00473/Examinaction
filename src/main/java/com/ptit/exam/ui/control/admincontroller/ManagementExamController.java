package com.ptit.exam.ui.control.admincontroller;

import com.ptit.exam.business.ExamService;
import com.ptit.exam.business.common.TableBinding;
import com.ptit.exam.business.common.TextAreaEditor;
import com.ptit.exam.business.common.TextAreaRenderer;
import com.ptit.exam.persistence.entity.Exam;
import com.ptit.exam.ui.view.admin.ExportExamination;
import com.ptit.exam.ui.view.admin.MainAdminGUI;
import com.ptit.exam.ui.view.admin.ManagermentExamGUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
//    private String nameSubject;
//
    public void doSetUp()
    {
        setUpView();
        setUpActionListenner();

        examList = examService.getAll();
        doBindingManagermentExam(examList, managementExamTable, managementExamScrollPanel);
    }

    private void setUpActionListenner()
    {
        managementExamGUI.getBtnSearch().addActionListener(actionListener);
        managementExamGUI.getBtnAddExam().addActionListener(actionListener);
        managementExamGUI.getBtnEditExam().addActionListener(actionListener);
        managementExamGUI.getBtnDeleteExam().addActionListener(actionListener);
    }

    private ActionListener actionListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == managementExamGUI.getBtnSearch())
            {
            }
            if (e.getSource() == managementExamGUI.getBtnAddExam())
            {
                exportExamController.doSetUp(new Exam());
                mainAdminController.doShowExportExamCard();
            }
            if (e.getSource() == managementExamGUI.getBtnEditExam())
            {
                int select = managementExamTable.getSelectedRow();
                if (-1 == select)
                {
                    showMessage("Hãy chọn đề thi bạn muốn sửa.");
                }
                else
                {
                    doSetUpEditExam(examList.get(select));
                    mainAdminController.doShowExportExamCard();
                }
            }
            if (e.getSource() == managementExamGUI.getBtnDeleteExam())
            {
                int select = managementExamTable.getSelectedRow();
                if (-1 == select)
                {
                    showMessage("Hãy chọn đề thi bạn cần xóa.");
                }
                else
                {
                    int k = showConfirmMessage("Bạn chắc chắn muốn xóa?");
                    if (0 == k)
                    {
                        examService.delete(examList.get(select));
                        examList.remove(select);
                        doBindingManagermentExam(examList, managementExamTable, managementExamScrollPanel);
                    }
                }
            }
        }
    };

    private void doSetUpEditExam(Exam exam)
    {
        exportExamination.setInforExam(exam);
        exportExamController.doSetUp(exam);
    }

    private void setUpView()
    {
        managementExamGUI = mainAdminGUI.getManagermentExamGUI();
        exportExamination = mainAdminGUI.getExportExaminationGUI();

        managementExamTable = managementExamGUI.getManagementExamTable();
        managementExamScrollPanel = managementExamGUI.getManagementExamScrollpanel();
    }
//
//    public void doSearch() {
//        examList = ObservableCollections.observableList(new ArrayList<Exam>());
//        managementExamTable = mainAdminGUI.getManagermentExamGUI().getManagementExamTable();
//        nameSubject = mainAdminGUI.getManagermentExamGUI().getComboBoxSubject().getSelectedItem().toString();
//        Subject subject = subjectService.findBySubjectName(nameSubject);
//        examList = examService.findBySubjectRelationExam(subject);
//        doBindingManagermentExam(examList);
//
//
//    }

    private void doBindingManagermentExam(List<Exam> examList, JTable table, JScrollPane scrollPane)
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

        JTableHeader header = managementExamTable.getTableHeader();
        header.setPreferredSize(new Dimension(10000, 30));
        managementExamTable.getTableHeader().setReorderingAllowed(false);
        managementExamTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        managementExamTable.repaint();
    }

    private void showMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }

    private int showConfirmMessage(String message)
    {
        return JOptionPane.showConfirmDialog(null, message);
    }
}
