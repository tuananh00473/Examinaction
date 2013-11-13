package com.ptit.exam.ui.control;

import org.springframework.stereotype.Component;

/**
 * User: thuongntt
 * Date: 10/8/13
 * Time: 11:46 AM
 */
@Component
public class SettingExamController
{
//    @Autowired
//    MainStudentGUI mainStudentGUI;
//
//    @Autowired
//    LoginGUI loginGUI;
//
//    @Autowired
//    StudentService studentService;
//
//    @Autowired
//    SubjectService subjectService;
//
//    @Autowired
//    ExamService examService;
//
//    @Autowired
//    MainStudentController mainStudentController;
//
//    @Autowired
//    ExamQuestionService examQuestionService;
//
//    @Autowired
//    QuestionService questionService;
//
//    @Autowired
//    AnswerService answerService;
//
//    @Autowired
//    ExamCardService resultService;
//    @Autowired
//    ExamController examController;
//
//    private Student student;
//    private List<Exam> examList;
//    private JTable tableExamination;
//    // private ExamCard examCard;
//    private Subject subject;
//    private Exam exam;
//
//
//    public void doSetUp() {
//        resetSettingExamGUI();
//        resetComboBoxSubject();
//
//        examList = ObservableCollections.observableList(new ArrayList<Exam>());
//        tableExamination = mainStudentGUI.getSettingExamGUI().getTableExamination();
//        student = studentService.findByUserNameAndPassWord(loginGUI.getStudentInfo().getUserName(), loginGUI.getStudentInfo().getPassWord());
//        mainStudentGUI.getSettingExamGUI().getLbNameStudent().setText(student.getLastName() + " " + student.getFirstName());
//        mainStudentGUI.getSettingExamGUI().getLbClass().setText(student.getClassRoom());
//        mainStudentGUI.getSettingExamGUI().getLbStudentCode().setText(student.getStudentCode());
//        mainStudentGUI.getSettingExamGUI().getLbDateOfBirth().setText(student.getDateOfBirth());
//
//        mainStudentGUI.getSettingExamGUI().getLbFaculty().setText(student.getFaculty());
//        Set<String> stringSet = new HashSet<String>();
//        List<Subject> subjectList = subjectService.findByFaculty(student.getFaculty());
//        for (Subject subject : subjectList) {
//            stringSet.add(subject.getSubjectName());
//        }
//
//        for (String s : stringSet) {
//            mainStudentGUI.getSettingExamGUI().getComboBoxSubject().addItem(s.intern());
//        }
//        mainStudentGUI.getSettingExamGUI().getComboBoxSubject().setSelectedIndex(0);
//
//        mainStudentGUI.getSettingExamGUI().getComboBoxSubject().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (mainStudentGUI.getSettingExamGUI().getComboBoxSubject().isPopupVisible()) {
//
//                    subject = subjectService.findBySubjectName(mainStudentGUI.getSettingExamGUI().getComboBoxSubject().getSelectedItem().toString());
//
//                    setUpBindingExamination(subject);
//
//                }
//            }
//        });
//
//
//        stopEditting();
//
//    }
//    private void resetSettingExamGUI() {
//        if(examList!=null){
//            for(int i = 0; i< examList.size();i++){
//                examList.remove(i);
//            }
//        }
//
//        if(null != tableExamination && examList.size() > 0){
//            doBindingExamination( examList);
//
//        }
//
//        mainStudentGUI.getResultGUI().getCbBoxFacultyTab2().removeAllItems();
//        mainStudentGUI.getResultGUI().getComboBoxSubject().removeAllItems();
//        mainStudentGUI.getResultGUI().getComboBoxExamination().removeAllItems();
//    }
//
//
//    private void resetComboBoxSubject() {
//        mainStudentGUI.getSettingExamGUI().getComboBoxSubject().removeAllItems();
//        mainStudentGUI.getSettingExamGUI().getComboBoxSubject().addItem("Chọn môn thi ...");
//    }
//
//    public void doStart() {
//
//        int index = tableExamination.getSelectedRow();
//        if (index != -1) {
//            exam = examList.get(index);
//            subject = subjectService.findBySubjectName(mainStudentGUI.getSettingExamGUI().getComboBoxSubject().getSelectedItem().toString());
//            if (exam.isActivate()) {
//                ExamCard result = resultService.findByExamRelationResultAndStudentRelation(exam, student);
//                if (result == null) {
//                    result = new ExamCard();
//                    result.setExamRelationResult(exam);
//                    result.setStudentRelation(student);
//                    examController.showButtonQuestion(exam);
//                    examController.showButtonAnswer(exam);
//                    mainStudentController.doShowExamCard();
//                    examController.setTotalNumberAnswered(0);
//                    examController.doExam(result, exam,student);
//                } else {
//                    JOptionPane.showMessageDialog(null, "Sinh vien nay da thi roi");
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "De thi chua kich hoat");
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Bạn phải chọn 1 môn thi");
//        }
//
//
//    }
//
//
//    private void stopEditting() {
//        if (tableExamination.isEditing()) {
//            tableExamination.getCellEditor().stopCellEditing();
//        }
//    }
//
//    private void setUpBindingExamination(Subject subject) {
//
//        List<Exam> exams = examService.findBySubjectRelationExam(subject);
//        if (exams.size() != 0) {
//            examList = ObservableCollections.observableList(exams);
//            doBindingExamination(examList);
//
//        } else {
////            examList = ObservableCollections.observableList(new ArrayList<Exam>());
//            JOptionPane.showMessageDialog(null, "Hiện tại chưa có đề thi cho môn học này.");
//        }
//
//
//    }
//
//    private void doBindingExamination(List<Exam> examList) {
//        TableBinding.bindingExamination(examList, tableExamination, mainStudentGUI.getSettingExamGUI().getExaminationScrollPanel());
//
//        TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
//        TextAreaEditor textEditor = new TextAreaEditor();
//        TableColumnModel cmodel = tableExamination.getColumnModel();
//        cmodel.getColumn(0).setCellRenderer(textAreaRenderer);
//        cmodel.getColumn(0).setCellEditor(textEditor);
//        cmodel.getColumn(1).setCellRenderer(textAreaRenderer);
//        cmodel.getColumn(1).setCellEditor(textEditor);
//
//
//        JTableHeader header = tableExamination.getTableHeader();
//        header.setPreferredSize(new Dimension(10000, 30));
//        tableExamination.getTableHeader().setReorderingAllowed(false);
//        tableExamination.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        tableExamination.repaint();
//    }
//
//
}
