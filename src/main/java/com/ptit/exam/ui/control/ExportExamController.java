package com.ptit.exam.ui.control;

import org.springframework.stereotype.Component;

/**
 * User: thuongntt
 * Date: 10/19/13
 * Time: 4:28 PM
 */
@Component
public class ExportExamController {
//    @Autowired
//    MainAdminGUI mainAdminGUI;
//    @Autowired
//    SubjectService subjectService;
//    @Autowired
//    ExamService examService;
//
//    @Autowired
//    ExamQuestionService examQuestionService;
//    @Autowired
//    QuestionService questionService;
//    @Autowired
//    DifficultService difficultService;
//
//    private List<Subject> subjectList;
//    private List<Question> questionList;
//    private List<Difficult> difficultList;
//    private Subject subject;
//
//    private List<Question> questionListDifficult1;
////    private List<Question> questionListDifficult2;
////    private List<Question> questionListDifficult3;
//
//    public void showExportExamGUI() {
//        resetComboBoxSubject();
//
//        subjectList = subjectService.getAll();
//        Set<String> stringSet = new HashSet<String>();
//        for (Subject subject : subjectList) {
//            stringSet.add(subject.getSubjectName());
//        }
//
//        for (String s : stringSet) {
//            mainAdminGUI.getExportExaminationGUI().getComboBoxsubject().addItem(s);
//        }
//
//        difficultList = difficultService.getAll();
//        mainAdminGUI.getExportExaminationGUI().getLbDifficult1().setText(difficultList.get(0).getDifficultName());
//        mainAdminGUI.getExportExaminationGUI().getLbDifficult2().setText(difficultList.get(1).getDifficultName());
//        mainAdminGUI.getExportExaminationGUI().getLbDifficult3().setText(difficultList.get(2).getDifficultName());
//
//        mainAdminGUI.getExportExaminationGUI().getComboBoxsubject().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (mainAdminGUI.getExportExaminationGUI().getComboBoxsubject().isPopupVisible()) {
//
//                    subject = subjectService.findBySubjectName(mainAdminGUI.getExportExaminationGUI().getComboBoxsubject().getSelectedItem().toString());
//
//                    questionList = questionService.findBySubjectRelation(subject);
//                    int totalNumberQuestionBank = questionList.size();
//                    mainAdminGUI.getExportExaminationGUI().getLbTotalQuestionBank().setText(String.valueOf(totalNumberQuestionBank));
//                    questionList = questionService.findBySubjectRelationAndDifficultRelation(subject, difficultList.get(0));
//                    mainAdminGUI.getExportExaminationGUI().getLbTotalQuestionDifficult1().setText(String.valueOf(questionList.size()));
//                    questionList = questionService.findBySubjectRelationAndDifficultRelation(subject, difficultList.get(1));
//                    mainAdminGUI.getExportExaminationGUI().getLbTotalQuestionDifficult2().setText(String.valueOf(questionList.size()));
//                    questionList = questionService.findBySubjectRelationAndDifficultRelation(subject, difficultList.get(2));
//                    mainAdminGUI.getExportExaminationGUI().getLbTotalQuestionDifficult3().setText(String.valueOf(questionList.size()));
//
//
//                }
//            }
//        });
//    }
//
//    private void resetComboBoxSubject() {
//        mainAdminGUI.getExportExaminationGUI().getComboBoxsubject().removeAllItems();
//        mainAdminGUI.getExportExaminationGUI().getComboBoxsubject().addItem("Choose subject ...");
//    }
//
//    public void doExportExam() {
//
//        String nameSubject = mainAdminGUI.getExportExaminationGUI().getComboBoxsubject().getSelectedItem().toString();
//        Subject subject1 = subjectService.findBySubjectName(nameSubject);
//        String examName = mainAdminGUI.getExportExaminationGUI().getTxtExamName().getText();
//        int totalNumberQuestion = Integer.parseInt(mainAdminGUI.getExportExaminationGUI().getTxtTotalNumberQuestion().getText());
//        int totalTime = Integer.parseInt(mainAdminGUI.getExportExaminationGUI().getTxtTotalNumberTime().getText());
//        int totalNumberQuestionDifficult1 = Integer.parseInt(mainAdminGUI.getExportExaminationGUI().getTxtNumberQuestionDifficult1().getText());
//        int totalNumberQuestionDifficult2 = Integer.parseInt(mainAdminGUI.getExportExaminationGUI().getTxtNumberQuestionDifficult2().getText());
//        int totalNumberQuestionDifficult3 = Integer.parseInt(mainAdminGUI.getExportExaminationGUI().getTxtNumberQuestionDifficult3().getText());
//
//        int totalNumberQuestionBankDifficult1 = Integer.parseInt(mainAdminGUI.getExportExaminationGUI().getLbTotalQuestionDifficult1().getText());
//        int totalNumberQuestionBankDifficult2 = Integer.parseInt(mainAdminGUI.getExportExaminationGUI().getLbTotalQuestionDifficult2().getText());
//        int totalNumberQuestionBankDifficult3 = Integer.parseInt(mainAdminGUI.getExportExaminationGUI().getLbTotalQuestionDifficult3().getText());
//
//       // int totalNumberQuestionBank = Integer.parseInt(mainAdminGUI.getExportExaminationGUI().getLbTotalQuestionBank().getText());
//
//        List<Question> questionList1 = new ArrayList<Question>();
//        getQuestionRandom(questionList1, subject1,difficultList.get(0), totalNumberQuestionDifficult1, totalNumberQuestionBankDifficult1);
//        getQuestionRandom(questionList1, subject1,difficultList.get(1), totalNumberQuestionDifficult2, totalNumberQuestionBankDifficult2);
//        getQuestionRandom(questionList1, subject1,difficultList.get(2), totalNumberQuestionDifficult3, totalNumberQuestionBankDifficult3);
//
//
//        mainAdminGUI.getExportExaminationGUI().getLbTotalNumberSelested().setText(String.valueOf(totalNumberQuestionDifficult1 + totalNumberQuestionDifficult2 + totalNumberQuestionDifficult3));
//
//        Long numberQues = new Long(totalNumberQuestion);
//        Long numberTime = new Long(totalTime*60);
//        // luu Exam
//        String examCode = mainAdminGUI.getExportExaminationGUI().getTxtExamCode().getText();
//        Exam exam = examService.save(new Exam(subject1,examCode, examName, numberQues, numberTime, false));
//        // luu ExamQuestion
//        for (Question question : questionList1) {
//            examQuestionService.save(new ExamQuestion(exam, question));
//
//        }
//
//        resetExportExam();
//
//    }
//
//    private void resetExportExam() {
//        questionList = null;
//        mainAdminGUI.getExportExaminationGUI().getTxtExamName().setText("");
//        mainAdminGUI.getExportExaminationGUI().getTxtExamCode().setText("");
//        mainAdminGUI.getExportExaminationGUI().getTxtTotalNumberQuestion().setText("0");
//        mainAdminGUI.getExportExaminationGUI().getTxtTotalNumberTime().setText("0");
//        mainAdminGUI.getExportExaminationGUI().getTxtNumberQuestionDifficult1().setText("0");
//        mainAdminGUI.getExportExaminationGUI().getTxtNumberQuestionDifficult2().setText("0");
//        mainAdminGUI.getExportExaminationGUI().getTxtNumberQuestionDifficult3().setText("0");
//    }
//
//    private void getQuestionRandom(List<Question> questionList, Subject subject1,Difficult difficult, int totalNumberQuestionDifficult1, int totalNumberQuestionBankDifficult1) {
//        if (totalNumberQuestionDifficult1 <= totalNumberQuestionBankDifficult1) {
//            questionListDifficult1 = questionService.findBySubjectRelationAndDifficultRelation(subject1, difficult);
//
//            int count = 0;
//            while (count < totalNumberQuestionDifficult1) {
//                int x = NumberManager.getRandomNumber(totalNumberQuestionBankDifficult1 - 1 - count);
//                questionList.add(questionListDifficult1.get(x));
//                questionListDifficult1.remove(x);
//                count++;
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Số câu hỏi trong ngân hàng không đủ");
//
//        }
//    }
}
