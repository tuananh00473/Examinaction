package com.ptit.exam.ui.control;

import com.ptit.exam.business.StudentService;
import com.ptit.exam.business.SubjectService;
import com.ptit.exam.business.common.TableBinding;
import com.ptit.exam.business.common.TextAreaEditor;
import com.ptit.exam.business.common.TextAreaRenderer;
import com.ptit.exam.persistence.entity.Subject;
import com.ptit.exam.ui.control.admincontroller.MainAdminController;
import com.ptit.exam.ui.view.admin.MainAdminGUI;
import com.ptit.exam.ui.view.admin.ManagementSubjectGUI;
import com.ptit.exam.ui.view.admin.NewSubjectGUI;
import org.jdesktop.observablecollections.ObservableCollections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    StudentService studentService;

    @Autowired
    NewSubjectGUI newSubjectGUI;
    //
    @Autowired
    MainAdminController mainAdminController;
    //
    private List<Subject> subjectList;
//    private List<Subject> subjectSelectedList;

    private List<Subject> subjectSubjectList;
    private JTable subjectSubjectTable;
    private JScrollPane subjectSubjectScrollpane;

    private Set<String> stringSet = new HashSet<String>();
//    private String nameFaculty;
//    private String nameCourse;
//    private JTable subjectSelectedTable;

//    private JTable subjectTable;
//    private Subject subject;
//    private JScrollPane subjectScrollpane;

    //    private JScrollPane subjectSelectedScrollpane;
//    private List<Student> studentList;
//    private Subject currentSubject;
//    private List<StudentSubject> studentSubjectList;
//
    private ManagementSubjectGUI managementSubjectGUI;

    //
    public void doSetUp() {
//
//        mainAdminGUI.getManagementSubjectGUI().getTabbedPane().addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                //stopEditting();
//                JTabbedPane activeTabbed = (JTabbedPane) e.getSource();
//            }
//        });
//
        managementSubjectGUI = mainAdminGUI.getManagementSubjectGUI();
//        resetManagementSubjectGUI();
        List<Subject> subjectList1 = subjectService.getAll();
        for (Subject subject : subjectList1) {
            stringSet.add(subject.getFaculty());
        }
        for (String s : stringSet) {
            managementSubjectGUI.getCbBoxFacultyTab1().addItem(s.intern());
            managementSubjectGUI.getCbBoxFacultyTab2().addItem(s.intern());
        }

//        managementSubjectGUI.getCbBoxFacultyTab2().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if( managementSubjectGUI.getCbBoxFacultyTab2().isPopupVisible()){
//                    resetComboBoxCourse();
//                    Set<String> stringSet1 = new HashSet<String>();
//                    List<Student> studentList = studentService.findByFaculty(managementSubjectGUI.getCbBoxFacultyTab2().getSelectedItem().toString());
//                    for (Student student : studentList) {
//                        stringSet1.add(student.getCourse());
//                    }
//                    for (String s : stringSet1) {
//                        managementSubjectGUI.getComboBoxCourse().addItem(s.intern());
//                    }
//                }
//            }
//        });
    }

    private void resetComboBoxCourse() {
        managementSubjectGUI.getComboBoxCourse().removeAllItems();
        managementSubjectGUI.getComboBoxCourse().addItem("Chọn khóa ...");
    }


//    public void doSearch() {
//
//        Set<Subject> subjectSet = new HashSet<Subject>();
//        managementSubjectGUI = mainAdminGUI.getManagementSubjectGUI();
//        nameFaculty = managementSubjectGUI.getCbBoxFacultyTab2().getSelectedItem().toString();
//        nameCourse = managementSubjectGUI.getComboBoxCourse().getSelectedItem().toString();
//
//        subjectList = ObservableCollections.observableList(subjectService.findByFaculty(nameFaculty));
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
//            for (Subject subject1 : subjectList) {
//                if (subject1.getId().equals(subject.getId())) {
//                    subjectList.remove(subject1);
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
//        doBindingSubject(subjectList, subjectTable, subjectScrollpane);
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
        TableColumnModel cmodel = jTable.getColumnModel();
        cmodel.getColumn(0).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(0).setCellEditor(textEditor);
        cmodel.getColumn(1).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(1).setCellEditor(textEditor);
        cmodel.getColumn(2).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(2).setCellEditor(textEditor);
        cmodel.getColumn(3).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(3).setCellEditor(textEditor);
        JTableHeader header = jTable.getTableHeader();
        header.setPreferredSize(new Dimension(10000, 30));
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable.repaint();
    }
