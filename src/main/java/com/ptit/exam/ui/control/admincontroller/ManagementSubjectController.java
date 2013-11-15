package com.ptit.exam.ui.control.admincontroller;

import com.ptit.exam.business.SubjectService;
import com.ptit.exam.business.common.TableBinding;
import com.ptit.exam.business.common.TextAreaEditor;
import com.ptit.exam.business.common.TextAreaRenderer;
import com.ptit.exam.persistence.entity.Subject;
import com.ptit.exam.ui.view.admin.MainAdminGUI;
import com.ptit.exam.ui.view.admin.ManagementSubjectGUI;
import com.ptit.exam.ui.view.admin.NewSubjectGUI;
import com.ptit.exam.util.Constants;
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
 * Date: 10/21/13
 * Time: 4:50 PM
 */
@Component
public class ManagementSubjectController {

    @Autowired
    MainAdminGUI mainAdminGUI;

    @Autowired
    SubjectService subjectService;

    @Autowired
    AddSubjectController addSubjectController;

    @Autowired
    MainAdminController mainAdminController;

    private List<Subject> tab1SubjectList;
    private JTable tab1SubjectTable;
    private JScrollPane tab1SubjectScrollpane;

    private ManagementSubjectGUI managementSubjectGUI;
    private NewSubjectGUI newSubjectGUI;

    public void doSetUp() {
        setUpView();
        setUpActionListener();

        tab1SubjectList = subjectService.getAll();
        doBindingSubject(tab1SubjectList, tab1SubjectTable, tab1SubjectScrollpane);
    }

    private void setUpActionListener() {
        managementSubjectGUI.getBtnAddSUBJECT().addActionListener(actionListener);
        managementSubjectGUI.getBtnEditSUBJECT().addActionListener(actionListener);
        managementSubjectGUI.getBtnDelSUBJECT().addActionListener(actionListener);
        managementSubjectGUI.getBtnSearchTab1().addActionListener(actionListener);
    }

    private void setUpView() {
        managementSubjectGUI = mainAdminGUI.getManagementSubjectGUI();
        newSubjectGUI = mainAdminGUI.getNewSubjectGUI();

        tab1SubjectTable = managementSubjectGUI.getTableSUBJECT();
        tab1SubjectScrollpane = managementSubjectGUI.getScrollPaneSUBJECT();
        managementSubjectGUI.getCbBoxFacultyTab1().setModel(new DefaultComboBoxModel(Constants.facultyList));

        managementSubjectGUI.getCbBoxFacultyTab2().setModel(new DefaultComboBoxModel(Constants.facultyList));
        managementSubjectGUI.getComboBoxCourse().setModel(new DefaultComboBoxModel(Constants.courseList));
    }

