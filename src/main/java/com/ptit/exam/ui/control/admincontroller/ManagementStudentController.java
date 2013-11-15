package com.ptit.exam.ui.control.admincontroller;

import com.ptit.exam.business.StudentService;
import com.ptit.exam.business.common.TableBinding;
import com.ptit.exam.business.common.TextAreaEditor;
import com.ptit.exam.business.common.TextAreaRenderer;
import com.ptit.exam.persistence.entity.Student;
import com.ptit.exam.ui.view.admin.MainAdminGUI;
import com.ptit.exam.ui.view.admin.ManagementStudentGUI;
import com.ptit.exam.ui.view.admin.NewStudentGUI;
import com.ptit.exam.util.Constants;
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
 * Date: 10/23/13
 * Time: 9:45 PM
 */
@Component
public class ManagementStudentController
{
    @Autowired
    MainAdminGUI mainAdminGUI;

    @Autowired
    AddStudentController addStudentController;

    @Autowired
    MainAdminController mainAdminController;

    @Autowired
    StudentService studentService;

    private List<Student> tab1StudentList;
    private JTable tab1StudentTable;
    private JScrollPane tab1StudentScrollpane;

    private ManagementStudentGUI managementStudentGUI;
    private NewStudentGUI newStudentGUI;

    public void doSetUp()
    {
        setUpView();
        setUpActionListener();

        tab1StudentList = studentService.getAll();
        doBindingStudent(tab1StudentList, tab1StudentTable, tab1StudentScrollpane);

//        List<Subject> subjectList = subjectService.getAll();
//        Set<String> stringSet1 = new HashSet<String>();
//        for(Subject subject1 : subjectList){
//            stringSet1.add(subject1.getSubjectName());
//        }
//        for(String s : stringSet1){
//            mainAdminGUI.getManagementStudentGUI().getComboBoxSUBJECT().addItem(s.intern());
//        }
//
//        mainAdminGUI.getManagementStudentGUI().getComboBoxSUBJECT().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(mainAdminGUI.getManagementStudentGUI().getComboBoxSUBJECT().isPopupVisible()){
//                    String nameSubject = mainAdminGUI.getManagementStudentGUI().getComboBoxSUBJECT().getSelectedItem().toString();
//                    Subject subject1 = subjectService.findBySubjectName(nameSubject);
//                    List<Student> studentList1 = studentService.findByFaculty(subject1.getFaculty());
//                    Set<String> stringSet2 = new HashSet<String>();
//                    for(Student student: studentList1){
//                        stringSet2.add(student.getClassRoom());
//                    }
//                }
//            }
//        });
    }

    private void setUpView()
    {
        managementStudentGUI = mainAdminGUI.getManagementStudentGUI();
        newStudentGUI = mainAdminGUI.getNewStudentGUI();

        tab1StudentTable = managementStudentGUI.getStudentTableTab1();
        tab1StudentScrollpane = managementStudentGUI.getStudentScrollpanelTab1();

        mainAdminGUI.getManagementStudentGUI().getComboBoxFacultyTab1().setModel(new DefaultComboBoxModel(Constants.facultyList));
    }

    private void setUpActionListener()
    {
        managementStudentGUI.getBtnAdd().addActionListener(actionListener);
        managementStudentGUI.getBtnEdit().addActionListener(actionListener);
        managementStudentGUI.getBtnDel().addActionListener(actionListener);
        managementStudentGUI.getBtnSearchTab1().addActionListener(actionListener);
    }

    public ActionListener actionListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == managementStudentGUI.getBtnAdd())
            {
                doAddStudent();
            }
            if (e.getSource() == managementStudentGUI.getBtnEdit())
            {
                doEditStudent();
            }
            if (e.getSource() == managementStudentGUI.getBtnDel())
            {
                doDeleteStudent();
            }
            if (e.getSource() == managementStudentGUI.getBtnSearchTab1())
            {
                doSearchStudent();
            }
        }
    };

    private void doEditStudent()
    {
        int select = tab1StudentTable.getSelectedRow();
        if (-1 == select)
        {
            showMessage("Hãy chọn sinh viên bạn muốn sửa.");
        }
        else
        {
            doSetUpStudentGUI(tab1StudentList.get(select));
            mainAdminController.doShowNewStudentCard();
        }

    }

    private void doSetUpStudentGUI(Student student)
    {
        addStudentController.doSetUp(student);
        newStudentGUI.setInfoSubject(student);
    }

    private void doSearchStudent()
    {
        String nameStudent = managementStudentGUI.getTxtNameSearch().getText();
        String classRoom = managementStudentGUI.getTxtClassSearchTab1().getText();
        String faculty = managementStudentGUI.getComboBoxFacultyTab1().getSelectedItem().toString();

        List<Student> list1 = ("".equals(nameStudent) ? studentService.getAll() : studentService.findByName(nameStudent));
        List<Student> list2 = ("".equals(classRoom) ? studentService.getAll() : studentService.findByClassRoom(classRoom));
        List<Student> list3 = ("".equals(faculty) ? studentService.getAll() : studentService.findByFaculty(faculty));

        tab1StudentList = new ArrayList<Student>();
        for (Student student : list1)
        {
            if (list2.contains(student) && list3.contains(student))
            {
                tab1StudentList.add(student);
            }
        }
        doBindingStudent(tab1StudentList, tab1StudentTable, tab1StudentScrollpane);
    }

    private void doDeleteStudent()
    {
        int rowSelected = tab1StudentTable.getSelectedRow();
        if (-1 == rowSelected)
        {
            showMessage("Hãy chọn sinh viên bạn muốn xóa.");
        }
        else
        {
            int k = showConfirmMessage("Bạn chắc chắn muốn xóa sinh viên này?");
            if (0 == k)
            {
                studentService.delete(tab1StudentList.get(rowSelected));
                tab1StudentList.remove(rowSelected);
                doBindingStudent(tab1StudentList, tab1StudentTable, tab1StudentScrollpane);
            }
        }
    }

    private void doAddStudent()
    {
        addStudentController.doSetUp(new Student());
        newStudentGUI.resetForm();
        mainAdminController.doShowNewStudentCard();
    }


    //    private void resetComboBoxSubject() {
