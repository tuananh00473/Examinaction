package com.ptit.exam.ui.control.usercontroller;

import com.ptit.exam.business.ExamService;
import com.ptit.exam.business.ResultService;
import com.ptit.exam.business.StudentService;
import com.ptit.exam.business.SubjectService;
import com.ptit.exam.business.common.TableBinding;
import com.ptit.exam.business.common.TextAreaEditor;
import com.ptit.exam.business.common.TextAreaRenderer;
import com.ptit.exam.persistence.entity.*;
import com.ptit.exam.ui.view.student.MainStudentGUI;
import com.ptit.exam.ui.view.student.ResultGUI;
import org.jdesktop.observablecollections.ObservableCollections;
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
 * Date: 10/20/13
 * Time: 4:54 PM
 */
@Component
public class ResultController {
    @Autowired
    MainStudentGUI mainStudentGUI;
    @Autowired
    ResultService resultService;
    @Autowired
    ExamService examService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    StudentService studentService;

    private ResultGUI resultGUI;

    private List<Result> resultList;
    private List<ResultDTOBinding> resultListBinding;
    private JTable resultTable;
    private JScrollPane resultScrollPane;

    public void setUp() {
        resetGUI();
        setUpResultGUI();
        setUpActionListener();
    }

    private void setUpActionListener() {
        resultGUI.getBtnSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doSearch();
            }
        });
    }

    private void doSearch() {
        resultList = getResultListBinding();
        resultListBinding = convertFromResultList(resultList);

        doBindingResult(resultListBinding, resultTable, resultScrollPane);
    }

    private void resetGUI() {

    }

    private void setUpResultGUI() {
        resultGUI = mainStudentGUI.getResultGUI();
        resultTable = resultGUI.getTableResult();
        resultScrollPane = resultGUI.getResultScrollPanel();
    }

    private List<ResultDTOBinding> convertFromResultList(List<Result> resultList) {
        List<ResultDTOBinding> resultListBinding = ObservableCollections.observableList(new ArrayList<ResultDTOBinding>());
        for (Result result : resultList) {
            ResultDTOBinding resultDTOBinding = new ResultDTOBinding();

            Exam exam = examService.findById(result.getExamId());
            Student student = studentService.findById(result.getStudentId());
            Subject subject = subjectService.findBySubjectCode(exam.getSubjectCode());

            resultDTOBinding.setExamName(exam.getExamName());
            resultDTOBinding.setStudentCode(student.getStudentCode());
            resultDTOBinding.setStudentFirstName(student.getFirstName());
            resultDTOBinding.setStudentLastName(student.getLastName());
            resultDTOBinding.setClassRoom(student.getClassRoom());
            resultDTOBinding.setFaculty(student.getFaculty());
            resultDTOBinding.setScore(result.getScore());
            resultDTOBinding.setMaxScore(result.getMaxScore());
            resultDTOBinding.setSubjectName(subject.getSubjectName());

            resultListBinding.add(resultDTOBinding);
        }
        return resultListBinding;
    }

    private List<Result> getResultListBinding() {
        String faculty = resultGUI.getComboBoxFaculty().getSelectedItem().toString();
        String classRoom = resultGUI.getComboBoxClass().getSelectedItem().toString();
        String subjectName = resultGUI.getComboBoxSubject().getSelectedItem().toString();
        String examName = resultGUI.getComboBoxExamination().getSelectedItem().toString();

        List<Result> list1 = ("".equals(faculty)) ? resultService.getAll() : resultService.findByFaculty(faculty);
        List<Result> list2 = ("".equals(classRoom)) ? resultService.getAll() : resultService.findByClassRoom(classRoom);
        List<Result> list3 = ("".equals(subjectName)) ? resultService.getAll() : resultService.findBySubjectName(subjectName);
        List<Result> list4 = ("".equals(examName)) ? resultService.getAll() : resultService.findByExamName(examName);
        List<Result> searchList = new ArrayList<Result>();

        for (Result result : list1) {
            if (list2.contains(result)) {
                searchList.add(result);
            }
        }
        return searchList;
    }

    private void doBindingResult(List<ResultDTOBinding> resultList, JTable jTable, JScrollPane jScrollPane) {
        TableBinding.bindingResult(resultList, jTable, jScrollPane);

        // todo :dang lam do o day
        TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
        TextAreaEditor textEditor = new TextAreaEditor();
        textEditor.setEditAble(false);
        textEditor.setEditAble(false);
        TableColumnModel cmodel = jTable.getColumnModel();
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
        cmodel.getColumn(7).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(7).setCellEditor(textEditor);
        cmodel.getColumn(8).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(8).setCellEditor(textEditor);


        JTableHeader header = jTable.getTableHeader();
        header.setPreferredSize(new Dimension(10000, 30));
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable.repaint();
    }
}