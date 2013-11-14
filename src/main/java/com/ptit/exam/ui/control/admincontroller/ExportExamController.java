package com.ptit.exam.ui.control.admincontroller;

import com.ptit.exam.business.ExamService;
import com.ptit.exam.business.QuestionService;
import com.ptit.exam.persistence.entity.Exam;
import com.ptit.exam.ui.view.admin.ExportExamination;
import com.ptit.exam.ui.view.admin.MainAdminGUI;
import com.ptit.exam.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: thuongntt
 * Date: 10/19/13
 * Time: 4:28 PM
 */
@Component
public class ExportExamController
{
    @Autowired
    MainAdminGUI mainAdminGUI;

    @Autowired
    MainAdminController mainAdminController;

    @Autowired
    ManagementExamController managementExamController;

    @Autowired
    ExamService examService;

    @Autowired
    QuestionService questionService;

    private ExportExamination exportExamination;

    private Exam exam;

    public void doSetUp(Exam exam)
    {
        this.exam = exam;

        exportExamination = mainAdminGUI.getExportExaminationGUI();

        exportExamination.getComboBoxSubject().setModel(new DefaultComboBoxModel(Constants.subjects));

        int countEasy = getTotalCountEasy();
        int countMedium = getTotalCountMedium();
        int countHard = getTotalCountHard();

        exportExamination.setLabelTotalCountLevel(countEasy, countMedium, countHard);

        exportExamination.getBtnSave().addActionListener(actionListener);
        exportExamination.getBtnCancel().addActionListener(actionListener);
    }

    private int getTotalCountHard()
    {
        return 10; // todo: vao service de lay info nay
    }

    private int getTotalCountMedium()
    {
        return 10; // todo: vao service de lay info nay
    }

    private int getTotalCountEasy()
    {
//        return questionService.findBySubjectIdAndLevelAndChapter()
        return 10; // todo: vao service de lay info nay
    }

    private ActionListener actionListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == exportExamination.getBtnSave())
            {
                if (exportExamination.invalidForm())
                {
                    showMessage("Cần điển đầy đủ các thông tin về câu hỏi.");
                }
                else
                {
                    exam = exportExamination.getExamInfo(exam);
                    examService.save(exam);
                    showMessage("Dữ liệu đã được lưu trữ.");

                    managementExamController.doSetUp();
                    mainAdminController.doShowManagementExamGUI();
                }
            }
            if (e.getSource() == exportExamination.getBtnCancel())
            {
                managementExamController.doSetUp();
                mainAdminController.doShowManagementExamGUI();
            }
        }
    };

//        resetComboBoxSubject();
//
//        subjectList = subjectService.getAll();
//        Set<String> stringSet = new HashSet<String>();
//        for (Subject subject : subjectList) {
//            stringSet.add(subject.getSubjectName());
//        }
//
//        for (String s : stringSet) {
//            mainAdminGUI.getExportExaminationGUI().getComboBoxSubject().addItem(s);
//        }
//
//        difficultList = difficultService.getAll();
//        mainAdminGUI.getExportExaminationGUI().getLbDifficult1().setText(difficultList.get(0).getDifficultName());
//        mainAdminGUI.getExportExaminationGUI().getLbDifficult2().setText(difficultList.get(1).getDifficultName());
//        mainAdminGUI.getExportExaminationGUI().getLbDifficult3().setText(difficultList.get(2).getDifficultName());
//
//        mainAdminGUI.getExportExaminationGUI().getComboBoxSubject().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (mainAdminGUI.getExportExaminationGUI().getComboBoxSubject().isPopupVisible()) {
//
//                    subject = subjectService.findBySubjectName(mainAdminGUI.getExportExaminationGUI().getComboBoxSubject().getSelectedItem().toString());
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
//        mainAdminGUI.getExportExaminationGUI().getComboBoxSubject().removeAllItems();
//        mainAdminGUI.getExportExaminationGUI().getComboBoxSubject().addItem("Choose subject ...");
//    }
//
//    public void doExportExam() {
//
//        String nameSubject = mainAdminGUI.getExportExaminationGUI().getComboBoxSubject().getSelectedItem().toString();
//        Subject subject1 = subjectService.findBySubjectName(nameSubject);
//        String examName = mainAdminGUI.getExportExaminationGUI().getTxtExamName().getText();
//        int totalNumberQuestion = Integer.parseInt(mainAdminGUI.getExportExaminationGUI().getTxtTotalNumberQuestion().getText());
//        int totalTime = Integer.parseInt(mainAdminGUI.getExportExaminationGUI().getTxtTotalNumberTime().getText());
//        int totalNumberQuestionDifficult1 = Integer.parseInt(mainAdminGUI.getExportExaminationGUI().getTxtNumberQuestionEasy().getText());
//        int totalNumberQuestionDifficult2 = Integer.parseInt(mainAdminGUI.getExportExaminationGUI().getTxtNumberQuestionMedium().getText());
//        int totalNumberQuestionDifficult3 = Integer.parseInt(mainAdminGUI.getExportExaminationGUI().getTxtNumberQuestionHard().getText());
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
//        mainAdminGUI.getExportExaminationGUI().getTxtNumberQuestionEasy().setText("0");
//        mainAdminGUI.getExportExaminationGUI().getTxtNumberQuestionMedium().setText("0");
//        mainAdminGUI.getExportExaminationGUI().getTxtNumberQuestionHard().setText("0");
//    }

    private void showMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }
}