    public ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == managementSubjectGUI.getBtnAddSUBJECT()) {
                doAddSubject();
            }
            if (e.getSource() == managementSubjectGUI.getBtnEditSUBJECT()) {
                doEditSubject();
            }
            if (e.getSource() == managementSubjectGUI.getBtnDelSUBJECT()) {
                doDeleteSubject();
            }
            if (e.getSource() == managementSubjectGUI.getBtnSearchTab1()) {
                doSearchTab1();
            }
        }
    };

    private void doEditSubject() {
        int select = tab1SubjectTable.getSelectedRow();
        if (-1 == select) {
            MessageManager.show("Hãy chọn môn học bạn muốn sửa.");
        } else {
            doSetUpEditSubject(tab1SubjectList.get(select));
            mainAdminController.doShowNewSubjectCard();
        }
    }

    private void doSetUpEditSubject(Subject subject) {
        addSubjectController.doSetUp(subject);
        newSubjectGUI.mappingInfoToField(subject);
    }

    private void doSearchTab1() {
        String nameSubject = managementSubjectGUI.getTxtNameSubjectSearch().getText();
        String nameFaculty = managementSubjectGUI.getCbBoxFacultyTab1().getSelectedItem().toString();

        List<Subject> list1 = ("".equals(nameSubject) ? subjectService.getAll() : subjectService.findBySubjectName(nameSubject));
        List<Subject> list2 = ("".equals(nameFaculty) ? subjectService.getAll() : subjectService.findByFaculty(nameFaculty));

        tab1SubjectList = new ArrayList<Subject>();
        for (Subject subject : list1) {
            if (list2.contains(subject)) {
                tab1SubjectList.add(subject);
            }
        }
        doBindingSubject(tab1SubjectList, tab1SubjectTable, tab1SubjectScrollpane);
    }

    private void doDeleteSubject() {
        int rowSelected = tab1SubjectTable.getSelectedRow();
        if (-1 == rowSelected) {
            MessageManager.show("Hãy chọn môn học bạn muốn xóa.");
        } else {
            int k = MessageManager.showConfirm("Bạn chắc chắn muốn xóa môn học này?");
            if (0 == k) {
                subjectService.delete(tab1SubjectList.get(rowSelected));
                tab1SubjectList.remove(rowSelected);
                doBindingSubject(tab1SubjectList, tab1SubjectTable, tab1SubjectScrollpane);
            }
        }
    }

    private void doAddSubject() {
        addSubjectController.doSetUp(new Subject());
        newSubjectGUI.resetNewSubjectGUI();
        mainAdminController.doShowNewSubjectCard();
    }

//    public void doSearch() {
//
//        Set<Subject> subjectSet = new HashSet<Subject>();
//        managementSubjectGUI = mainAdminGUI.getManagementSubjectGUI();
//        nameFaculty = managementSubjectGUI.getCbBoxFacultyTab2().getSelectedItem().toString();
//        nameCourse = managementSubjectGUI.getComboBoxCourse().getSelectedItem().toString();
//
//        tab1SubjectList = ObservableCollections.observableList(subjectService.findByFaculty(nameFaculty));
//        studentList = ObservableCollections.observableList(studentService.findByFacultyAndCourse(nameFaculty, nameCourse));
//
//        if (studentList.size() != 0) {
//            studentSubjectList = studentSubjectService.findByStudentRelationStudentSubject(studentList.get(0));
//
//
//        }
//
//        subjectSelectedList = ObservableCollections.observableList(new ArrayList<Subject>());
//
//        for (StudentSubject studentSubject : studentSubjectList) {
//            subject = studentSubject.getSubjectRelationStudentSubject();
//            subjectSet.add(subject);
//            for (Subject subject1 : tab1SubjectList) {
//                if (subject1.getId().equals(subject.getId())) {
//                    tab1SubjectList.remove(subject1);
//                    break;
//                }
//            }
//
//        }
//
//
//
//        for (Subject subject1 : subjectSet) {
//            subjectSelectedList.add(subject1);
//
//        }
//        for (Subject subject1 : subjectSet) {
//            subjectSet.add(subject1);
//
//        }
//
//        subjectTable = managementSubjectGUI.getSubjectTable();
//        subjectScrollpane = managementSubjectGUI.getSubjectScrollpanel();
//        doBindingSubject(tab1SubjectList, subjectTable, subjectScrollpane);
//
//        subjectSelectedTable = managementSubjectGUI.getSubjectSelectedTable();
//        subjectSelectedScrollpane = managementSubjectGUI.getSubjectSelectedScrollpanel();
//        doBindingSubject(subjectSelectedList, subjectSelectedTable, subjectSelectedScrollpane);
//
//
//    }


    private void doBindingSubject(List<Subject> subjectList, JTable jTable, JScrollPane jScrollPane) {
        TableBinding.bindingSubject(subjectList, jTable, jScrollPane);

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
        cmodel.getColumn(3).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(3).setCellEditor(textEditor);
        cmodel.getColumn(4).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(4).setCellEditor(textEditor);
        JTableHeader header = jTable.getTableHeader();
        header.setPreferredSize(new Dimension(10000, 30));
        jTable.getTableHeader().setReorderingAllowed(true);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable.repaint();
    }
