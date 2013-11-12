package com.ptit.exam.ui.control;

import org.springframework.stereotype.Component;

/**
 * User: thuongntt
 * Date: 10/23/13
 * Time: 9:45 PM
 */
@Component
public class ManagementStudentController {
//    @Autowired
//    MainAdminGUI mainAdminGUI;
//    @Autowired
//    StudentService studentService;
//    @Autowired
//    NewStudentGUI newStudentGUI;
//    @Autowired
//    SubjectService subjectService;
//    @Autowired
//    StudentSubjectService studentSubjectService;
//
//    private List<Student> studentList;
//    private List<StudentSubject> studentSubjectList;
//    private JTable studentTable;
//    private JTable studentSubjectTable;
//    private Student student1;
//
//
//
//
//
//
//    public void doSetUp() {
//        mainAdminGUI.getManagementStudentGUI().getStudentTab().addChangeListener(new ChangeListener() {
//            @Override
//            public void stateChanged(ChangeEvent e) {
//                JTabbedPane activeTabbed = (JTabbedPane) e.getSource();
//            }
//        });
//        resetManagementStudentGUI();
//        resetComboBoxSubject();
//
//        mainAdminGUI.getManagementStudentGUI().getCbBoxFacultyTab2().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(mainAdminGUI.getManagementStudentGUI().getCbBoxFacultyTab2().isPopupVisible()){
//                    resetComboBoxClass();
//                    String faculty = mainAdminGUI.getManagementStudentGUI().getCbBoxFacultyTab2().getSelectedItem().toString();
//                    List<Student> studentList1 = studentService.findByFaculty(faculty);
//                    Set<String> stringSet = new HashSet<String>();
//                    for(Student student1: studentList1){
//                        stringSet.add(student1.getClassRoom());
//                    }
//                    for (String s: stringSet){
//                        mainAdminGUI.getManagementStudentGUI().getComboBoxClass().addItem(s.intern());
//                    }
//                }
//            }
//        });
//
//       List<Subject>  subjectList = subjectService.getAll();
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
//                    resetComboBoxClass2();
//                    String nameSubject = mainAdminGUI.getManagementStudentGUI().getComboBoxSUBJECT().getSelectedItem().toString();
//                    Subject subject1 = subjectService.findBySubjectName(nameSubject);
//                    List<Student> studentList1 = studentService.findByFaculty(subject1.getFaculty());
//                    Set<String> stringSet2 = new HashSet<String>();
//                    for(Student student: studentList1){
//                        stringSet2.add(student.getClassRoom());
//                    }
//
//                    for(String s: stringSet2){
//                        mainAdminGUI.getManagementStudentGUI().getComboBoxCLASS().addItem(s.intern());
//                    }
//                }
//            }
//        });
//
//    }
//
//    private void resetComboBoxClass2() {
//        mainAdminGUI.getManagementStudentGUI().getComboBoxCLASS().removeAllItems();
//        mainAdminGUI.getManagementStudentGUI().getComboBoxCLASS().addItem("Chọn lớp ...");
//    }
//
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
//            bindingStudentTable(studentList);
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
//
//    }
//
//    private void resetComboBoxClass() {
//        mainAdminGUI.getManagementStudentGUI().getComboBoxClass().removeAllItems();
//        mainAdminGUI.getManagementStudentGUI().getComboBoxClass().addItem("Chọn lớp ...");
//       // mainAdminGUI.getManagementStudentGUI().getCbBoxFacultyTab2().addItem("Chọn khoa ...");
//    }
//
//    public void doSearch() {
//        studentTable = mainAdminGUI.getManagementStudentGUI().getStudentTable();
//
//      String nameClass = mainAdminGUI.getManagementStudentGUI().getComboBoxClass().getSelectedItem().toString();
//        studentList = studentService.findByClassRoom(nameClass);
//        if(studentList==null){
//            studentList = ObservableCollections.observableList(new ArrayList<Student>());
//        }
//        bindingStudentTable(studentList);
//
//    }
//
//    private void bindingStudentTable(List<Student> studentList) {
//
//        TableBinding.bindingStudent(studentList, studentTable, mainAdminGUI.getManagementStudentGUI().getStudentScrollpanel());
//
//        TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
//        TextAreaEditor textEditor = new TextAreaEditor();
//        TableColumnModel cmodel = studentTable.getColumnModel();
//        cmodel.getColumn(0).setCellRenderer(textAreaRenderer);
//        cmodel.getColumn(0).setCellEditor(textEditor);
//        cmodel.getColumn(1).setCellRenderer(textAreaRenderer);
//        cmodel.getColumn(1).setCellEditor(textEditor);
//        cmodel.getColumn(2).setCellRenderer(textAreaRenderer);
//        cmodel.getColumn(2).setCellEditor(textEditor);
//        cmodel.getColumn(3).setCellRenderer(textAreaRenderer);
//        cmodel.getColumn(3).setCellEditor(textEditor);
//        JTableHeader header = studentTable.getTableHeader();
//        header.setPreferredSize(new Dimension(10000, 30));
//        studentTable.getTableHeader().setReorderingAllowed(false);
//        studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        studentTable.repaint();
//    }
//
//    public void doSaveAddStudent() {
//        String firstName = newStudentGUI.getTxtFirstname().getText();
//        String lastName = newStudentGUI.getTxtLastname().getText();
//        String studentCode = newStudentGUI.getTxtStudentCode().getText();
//        String gender = newStudentGUI.getBtnRadioMale().isSelected()? "Male" : "Female";
//        String dateOfBirth = newStudentGUI.getComboBoxDay().getSelectedItem().toString() + "/"+ newStudentGUI.getComboBoxMonth().getSelectedItem().toString() + "/"+ newStudentGUI.getComboBoxYear().getSelectedItem().toString();
//        String classRoom = newStudentGUI.getTxtClass().getText();
//        String faculty = newStudentGUI.getCbBoxFacultyTab2().getSelectedItem().toString();
//        String course = newStudentGUI.getComboBoxCourse().getSelectedItem().toString();
//        String trainingSystem = newStudentGUI.getComboBoxTrainingSystem().getSelectedItem().toString();
//        String username = newStudentGUI.getTxtUsername().getText();
//        String password = newStudentGUI.getTxtPassword().getText();
//        String confirmPassword = newStudentGUI.getTxtConfirmPassword().getText();
//
//        if(firstName.isEmpty()|| lastName.isEmpty()||studentCode.isEmpty()|| classRoom.isEmpty()||course.isEmpty()|| username.isEmpty() || password.isEmpty()|| confirmPassword.isEmpty()){
//            doValidateStudentGUI();
//        }else {
//            Student student1 = studentService.findByStudentCode(studentCode);
//            if(student1==null){
//                Student student2 = studentService.findByUserName(username);
//
//                if(student2==null){
//                    if(password.equals(confirmPassword)){
//                        Student student = new Student(firstName,lastName,gender,dateOfBirth,studentCode,classRoom,faculty,course,trainingSystem,username,password);
//                        studentList.add(student);
//                        studentService.save(student);
//                        bindingStudentTable(studentList);
//                        JOptionPane.showMessageDialog(null,"You registry SUCCESS !!! !!!");
//
//
//                    }   else {
//                        JOptionPane.showMessageDialog(null,"Error password !!!");
//                    }
//                }  else {
//                    JOptionPane.showMessageDialog(null,"Username da ton tai, thay username khac");
//                }
//
//            } else {
//                JOptionPane.showMessageDialog(null,"Sinh vien da co tai khoan");
//            }
//        }
//
//    }
//    private void doValidateStudentGUI() {
//        newStudentGUI.getLbValidateFistname().setText("(*)");
//        newStudentGUI.getLbValidateLastname().setText("(*)");
//        newStudentGUI.getLbValidateStudentCode().setText("(*)");
//        newStudentGUI.getLbValidateClass().setText("(*)");
//        newStudentGUI.getLbValidateCourse().setText("(*)");
//        newStudentGUI.getLbValidateUsername().setText("(*)");
//        newStudentGUI.getLbValidatePassword().setText("(*)");
//        newStudentGUI.getLbValidateConfirmPassword().setText("(*)");
//        newStudentGUI.getLbNote().setText("(*): Can phai nhap dau du");
//    }
//
//    public void doDelete() {
//        int index = mainAdminGUI.getManagementStudentGUI().getStudentTable().getSelectedRow();
//        if(index!= -1){
//           Student student1 = studentList.get(index);
//            studentList.remove(student1);
//            studentService.delete(student1);
//            JOptionPane.showMessageDialog(null,"Xóa thành công !");
//            bindingStudentTable(studentList);
//        } else {
//            JOptionPane.showMessageDialog(null,"Bạn cần chọn 1 sinh viên muốn xóa !");
//        }
//    }
//
//    public void doEdit() {
//       int index = mainAdminGUI.getManagementStudentGUI().getStudentTable().getSelectedRow();
//        if(index!= -1){
//             student1 = studentList.get(index);
//            mainAdminGUI.getEditStudentGUI().getTxtFirstname().setText(student1.getFirstName());
//            mainAdminGUI.getEditStudentGUI().getTxtLastname().setText(student1.getLastName());
//            mainAdminGUI.getEditStudentGUI().getTxtClass().setText(student1.getClassRoom());
//            mainAdminGUI.getEditStudentGUI().getTxtStudentCode().setText(student1.getStudentCode());
//            mainAdminGUI.getEditStudentGUI().getTxtDateOfBirth().setText(student1.getDateOfBirth());
//
//            if(student1.getGender().equals("Male")){
//                mainAdminGUI.getEditStudentGUI().getBtnRadioMale().setSelected(true);
//            } else {
//                mainAdminGUI.getEditStudentGUI().getBtnRadioMale().setSelected(false) ;
//            }
//            mainAdminGUI.getEditStudentGUI().getCbBoxFacultyTab2().setSelectedItem(student1.getFaculty());
//            mainAdminGUI.getEditStudentGUI().getComboBoxCourse().setSelectedItem(student1.getCourse());
//            mainAdminGUI.getEditStudentGUI().getComboBoxTrainingSystem().setSelectedItem(student1.getTrainingSystem());
//        } else {
//            JOptionPane.showMessageDialog(null,"Bạn cần chọn 1 sinh viên muốn sửa !");
//        }
//    }
//
//    public void doSaveEditStudent() {
//       student1.setFirstName(mainAdminGUI.getEditStudentGUI().getTxtFirstname().getText());
//        student1.setLastName(mainAdminGUI.getEditStudentGUI().getTxtLastname().getText());
//        student1.setClassRoom(mainAdminGUI.getEditStudentGUI().getTxtClass().getText());
//        student1.setStudentCode(mainAdminGUI.getEditStudentGUI().getTxtStudentCode().getText());
//        student1.setDateOfBirth(mainAdminGUI.getEditStudentGUI().getTxtDateOfBirth().getText());
//        student1.setGender(mainAdminGUI.getEditStudentGUI().getBtnRadioMale().isSelected() ? "Male" : "Female");
//        student1.setFaculty(mainAdminGUI.getEditStudentGUI().getCbBoxFacultyTab2().getSelectedItem().toString());
//        student1.setCourse(mainAdminGUI.getEditStudentGUI().getComboBoxCourse().getSelectedItem().toString());
//        student1.setTrainingSystem(mainAdminGUI.getEditStudentGUI().getComboBoxTrainingSystem().getSelectedItem().toString());
//
//        studentService.save(student1);
//        bindingStudentTable(studentList);
//        JOptionPane.showMessageDialog(null,"Bạn đã sửa thàng công !");
//    }
//
//    public void doSEARCH() {
//        studentSubjectList = ObservableCollections.observableList(new ArrayList<StudentSubject>());
//        studentSubjectTable = mainAdminGUI.getManagementStudentGUI().getStudentSubjetTable();
//        String nameSubject = mainAdminGUI.getManagementStudentGUI().getComboBoxSUBJECT().getSelectedItem().toString();
//        String nameClass = mainAdminGUI.getManagementStudentGUI().getComboBoxCLASS().getSelectedItem().toString();
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
