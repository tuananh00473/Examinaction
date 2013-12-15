package com.ptit.exam.ui.control.admincontroller;

import com.ptit.exam.business.ExamCardService;
import com.ptit.exam.business.StudentService;
import com.ptit.exam.business.SubjectService;
import com.ptit.exam.business.common.TableBinding;
import com.ptit.exam.business.common.TextAreaEditor;
import com.ptit.exam.business.common.TextAreaRenderer;
import com.ptit.exam.persistence.entity.ExamCard;
import com.ptit.exam.persistence.entity.Student;
import com.ptit.exam.persistence.entity.Subject;
import com.ptit.exam.ui.view.admin.MainAdminGUI;
import com.ptit.exam.ui.view.admin.ManagementSubjectGUI;
import com.ptit.exam.ui.view.admin.NewSubjectGUI;
import com.ptit.exam.util.ComboboxManager;
import com.ptit.exam.util.Constants;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    @Autowired
    ExamCardService examCardService;

    @Autowired
    StudentService studentService;

    private List<Subject> tab1SubjectList;
    private JTable tab1SubjectTable;
    private JScrollPane tab1SubjectScrollPane;

    private List<Subject> tab2SubjectList;
    private JTable tab2SubjectTable;
    private JScrollPane tab2SubjectScrollPane;

    private List<Subject> tab2SubjectListActived;
    private List<Subject> tab2SubjectListActivedBackUp;
    private JTable tab2SubjectTableActived;
    private JScrollPane tab2SubjectScrollPaneActived;

    private ManagementSubjectGUI managementSubjectGUI;
    private NewSubjectGUI newSubjectGUI;


    public void doSetUp() {
        managementSubjectGUI = mainAdminGUI.getManagementSubjectGUI();
        newSubjectGUI = mainAdminGUI.getNewSubjectGUI();

        setUpViewTab1();
        setUpViewTab2();
        setUpActionListenerTab1();
        setUpActionListenerTab2();
    }

    private void setUpViewTab1() {
        tab1SubjectTable = managementSubjectGUI.getTableSubjectTab1();
        tab1SubjectScrollPane = managementSubjectGUI.getScrollPaneSubjectTab1();

        managementSubjectGUI.getCbBoxFacultyTab1().setModel(new DefaultComboBoxModel(Constants.facultyList));

        tab1SubjectList = subjectService.getAll();

        ComboboxManager.setListSubject(managementSubjectGUI.getCbBoxSubjectTab1(), tab1SubjectList);
        doBindingSubject(tab1SubjectList, tab1SubjectTable, tab1SubjectScrollPane);
    }

    public void setUpViewTab2() {
        setUpTab2TableSubject();
        setUpTab2TableSubjectActived();

        managementSubjectGUI.getCbBoxFacultyTab2().setModel(new DefaultComboBoxModel(Constants.facultyList));
        managementSubjectGUI.getCbBoxCourseTab2().setModel(new DefaultComboBoxModel(Constants.courseList));


    }

    private void setUpTab2TableSubject() {
        tab2SubjectTable = managementSubjectGUI.getTableSubjectTab2();
        tab2SubjectScrollPane = managementSubjectGUI.getScrollPanelSubjectTab2();
    }

    private void setUpTab2TableSubjectActived() {
        tab2SubjectTableActived = managementSubjectGUI.getTableSubjectActivedTab2();
        tab2SubjectScrollPaneActived = managementSubjectGUI.getScrollPanelSubjectActivedTab2();
    }

    private void setUpActionListenerTab1() {
        if (GlobalValues.MANAGEMENT_SUBJECT_ADD_ACTION_TAB1) {
            managementSubjectGUI.getBtnAddSUBJECT().addActionListener(actionListenerTab1);
            managementSubjectGUI.getBtnEditSUBJECT().addActionListener(actionListenerTab1);
            managementSubjectGUI.getBtnDelSUBJECT().addActionListener(actionListenerTab1);
            managementSubjectGUI.getBtnSearchTab1().addActionListener(actionListenerTab1);
        }
        GlobalValues.MANAGEMENT_SUBJECT_ADD_ACTION_TAB1 = false;
    }

    public ActionListener actionListenerTab1 = new ActionListener() {
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

    private void doAddSubject() {
        addSubjectController.doSetUp(new Subject());
        newSubjectGUI.resetNewSubjectGUI();
        mainAdminController.doShowNewSubjectCard();
    }

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
        String nameSubject = managementSubjectGUI.getCbBoxSubjectTab1().getSelectedItem().toString();
        String nameFaculty = managementSubjectGUI.getCbBoxFacultyTab1().getSelectedItem().toString();

        List<Subject> list1 = ("".equals(nameSubject) ? subjectService.getAll() : subjectService.findBySubjectName(nameSubject));
        List<Subject> list2 = ("".equals(nameFaculty) ? subjectService.getAll() : subjectService.findByFaculty(nameFaculty));

        tab1SubjectList = new ArrayList<Subject>();
        for (Subject subject : list1) {
            if (list2.contains(subject)) {
                tab1SubjectList.add(subject);
            }
        }
        doBindingSubject(tab1SubjectList, tab1SubjectTable, tab1SubjectScrollPane);
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
                doBindingSubject(tab1SubjectList, tab1SubjectTable, tab1SubjectScrollPane);
            }
        }
    }


    private void setUpActionListenerTab2() {
        if (GlobalValues.MANAGEMENT_SUBJECT_ADD_ACTION_TAB2) {
            managementSubjectGUI.getBtnAdd().addActionListener(actionListenerTab2);
            managementSubjectGUI.getBtnDelete().addActionListener(actionListenerTab2);
            managementSubjectGUI.getBtnSaveTab2().addActionListener(actionListenerTab2);

            managementSubjectGUI.getCbBoxCourseTab2().addItemListener(itemListener);
            managementSubjectGUI.getCbBoxFacultyTab2().addItemListener(itemListener);
        }
        GlobalValues.MANAGEMENT_SUBJECT_ADD_ACTION_TAB2 = false;
    }

    private ActionListener actionListenerTab2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == managementSubjectGUI.getBtnAdd()) {
                addSubjectToActive();
            }
            if (e.getSource() == managementSubjectGUI.getBtnDelete()) {
                removeSubjectToDeActive();
            }
            if (e.getSource() == managementSubjectGUI.getBtnSaveTab2()) {
                activeSubject();
            }
        }
    };

    private void addSubjectToActive() {
        int select = tab2SubjectTable.getSelectedRow();
        if (-1 == select) {
            MessageManager.show("Không có môn học được chọn để kích hoạt thẻ dự thi.");
        } else {
            tab2SubjectListActived.add(tab2SubjectList.get(select));
            doBindingSubject(tab2SubjectListActived, tab2SubjectTableActived, tab2SubjectScrollPaneActived);

            tab2SubjectList.remove(tab2SubjectList.get(select));
            doBindingSubject(tab2SubjectList, tab2SubjectTable, tab2SubjectScrollPane);
        }
    }

    private void removeSubjectToDeActive() {
        int select = tab2SubjectTableActived.getSelectedRow();
        if (-1 == select) {
            MessageManager.show("Không có môn học được chọn để bỏ kích hoạt thẻ dự thi.");
        } else {
            tab2SubjectList.add(tab2SubjectListActived.get(select));
            doBindingSubject(tab2SubjectList, tab2SubjectTable, tab2SubjectScrollPane);

            tab2SubjectListActived.remove(tab2SubjectListActived.get(select));
            doBindingSubject(tab2SubjectListActived, tab2SubjectTableActived, tab2SubjectScrollPaneActived);
        }
    }

    private void activeSubject() {
        List<Student> studentList = studentService.findByCourse(managementSubjectGUI.getCbBoxCourseTab2().getSelectedItem().toString());
        if (studentList.size() <= 0) {
            MessageManager.show("Khóa học không có sinh viên.");
            return;
        }
        if (tab2SubjectListActivedBackUp.size() > 0) {
            for (Subject subject : tab2SubjectListActivedBackUp) {
                if (!tab2SubjectListActived.contains(subject)) {
                    String course = managementSubjectGUI.getCbBoxCourseTab2().getSelectedItem().toString();
                    String faculty = managementSubjectGUI.getCbBoxFacultyTab2().getSelectedItem().toString();
                    examCardService.deActiveSubject(course, faculty, subject.getId());
                }
            }
        }

        for (Subject subject : tab2SubjectListActived) {
            if (!tab2SubjectListActivedBackUp.contains(subject)) {
                for (Student student : studentList) {
                    examCardService.save(new ExamCard(subject.getId(), student.getId()));
                }
            }
        }
        backUpSubjectActivedList();
        MessageManager.show("Kích hoạt thẻ dự thi thành công.");
    }

    private ItemListener itemListener = new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if ((e.getSource() == managementSubjectGUI.getCbBoxFacultyTab2() && !("".equals(managementSubjectGUI.getCbBoxCourseTab2().getSelectedItem().toString())))
                    || (e.getSource() == managementSubjectGUI.getCbBoxCourseTab2() && !("".equals(managementSubjectGUI.getCbBoxFacultyTab2().getSelectedItem().toString())))) {

                String faculty = managementSubjectGUI.getCbBoxFacultyTab2().getSelectedItem().toString();
                String course = managementSubjectGUI.getCbBoxCourseTab2().getSelectedItem().toString();
                tab2SubjectList = subjectService.findByFaculty(faculty);
                tab2SubjectListActived = new ArrayList<Subject>();

                for (Subject subject : tab2SubjectList) {
                    List<Subject> checkList = subjectService.findByCourseAndFaculty(course, faculty, subject.getId());
                    if (checkList.size() > 0) {
                        tab2SubjectListActived.add(subject);
                    }
                }

                for (Subject subject : tab2SubjectListActived) {
                    tab2SubjectList.remove(subject);
                }

                backUpSubjectActivedList();

                doBindingSubject(tab2SubjectListActived, tab2SubjectTableActived, tab2SubjectScrollPaneActived);
                doBindingSubject(tab2SubjectList, tab2SubjectTable, tab2SubjectScrollPane);
            }
        }
    };

    private void doBindingSubject(List<Subject> subjectList, JTable jTable, JScrollPane jScrollPane) {
        Collections.sort(subjectList, new Comparator<Subject>() {
            public int compare(Subject subject1, Subject subject2) {
                return subject1.getId().compareTo(subject2.getId());
            }
        });
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

    private void backUpSubjectActivedList() {
        tab2SubjectListActivedBackUp = new ArrayList<Subject>();
        for (Subject subject : tab2SubjectListActived) {
            tab2SubjectListActivedBackUp.add(subject);
        }
    }
}