//
//    public void doAdd() {
//        managementSubjectGUI = mainAdminGUI.getManagementSubjectGUI();
//
//        int index = managementSubjectGUI.getSubjectTable().getSelectedRow();
//        if (index != -1) {
//            subject = tab1SubjectList.get(index);
//            tab1SubjectList.remove(subject);
//            subjectSelectedList.add(subject);
//        } else {
//            JOptionPane.showMessageDialog(null, "Bạn cần chọn 1 môn thi !");
//        }
//
//
//    }
//
//
//    public void doDelete() {
//        managementSubjectGUI = mainAdminGUI.getManagementSubjectGUI();
//        int index = managementSubjectGUI.getSubjectSelectedTable().getSelectedRow();
//        if (index != -1) {
//            subject = subjectSelectedList.get(index);
//            subjectSelectedList.remove(subject);
//            tab1SubjectList.add(subject);
//
//            List<StudentSubject> studentSubjectList1 = studentSubjectService.findBySubjectRelationStudentSubject(subject);
//            for (StudentSubject studentSubject : studentSubjectList1) {
//                studentSubjectService.delete(studentSubject);
//            }
//
//
//        } else {
//            JOptionPane.showMessageDialog(null, "Bạn cần chọn 1 môn thi !");
//        }
//
//    }
//
//    public void doSave() {
//        for (Student student : studentList) {
//            for (Subject subject1 : subjectSelectedList) {
//                StudentSubject studentSubject = studentSubjectService.findByStudentSubject(student, subject1);
//                if (studentSubject == null) {
//                    studentSubjectService.save(new StudentSubject(student, subject1, false));
//                }
//
//
//            }
//        }
//        JOptionPane.showMessageDialog(null, "Bạn đã lưu thành công !!!");
//        resetManagementSubjectGUI();
//        doSetUp();
//    }
//

//    private void resetTableSubjectSelected() {
//
//        if (subjectSelectedList.size() != 0) {
//            for (int i = 0; i < subjectSelectedList.size(); i++) {
//                subjectSelectedList.remove(i);
//            }
//        }
//        if (subjectSelectedTable != null) {
//            doBindingSubject(subjectSelectedList, subjectSelectedTable, subjectSelectedScrollpane);
//        }
//    }
//
//    private void resetManagementSubjectGUI() {
//        if (null != tab1SubjectList) {
//            for (Subject subject : tab1SubjectList) {
//                tab1SubjectList.remove(subject);
//            }
//        }
//        if (subjectTable != null) {
//            doBindingSubject(tab1SubjectList, subjectTable, subjectScrollpane);
//        }
//
//
//        if (subjectSubjectList != null) {
//            for (int i = 0; i < subjectSubjectList.size(); i++) {
//                subjectSubjectList.remove(i);
//            }
//        }
//        if (tab1SubjectTable != null) {
//            doBindingSubject(subjectSubjectList, tab1SubjectTable, tab1SubjectScrollpane);
//        }
//
//
//        if (subjectSelectedList != null) {
//            for (int i = 0; i < subjectSelectedList.size(); i++) {
//                subjectSelectedList.remove(i);
//            }
//        }
//        if (subjectSelectedTable != null) {
//            doBindingSubject(subjectSelectedList, subjectSelectedTable, subjectSelectedScrollpane);
//        }
//
//
//        managementSubjectGUI.getCbBoxFacultyTab2().removeAllItems();
//        managementSubjectGUI.getComboBoxCourse().removeAllItems();
//        managementSubjectGUI.getCbBoxFacultyTab1().removeAllItems();
//        managementSubjectGUI.getCbBoxFacultyTab2().addItem("Chọn khoa ...");
//        managementSubjectGUI.getCbBoxFacultyTab1().addItem("Chọn khoa ...");
//        managementSubjectGUI.getComboBoxCourse().addItem("Chọn khóa học ...");
//
//    }
}