//        mainAdminGUI.getManagementStudentGUI().getComboBoxSUBJECT().removeAllItems();
//        mainAdminGUI.getManagementStudentGUI().getComboBoxSUBJECT().addItem("Chọn môn thi ...");
//    }
//
//    private void resetManagementStudentGUI() {
//        if (studentList != null) {
//            for (int i = 0; i < studentList.size(); i++) {
//                studentList.remove(i);
//            }
//        }
//        if (studentTable != null) {
//            doBindingStudent(studentList);
//        }
//
//        if (studentSubjectList != null) {
//            for (int i = 0; i < studentSubjectList.size(); i++) {
//                studentSubjectList.remove(i);
//            }
//        }
//        if (studentSubjectTable != null) {
//            bindingStudentBySubject(studentSubjectList);
//        }
//    }
//
//    public void doSearch() {
//        studentTable = mainAdminGUI.getManagementStudentGUI().getStudentTableTab1();
//
//        studentList = studentService.findByClassRoom(nameClass);
//        if(studentList==null){
//            studentList = ObservableCollections.observableList(new ArrayList<Student>());
//        }
//        doBindingStudent(studentList);
//
//    }
//
    private void doBindingStudent(List<Student> studentList, JTable jTable, JScrollPane jScrollPane)
    {

        TableBinding.bindingStudent(studentList, jTable, jScrollPane);

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
        cmodel.getColumn(5).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(5).setCellEditor(textEditor);
        cmodel.getColumn(6).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(6).setCellEditor(textEditor);
        cmodel.getColumn(7).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(7).setCellEditor(textEditor);
        cmodel.getColumn(8).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(8).setCellEditor(textEditor);
        cmodel.getColumn(9).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(9).setCellEditor(textEditor);
        cmodel.getColumn(10).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(10).setCellEditor(textEditor);
        JTableHeader header = jTable.getTableHeader();
        header.setPreferredSize(new Dimension(10000, 30));
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable.repaint();
    }

//    public void doSEARCH() {
//        studentSubjectList = ObservableCollections.observableList(new ArrayList<StudentSubject>());
//        studentSubjectTable = mainAdminGUI.getManagementStudentGUI().getStudentSubjetTable();
//        String nameSubject = mainAdminGUI.getManagementStudentGUI().getComboBoxSUBJECT().getSelectedItem().toString();
//
//        Subject subject1 = subjectService.findBySubjectName(nameSubject);
//        List<Student> studentList1 = studentService.findByClassRoom(nameClass);
//
//       for(Student student : studentList1){
//           StudentSubject studentSubject = studentSubjectService.findByStudentSubject(student, subject1);
//           if(null!=studentSubject){
//               studentSubjectList.add(studentSubject);
//
//           }
//       }
//
//        bindingStudentBySubject(studentSubjectList);
//
//    }
//
//    private void bindingStudentBySubject(List<StudentSubject> studentSubjectList) {
//        TableBinding.bindingStudentBySubject(studentSubjectList, studentSubjectTable, mainAdminGUI.getManagementStudentGUI().getStudentSubjectScrollpanel());
//
//        TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
//        TextAreaEditor textEditor = new TextAreaEditor();
//        TableColumnModel cmodel = studentSubjectTable.getColumnModel();
//        cmodel.getColumn(0).setCellRenderer(textAreaRenderer);
//        cmodel.getColumn(0).setCellEditor(textEditor);
//        cmodel.getColumn(1).setCellRenderer(textAreaRenderer);
//        cmodel.getColumn(1).setCellEditor(textEditor);
//        cmodel.getColumn(2).setCellRenderer(textAreaRenderer);
//        cmodel.getColumn(2).setCellEditor(textEditor);
//        cmodel.getColumn(3).setCellEditor(studentSubjectTable.getDefaultEditor(Boolean.class));
//        cmodel.getColumn(3).setCellRenderer(studentSubjectTable.getDefaultRenderer(Boolean.class));
//        JTableHeader header = studentSubjectTable.getTableHeader();
//        header.setPreferredSize(new Dimension(10000, 30));
//        studentSubjectTable.getTableHeader().setReorderingAllowed(false);
//        studentSubjectTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        studentSubjectTable.repaint();
//    }
//
//    public void doSAVE() {
//        for(StudentSubject studentSubject : studentSubjectList){
//            studentSubjectService.save(studentSubject);
//        }
//        JOptionPane.showMessageDialog(null,"Lưu thành công !");
//        resetManagementStudentGUI();
//        doSetUp();
//    }

    private void showMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }

    private int showConfirmMessage(String message)
    {
        return JOptionPane.showConfirmDialog(null, message);
    }
}
