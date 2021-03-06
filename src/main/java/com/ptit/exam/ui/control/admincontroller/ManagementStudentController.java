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
import com.ptit.exam.persistence.modelbinding.ExamCardDTOBinding;
import com.ptit.exam.ui.view.admin.MainAdminGUI;
import com.ptit.exam.ui.view.admin.ManagementStudentGUI;
import com.ptit.exam.ui.view.admin.NewStudentGUI;
import com.ptit.exam.util.ComboboxManager;
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

    @Autowired
    SubjectService subjectService;

    @Autowired
    ExamCardService examCardService;

    private List<Student> tab1StudentList;
    private JTable tab1StudentTable;
    private JScrollPane tab1StudentScrollPane;

    private List<ExamCardDTOBinding> examCardDTOBindingList;
    private List<ExamCard> tab2examCardList;
    private JTable tab2ExamCardTable;
    private JScrollPane tab2ExamCardScrollPane;

    private ManagementStudentGUI managementStudentGUI;
    private NewStudentGUI newStudentGUI;
    private List<Subject> subjectList;

    public void doSetUp()
    {
        setUpView();
        setUpActionListenerTab1();
        setUpActionListenerTab2();

        tab1StudentList = ObservableCollections.observableList(new ArrayList<Student>());
        doBindingStudent(tab1StudentList, tab1StudentTable, tab1StudentScrollPane);
    }

    private void setUpView()
    {
        managementStudentGUI = mainAdminGUI.getManagementStudentGUI();
        newStudentGUI = mainAdminGUI.getNewStudentGUI();

        setUpViewTab1();
        setUpViewTab2();
    }

    private void setUpViewTab1()
    {
        tab1StudentTable = managementStudentGUI.getStudentTableTab1();
        tab1StudentScrollPane = managementStudentGUI.getStudentScrollPanelTab1();

        managementStudentGUI.getComboBoxFacultyTab1().setModel(new DefaultComboBoxModel(Constants.facultyList));
    }

    private void setUpViewTab2()
    {
        tab2ExamCardTable = managementStudentGUI.getExamTableTab2();
        tab2ExamCardScrollPane = managementStudentGUI.getExamScrollPanelTab2();

        subjectList = subjectService.getAll();
        ComboboxManager.setListSubject(managementStudentGUI.getComboBoxSubjectTab2(), subjectList);
        // managementStudentGUI.getComboBoxSubjectTab2().setModel(new DefaultComboBoxModel(Constants.subjects));
    }

    public void setUpActionListenerTab1()
    {
        if (GlobalValues.MANAGEMENT_STUDENT_ADD_ACTION_TAB1)
        {
            managementStudentGUI.getBtnAdd().addActionListener(actionListenerTab1);
            managementStudentGUI.getBtnEdit().addActionListener(actionListenerTab1);
            managementStudentGUI.getBtnDel().addActionListener(actionListenerTab1);
            managementStudentGUI.getBtnSearchTab1().addActionListener(actionListenerTab1);
            GlobalValues.MANAGEMENT_STUDENT_ADD_ACTION_TAB1 = false;
        }
    }

    public void setUpActionListenerTab2()
    {
        if (GlobalValues.MANAGEMENT_STUDENT_ADD_ACTION_TAB2)
        {
            managementStudentGUI.getBtnSaveTab2().addActionListener(actionListenerTab2);
            managementStudentGUI.getBtnSearchTab2().addActionListener(actionListenerTab2);
            GlobalValues.MANAGEMENT_STUDENT_ADD_ACTION_TAB2 = false;
        }
    }

    public ActionListener actionListenerTab1 = new ActionListener()
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
    public ActionListener actionListenerTab2 = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == managementStudentGUI.getBtnSaveTab2())
            {
                doSaveExamCard();
            }
            if (e.getSource() == managementStudentGUI.getBtnSearchTab2())
            {
                doSearchExamCard();
            }
        }
    };

    private void doSaveExamCard()
    {
        for (ExamCardDTOBinding examCardDTOBinding : examCardDTOBindingList)
        {
            ExamCard examCard = examCardService.findById(examCardDTOBinding.getExamId());
            examCard.setCanDoExam(examCardDTOBinding.isCanDoExam());
            examCardService.save(examCard);
        }
    }

    private void doSearchExamCard()
    {
        tab2examCardList = getExamCards();
        doBindingExamCard(tab2examCardList, tab2ExamCardTable, tab2ExamCardScrollPane);
    }

    private List<ExamCard> getExamCards()
    {
        String subjectName = managementStudentGUI.getComboBoxSubjectTab2().getSelectedItem().toString();
        String classRoom = managementStudentGUI.getTxtClassSearchTab2().getText();

        List<ExamCard> list1 = ("".equals(subjectName)) ? examCardService.getAll() : examCardService.findBySubjectName(subjectName);
        List<ExamCard> list2 = ("".equals(classRoom)) ? examCardService.getAll() : examCardService.findByClassRoom(classRoom);
        List<ExamCard> resultList = new ArrayList<ExamCard>();

        for (ExamCard examCard : list1)
        {
            if (list2.contains(examCard))
            {
                resultList.add(examCard);
            }
        }
        return resultList;
    }

    private void doEditStudent()
    {
        int select = tab1StudentTable.getSelectedRow();
        if (-1 == select)
        {
            MessageManager.show("Hãy chọn sinh viên bạn muốn sửa.");
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
        tab1StudentList = getStudentList();
        doBindingStudent(tab1StudentList, tab1StudentTable, tab1StudentScrollPane);
    }

    public List<Student> getStudentList()
    {
        String nameStudent = managementStudentGUI.getTxtNameSearch().getText();
        String classRoom = managementStudentGUI.getTxtClassSearchTab1().getText();
        String faculty = managementStudentGUI.getComboBoxFacultyTab1().getSelectedItem().toString();

        List<Student> list1 = ("".equals(nameStudent) ? studentService.getAll() : studentService.findByName(nameStudent));
        List<Student> list2 = ("".equals(classRoom) ? studentService.getAll() : studentService.findByClassRoom(classRoom));
        List<Student> list3 = studentService.findByFaculty(faculty);
        List<Student> resultList = new ArrayList<Student>();

        for (Student student : list1)
        {
            if (list2.contains(student) && list3.contains(student))
            {
                resultList.add(student);
            }
        }
        return resultList;
    }

    private void doDeleteStudent()
    {
        int rowSelected = tab1StudentTable.getSelectedRow();
        if (-1 == rowSelected)
        {
            MessageManager.show("Hãy chọn sinh viên bạn muốn xóa.");
        }
        else
        {
            int k = MessageManager.showConfirm("Bạn chắc chắn muốn xóa sinh viên này?");
            if (0 == k)
            {
                studentService.delete(tab1StudentList.get(rowSelected));
                tab1StudentList.remove(rowSelected);
                doBindingStudent(tab1StudentList, tab1StudentTable, tab1StudentScrollPane);
            }
        }
    }

    private void doAddStudent()
    {
        addStudentController.doSetUp(new Student());
        newStudentGUI.resetForm();
        mainAdminController.doShowNewStudentCard();
    }

    private void doBindingExamCard(List<ExamCard> examCardList, JTable jTable, JScrollPane jScrollPane)
    {
        examCardDTOBindingList = ObservableCollections.observableList(new ArrayList<ExamCardDTOBinding>());
        for (ExamCard examCard : examCardList)
        {
            Student student = studentService.findById(examCard.getStudentId());
            Subject subject = subjectService.findById(examCard.getSubjectId());

            ExamCardDTOBinding examCardDTOBinding = new ExamCardDTOBinding();

            examCardDTOBinding.setExamId(examCard.getId());
            examCardDTOBinding.setStudentCode(student.getStudentCode());
            examCardDTOBinding.setStudentName(student.getFullName());
            examCardDTOBinding.setFaculty(student.getFaculty());
            examCardDTOBinding.setClassRoom(student.getClassRoom());
            examCardDTOBinding.setNameSubject(subject.getSubjectName());
            examCardDTOBinding.setUnitOfStudy(subject.getUnitOfStudy());
            examCardDTOBinding.setCanDoExam(examCard.isCanDoExam());

            examCardDTOBindingList.add(examCardDTOBinding);
        }

        TableBinding.bindingExamCard(examCardDTOBindingList, jTable, jScrollPane);

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
        cmodel.getColumn(7).setCellEditor(jTable.getDefaultEditor(Boolean.class));
        cmodel.getColumn(7).setCellRenderer(jTable.getDefaultRenderer(Boolean.class));

        JTableHeader header = jTable.getTableHeader();
        header.setPreferredSize(new Dimension(10000, 30));
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable.repaint();
    }

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
//        cmodel.getColumn(10).setCellRenderer(textAreaRenderer);
//        cmodel.getColumn(10).setCellEditor(textEditor);

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
}
