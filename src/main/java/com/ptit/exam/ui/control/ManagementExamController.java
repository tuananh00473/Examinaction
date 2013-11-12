package com.ptit.exam.ui.control;

import org.springframework.stereotype.Component;

/**
 * User: thuongntt
 * Date: 10/21/13
 * Time: 10:56 AM
 */
@Component
public class ManagementExamController {
//    @Autowired
//    MainAdminGUI mainAdminGUI;
//    @Autowired
//    SubjectService subjectService;
//    @Autowired
//    ExamService examService;
//
//    private List<Subject> subjectList;
//    private List<Exam>  examList;
//    private JTable managementExamTable;
//    private Set<String> stringSet = new HashSet<String>();
//    private String nameSubject;
//
//    public void doSetUp() {
//        resetManagementExamGUI();
//        resetComboBoxSubject();
//        subjectList = subjectService.getAll();
//        for(Subject subject : subjectList){
//            stringSet.add(subject.getSubjectName());
//        }
//        for (String s: stringSet){
//            mainAdminGUI.getManagermentExamGUI().getComboBoxSubject().addItem(s.intern());
//        }
//
//    }
//
//    private void resetManagementExamGUI() {
//        if(examList!=null){
//            for(int i = 0; i< examList.size();i++){
//                examList.remove(i);
//            }
//
//        }
//
//
//        if(managementExamTable!=null){
//            doBindingManagermentExam( examList);
//
//        }
//
//    }
//
//    private void resetComboBoxSubject() {
//        mainAdminGUI.getManagermentExamGUI().getComboBoxSubject().removeAllItems();
//        mainAdminGUI.getManagermentExamGUI().getComboBoxSubject().addItem("Chọn môn thi ...");
//    }
//
//    public void doSearch() {
//        examList = ObservableCollections.observableList(new ArrayList<Exam>());
//        managementExamTable = mainAdminGUI.getManagermentExamGUI().getManagementExamTable();
//        nameSubject = mainAdminGUI.getManagermentExamGUI().getComboBoxSubject().getSelectedItem().toString();
//        Subject subject = subjectService.findBySubjectName(nameSubject);
//        examList = examService.findBySubjectRelationExam(subject);
//        doBindingManagermentExam(examList);
//
//
//    }
//
//    private void doBindingManagermentExam(List<Exam> examList) {
//        TableBinding.bindingManagementExam(examList, managementExamTable, mainAdminGUI.getManagermentExamGUI().getManagementExamScrollpanel());
//
//        TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
//        TextAreaEditor textEditor = new TextAreaEditor();
//        TableColumnModel cmodel = managementExamTable.getColumnModel();
//        cmodel.getColumn(0).setCellRenderer(textAreaRenderer);
//        cmodel.getColumn(0).setCellEditor(textEditor);
//        cmodel.getColumn(1).setCellRenderer(textAreaRenderer);
//        cmodel.getColumn(1).setCellEditor(textEditor);
//        cmodel.getColumn(2).setCellRenderer(textAreaRenderer);
//        cmodel.getColumn(2).setCellEditor(textEditor);
//        cmodel.getColumn(3).setCellRenderer(textAreaRenderer);
//        cmodel.getColumn(3).setCellEditor(textEditor);
//        cmodel.getColumn(4).setCellEditor(managementExamTable.getDefaultEditor(Boolean.class));
//        cmodel.getColumn(4).setCellRenderer(managementExamTable.getDefaultRenderer(Boolean.class));
//
//        JTableHeader header = managementExamTable.getTableHeader();
//        header.setPreferredSize(new Dimension(10000, 30));
//        managementExamTable.getTableHeader().setReorderingAllowed(false);
//        managementExamTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        managementExamTable.repaint();
//    }
//
//    public void doSave() {
//        for (Exam exam: examList){
//            examService.save(exam) ;
//        }
//    }
}