//
//    public void doAdd() {
//        managementSubjectGUI = mainAdminGUI.getManagementSubjectGUI();
//
//        int index = managementSubjectGUI.getSubjectTable().getSelectedRow();
//        if (index != -1) {
//            subject = subjectList.get(index);
//            subjectList.remove(subject);
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
//            subjectList.add(subject);
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
    //===================================================

    public void doSearchSubject() {
        managementSubjectGUI = mainAdminGUI.getManagementSubjectGUI();
        String nameFaculty = managementSubjectGUI.getCbBoxFacultyTab1().getSelectedItem().toString();

        subjectSubjectList = ObservableCollections.observableList(subjectService.findByFaculty(nameFaculty));
        subjectSubjectTable = managementSubjectGUI.getTableSUBJECT();
        subjectSubjectScrollpane = managementSubjectGUI.getScrollPaneSUBJECT();
        doBindingSubject(subjectSubjectList, subjectSubjectTable, subjectSubjectScrollpane);

    }

//    public void doSaveNewSubject() {
//
//        String nameSubject = newSubjectGUI.getTxtSubjectName().getText();
//        String codeSubject = newSubjectGUI.getTxtSubjectCode().getText();
//        String faculty = newSubjectGUI.getCbBoxFacultyTab2().getSelectedItem().toString();
//        Long unitStudy = Long.parseLong(newSubjectGUI.getComboBoxUnitStudy().getSelectedItem().toString());
//        String desc = newSubjectGUI.getTxtDescription().getText();
//        Subject subject1 = subjectService.save(new Subject(codeSubject, nameSubject, faculty, unitStudy, desc));
//        subjectSubjectList.add(subject1);
//        subjectService.save(subject1);
//        if (subject1 != null) {
//
//            JOptionPane.showMessageDialog(null, "Thêm môn thi thành công");
//        }
//        doBindingSubject(subjectSubjectList, subjectSubjectTable, subjectSubjectScrollpane);
//
//        newSubjectGUI.setVisible(false);
//    }
//
//    public void doEditSubject() {
//        int index = mainAdminGUI.getManagementSubjectGUI().getTableSUBJECT().getSelectedRow();
//        if (index != -1) {
//            mainAdminController.doShowEditSubjectGUI();
//            currentSubject = subjectSubjectList.get(index);
//            mainAdminGUI.getEditSubjectGUI().getTxtSubjectName().setText(currentSubject.getSubjectName());
//            mainAdminGUI.getEditSubjectGUI().getTxtSubjectCode().setText(currentSubject.getSubjectCode());
//            mainAdminGUI.getEditSubjectGUI().getTxtDesc().setText(currentSubject.getSubjectDesc());
//            mainAdminGUI.getEditSubjectGUI().getCbBoxFacultyTab2().setSelectedItem(currentSubject.getFaculty());
//            mainAdminGUI.getEditSubjectGUI().getComboBoxUnitStudy().setSelectedItem(currentSubject.getUnitOfStudy().toString());
//        } else {
//            JOptionPane.showMessageDialog(null, "Bạn cần chọn 1 môn thi !");
//        }
//
//    }
//
//
//    public void doSaveEditSubject() {
//        currentSubject.setSubjectCode(mainAdminGUI.getEditSubjectGUI().getTxtSubjectCode().getText());
//        currentSubject.setSubjectName(mainAdminGUI.getEditSubjectGUI().getTxtSubjectName().getText());
//        currentSubject.setFaculty(mainAdminGUI.getEditSubjectGUI().getCbBoxFacultyTab2().getSelectedItem().toString());
//        currentSubject.setUnitOfStudy(Long.parseLong(mainAdminGUI.getEditSubjectGUI().getComboBoxUnitStudy().getSelectedItem().toString()));
//        currentSubject.setSubjectDesc(mainAdminGUI.getEditSubjectGUI().getTxtDesc().getText());
//
//        subjectService.save(currentSubject);
//        doBindingSubject(subjectSubjectList, subjectSubjectTable, subjectSubjectScrollpane);
//
//    }
//
//    public void doDelSubject() {
//
//        int index = mainAdminGUI.getManagementSubjectGUI().getTableSUBJECT().getSelectedRow();
//        if (index != -1) {
//            Subject subject1 = subjectSubjectList.get(index);
//            subjectSubjectList.remove(index);
//            subjectService.delete(subject1);
//            doBindingSubject(subjectSubjectList, subjectSubjectTable, subjectSubjectScrollpane);
//        } else {
//            JOptionPane.showMessageDialog(null, "Bạn cần chọn 1 môn thi !");
//        }
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
//        if (null != subjectList) {
//            for (Subject subject : subjectList) {
//                subjectList.remove(subject);
//            }
//        }
//        if (subjectTable != null) {
//            doBindingSubject(subjectList, subjectTable, subjectScrollpane);
//        }
//
//
//        if (subjectSubjectList != null) {
//            for (int i = 0; i < subjectSubjectList.size(); i++) {
//                subjectSubjectList.remove(i);
//            }
//        }
//        if (subjectSubjectTable != null) {
//            doBindingSubject(subjectSubjectList, subjectSubjectTable, subjectSubjectScrollpane);
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
//
}
