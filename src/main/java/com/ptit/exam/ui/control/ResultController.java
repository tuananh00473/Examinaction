package com.ptit.exam.ui.control;

import org.springframework.stereotype.Component;

/**
 * User: thuongntt
 * Date: 10/20/13
 * Time: 4:54 PM
 */
@Component
public class ResultController {
//    @Autowired
//    MainStudentGUI mainStudentGUI;
//    @Autowired
//    SubjectService subjectService;
//    @Autowired
//    ExamService examService;
//    @Autowired
//    StudentService studentService;
//    @Autowired
//    LoginGUI loginGUI;
//    @Autowired
//    ExamCardService resultService;
//
//    private List<ExamCard> resultList;
//    private JTable resultTable;
//    private List<Subject> subjectList;
//    private List<Exam> examList;
//    private Set<String> stringSet = new HashSet<String>();
//    private String nameFaculty;
//    private String nameSubject;
//    private String nameExamination;
//    private String nameClass;
//    private Student student;
//
//
//
//    public void setUpResultGUI(){
//        resetResultGUI();
//        resetComboBoxFaculty();
//        resetComboBoxClass();
//        resetComboBoxSubject();
//        resetComboBoxExamination();
//        subjectList = subjectService.getAll();
//        for(Subject subject: subjectList){
//            stringSet.add(subject.getFaculty());
//        }
//        for(String s : stringSet){
//            mainStudentGUI.getResultGUI().getCbBoxFacultyTab2().addItem(s.intern());
//        }
//
//        mainStudentGUI.getResultGUI().getCbBoxFacultyTab2().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (mainStudentGUI.getResultGUI().getCbBoxFacultyTab2().isPopupVisible()) {
//                    resetComboBoxSubject();
//                    resetComboBoxClass();
//                    nameFaculty = mainStudentGUI.getResultGUI().getCbBoxFacultyTab2().getSelectedItem().toString();
//                    doAddContentComboBoxSubject(nameFaculty);
//                    doAddContentComboBoxClass(nameFaculty);
//                }
//            }
//        });
//        student = studentService.findByUserNameAndPassWord(loginGUI.getStudentInfo().getUserName(), loginGUI.getStudentInfo().getPassWord());
//
//        mainStudentGUI.getResultGUI().getComboBoxSubject().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Set<String> stringSet1 = new HashSet<String>();
//
//                if (mainStudentGUI.getResultGUI().getComboBoxSubject().isPopupVisible()) {
//
//                    resetComboBoxExamination();
//                    nameSubject = mainStudentGUI.getResultGUI().getComboBoxSubject().getSelectedItem().toString();
//                    Subject subject = subjectService.findBySubjectName(nameSubject);
//                    examList = examService.findBySubjectRelationExam(subject);
//
//                    if (!examList.isEmpty()) {
//
//                        for (Exam exam : examList) {
//                            stringSet1.add(exam.getExamName());
//                        }
//
//                        for (String s : stringSet1) {
//                            mainStudentGUI.getResultGUI().getComboBoxExamination().addItem(s.intern());
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(null, "ko co de thi");
//                    }
//
//                }
//            }
//        });
//
//        // add du lieu vao comboBox Class
//
//
//        List<Student> studentList = studentService.findByFaculty(mainStudentGUI.getResultGUI().getCbBoxFacultyTab2().getSelectedItem().toString());
//        Set<String> stringSet2 = new HashSet<String>();
//        for (Student student1 : studentList) {
//            stringSet2.add(student1.getClassRoom());
//        }
//
//        for (String s : stringSet2) {
//            mainStudentGUI.getResultGUI().getComboBoxClass().addItem(s.intern());
//        }
//
//
//
//    }
//
//    private void resetResultGUI() {
//        if(resultList!=null){
//            for(int i = 0; i< resultList.size();i++){
//                resultList.remove(i);
//            }
//
//        }
//
//
//        if(resultTable!=null){
//            doBindingMark(resultList);
//        }
//
//        mainStudentGUI.getSettingExamGUI().getComboBoxSubject().removeAllItems();
//    }
//
//    private void doAddContentComboBoxSubject(String nameFaculty) {
//
//
//
//        List<Subject> subjects = subjectService.findByFaculty(nameFaculty);
//        Set<String> nameSubjectList = new HashSet<String>();
//
//        for (Subject subject : subjects) {
//            nameSubjectList.add((subject.getSubjectName()));
//        }
//        for (String s : nameSubjectList) {
//            mainStudentGUI.getResultGUI().getComboBoxSubject().addItem(s.intern());
//        }
//    }
//    private void doAddContentComboBoxClass(String nameFaculty) {
//
//        List<Student> studentList = studentService.findByFaculty(nameFaculty);
//
//        Set<String> stringSet2 = new HashSet<String>();
//        for (Student student1 : studentList) {
//            stringSet2.add(student1.getClassRoom());
//        }
//
//        for (String s : stringSet2) {
//            mainStudentGUI.getResultGUI().getComboBoxClass().addItem(s.intern());
//        }
//    }
//    private void resetComboBoxClass() {
//        mainStudentGUI.getResultGUI().getComboBoxClass().removeAllItems();
//        mainStudentGUI.getResultGUI().getComboBoxClass().addItem("Choose class ...");
//    }
//
//    private void resetComboBoxFaculty() {
//        mainStudentGUI.getResultGUI().getCbBoxFacultyTab2().removeAllItems();
//        mainStudentGUI.getResultGUI().getCbBoxFacultyTab2().addItem("Choose faculty ...");
//
//    }
//
//    private void resetComboBoxSubject() {
//        mainStudentGUI.getResultGUI().getComboBoxSubject().removeAllItems();
//        mainStudentGUI.getResultGUI().getComboBoxSubject().addItem("Choose subject ...");
//    }
//
//    private void resetComboBoxExamination() {
//
//        mainStudentGUI.getResultGUI().getComboBoxExamination().removeAllItems();
//        mainStudentGUI.getResultGUI().getComboBoxExamination().addItem("Choose examination ...");
//
//    }
//
//    public void doSearch() {
//        resultList = ObservableCollections.observableList(new ArrayList<ExamCard>());
//        resultTable = mainStudentGUI.getResultGUI().getTableMark();
//
//        nameExamination = mainStudentGUI.getResultGUI().getComboBoxExamination().getSelectedItem().toString();
//        nameClass = mainStudentGUI.getResultGUI().getComboBoxClass().getSelectedItem().toString();
//
//        List<Student> studentList = studentService.findByClassRoom(nameClass);
//        Exam exam = examService.findByExamName(nameExamination);
//        Subject subject = subjectService.findBySubjectName(nameSubject);
//
//        for (Student student1 : studentList) {
//            ExamCard result = resultService.findByExamRelationResultAndStudentRelation(exam,student1);
//            if (result != null) {
//                resultList.add(result);
//            }
//        }
//        doBindingMark(resultList);
//
//    }
//    private void doBindingMark(List<ExamCard> resultList) {
//        TableBinding.bindingResult(resultList, resultTable, mainStudentGUI.getResultGUI().getMarkScrollPanel());
//
//        TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
//        TextAreaEditor textEditor = new TextAreaEditor();
//        TableColumnModel cmodel = resultTable.getColumnModel();
//        cmodel.getColumn(0).setCellRenderer(textAreaRenderer);
//        cmodel.getColumn(0).setCellEditor(textEditor);
//        cmodel.getColumn(1).setCellRenderer(textAreaRenderer);
//        cmodel.getColumn(1).setCellEditor(textEditor);
//
//
//        JTableHeader header = resultTable.getTableHeader();
//        header.setPreferredSize(new Dimension(10000, 30));
//        resultTable.getTableHeader().setReorderingAllowed(false);
//        resultTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        resultTable.repaint();
//    }
}
