package com.ptit.exam.ui.control.usercontroller;

import com.ptit.exam.business.ExamService;
import com.ptit.exam.business.StudentService;
import com.ptit.exam.business.SubjectService;
import com.ptit.exam.business.common.TableBinding;
import com.ptit.exam.business.common.TextAreaEditor;
import com.ptit.exam.business.common.TextAreaRenderer;
import com.ptit.exam.persistence.entity.ResultDTOBinding;
import com.ptit.exam.persistence.entity.Subject;
import com.ptit.exam.ui.view.student.MainStudentGUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.List;

/**
 * User: thuongntt
 * Date: 10/20/13
 * Time: 4:54 PM
 */
@Component
public class ResultController {
    @Autowired
    MainStudentGUI mainStudentGUI;
    @Autowired
    SubjectService subjectService;
    @Autowired
    ExamService examService;
    @Autowired
    StudentService studentService;

    private List<ResultDTOBinding> resultList;
    private JTable resultTable;
    private List<Subject> subjectList;

    public void setUp() {
        resetGUI();
        setUpResultGUI();
    }

    private void resetGUI() {
        resetResultGUI();
        resetComboBoxFaculty();
        resetComboBoxSubject();
        resetComboBoxExamination();
    }


    private void setUpResultGUI() {

    }

    private void resetResultGUI() {
        if (resultList != null) {
            for (int i = 0; i < resultList.size(); i++) {
                resultList.remove(i);
            }
        }

        if (resultTable != null) {
            doBindingResult(resultList);
        }
    }

    private void resetComboBoxFaculty() {
        mainStudentGUI.getResultGUI().getCbBoxFacultyTab2().removeAllItems();
        mainStudentGUI.getResultGUI().getCbBoxFacultyTab2().addItem("Choose faculty ...");

    }

    private void resetComboBoxSubject() {
        mainStudentGUI.getResultGUI().getComboBoxSubject().removeAllItems();
        mainStudentGUI.getResultGUI().getComboBoxSubject().addItem("Choose subject ...");
    }

    private void resetComboBoxExamination() {

        mainStudentGUI.getResultGUI().getComboBoxExamination().removeAllItems();
        mainStudentGUI.getResultGUI().getComboBoxExamination().addItem("Choose examination ...");

    }

    private void doBindingResult(List<ResultDTOBinding> resultList) {
        TableBinding.bindingResult(resultList, resultTable, mainStudentGUI.getResultGUI().getMarkScrollPanel());

        // todo :dang lam do o day
        TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
        TextAreaEditor textEditor = new TextAreaEditor();
        textEditor.setEditAble(false);
        TableColumnModel cmodel = resultTable.getColumnModel();
        cmodel.getColumn(0).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(0).setCellEditor(textEditor);
        cmodel.getColumn(1).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(1).setCellEditor(textEditor);


        JTableHeader header = resultTable.getTableHeader();
        header.setPreferredSize(new Dimension(10000, 30));
        resultTable.getTableHeader().setReorderingAllowed(false);
        resultTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        resultTable.repaint();
    }
}
