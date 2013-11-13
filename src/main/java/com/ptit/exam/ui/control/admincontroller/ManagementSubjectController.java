package com.ptit.exam.ui.control.admincontroller;

import com.ptit.exam.business.StudentService;
import com.ptit.exam.business.SubjectService;
import com.ptit.exam.business.common.TableBinding;
import com.ptit.exam.business.common.TextAreaEditor;
import com.ptit.exam.business.common.TextAreaRenderer;
import com.ptit.exam.persistence.entity.Subject;
import com.ptit.exam.ui.view.admin.MainAdminGUI;
import com.ptit.exam.ui.view.admin.ManagementSubjectGUI;
import com.ptit.exam.ui.view.admin.NewSubjectGUI;
import com.ptit.exam.util.Constants;
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
 * Time: 4:50 PM
 */
@Component
public class ManagementSubjectController
{

    @Autowired
    MainAdminGUI mainAdminGUI;

    @Autowired
    SubjectService subjectService;

    @Autowired
    StudentService studentService;

    @Autowired
    NewSubjectGUI newSubjectGUI;

    @Autowired
    MainAdminController mainAdminController;

    private List<Subject> tab1SubjectList;
    private JTable tab1SubjectTable;
    private JScrollPane tab1SubjectScrollpane;

    private ManagementSubjectGUI managementSubjectGUI;

    public void doSetUp()
    {
        setUpView();
        setUpActionListener();

        tab1SubjectList = subjectService.getAll();
        doBindingSubject(tab1SubjectList, tab1SubjectTable, tab1SubjectScrollpane);
    }

    private void setUpActionListener()
    {
        managementSubjectGUI.getBtnAddSUBJECT().addActionListener(actionListener);
        managementSubjectGUI.getBtnDelSUBJECT().addActionListener(actionListener);
        managementSubjectGUI.getBtnSaveTab1().addActionListener(actionListener);
        managementSubjectGUI.getBtnSearchTab1().addActionListener(actionListener);
    }

    private void setUpView()
    {
        managementSubjectGUI = mainAdminGUI.getManagementSubjectGUI();

        tab1SubjectTable = managementSubjectGUI.getTableSUBJECT();
        tab1SubjectScrollpane = managementSubjectGUI.getScrollPaneSUBJECT();
        managementSubjectGUI.getCbBoxFacultyTab1().setModel(new DefaultComboBoxModel(Constants.facultyList));

        managementSubjectGUI.getCbBoxFacultyTab2().setModel(new DefaultComboBoxModel(Constants.facultyList));
        managementSubjectGUI.getComboBoxCourse().setModel(new DefaultComboBoxModel(Constants.courseList));
    }

    public ActionListener actionListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == managementSubjectGUI.getBtnAddSUBJECT())
            {
                doAddSubject();
            }
            if (e.getSource() == managementSubjectGUI.getBtnDelSUBJECT())
            {
                doDeleteSubject();
            }
            if (e.getSource() == managementSubjectGUI.getBtnSaveTab1())
            {
                doSaveTab1();
            }
            if (e.getSource() == managementSubjectGUI.getBtnSearchTab1())
            {
                doSearchTab1();
            }
        }
    };

    private void doSearchTab1()
    {
        String nameSubject = managementSubjectGUI.getTxtNameSubjectSearch().getText();
        String nameFaculty = managementSubjectGUI.getCbBoxFacultyTab1().getSelectedItem().toString();
        if ("".equals(nameSubject))
        {
            tab1SubjectList = subjectService.findByFaculty(nameFaculty);
            doBindingSubject(tab1SubjectList, tab1SubjectTable, tab1SubjectScrollpane);
        }
        else
        {
            tab1SubjectList = subjectService.findByFacultyAndNameSubject(nameFaculty, nameSubject);
            doBindingSubject(tab1SubjectList, tab1SubjectTable, tab1SubjectScrollpane);
        }
    }

    private void doSaveTab1()
    {
        stopEditing(tab1SubjectTable);
        boolean saveSuccess = true;
        for (int i = 0; i < tab1SubjectList.size(); i++)
        {
            if (tab1SubjectList.get(i).inValid())
            {
                showMessage("Hãy nhập đủ thông tin vào dòng " + ++i);
                saveSuccess = false;
                break;
            }
            subjectService.save(tab1SubjectList.get(i));
        }
        if (saveSuccess)
        {
            showMessage("Lưu dữ liệu thành công!");
        }
    }

    private void doDeleteSubject()
    {
        int rowSelected = tab1SubjectTable.getSelectedRow();
        if (-1 == rowSelected)
        {
            showMessage("Cần chọn một môn học để thực hiện xóa.");
        }
        else
        {
            int k = showConfirmMessage("Bạn chắc chắn muốn xóa môn học này?");
            if (0 == k)
            {
                subjectService.delete(tab1SubjectList.get(rowSelected));
                tab1SubjectList.remove(rowSelected);
                doBindingSubject(tab1SubjectList, tab1SubjectTable, tab1SubjectScrollpane);
            }
        }
    }

    private void doAddSubject()
    {
        tab1SubjectList.add(new Subject());
        doBindingSubject(tab1SubjectList, tab1SubjectTable, tab1SubjectScrollpane);
    }

    private void resetComboBoxCourse()
    {
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


    private void doBindingSubject(List<Subject> subjectList, JTable jTable, JScrollPane jScrollPane)
    {
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
    //===================================================

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
//        doBindingSubject(subjectSubjectList, tab1SubjectTable, tab1SubjectScrollpane);
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
//        doBindingSubject(subjectSubjectList, tab1SubjectTable, tab1SubjectScrollpane);
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
//            doBindingSubject(subjectSubjectList, tab1SubjectTable, tab1SubjectScrollpane);
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
//

    public void stopEditing(JTable table)
    {
        if (table.isEditing())
        {
            table.getCellEditor().stopCellEditing();
        }
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
