package com.ptit.exam.ui.control.admincontroller;

import com.ptit.exam.business.ExamService;
import com.ptit.exam.business.QuestionService;
import com.ptit.exam.business.SubjectService;
import com.ptit.exam.persistence.entity.Exam;
import com.ptit.exam.persistence.entity.Subject;
import com.ptit.exam.ui.view.admin.MainAdminGUI;
import com.ptit.exam.ui.view.admin.NewExaminationGUI;
import com.ptit.exam.util.ComboboxManager;
import com.ptit.exam.util.Constants;
import com.ptit.exam.util.GlobalValues;
import com.ptit.exam.util.MessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

/**
 * User: thuongntt
 * Date: 10/19/13
 * Time: 4:28 PM
 */
@Component
public class NewExamController
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

    @Autowired
    SubjectService subjectService;

    private NewExaminationGUI newExaminationGUI;
    private List<Subject> subjectList;

    private Exam exam;

    public void doSetUp(Exam exam)
    {
        this.exam = exam;

        newExaminationGUI = mainAdminGUI.getNewExaminationGUI();
        subjectList = subjectService.getAll();
        ComboboxManager.setListSubject(newExaminationGUI.getComboBoxSubject(), subjectList);

        setNumberQuestion(subjectList.get(0).getSubjectName());
        setUpActionListener();
    }

    private void setUpActionListener()
    {
        if (GlobalValues.NEW_EXAM_ADD_ACTION)
        {
            newExaminationGUI.getBtnSave().addActionListener(actionListener);
            newExaminationGUI.getBtnCancel().addActionListener(actionListener);

            newExaminationGUI.getComboBoxSubject().addItemListener(itemListener);
        }
        GlobalValues.NEW_EXAM_ADD_ACTION = false;
    }

    private ItemListener itemListener = new ItemListener()
    {
        @Override
        public void itemStateChanged(ItemEvent e)
        {
            setNumberQuestion(newExaminationGUI.getComboBoxSubject().getSelectedItem().toString());
        }
    };

    private void setNumberQuestion(String name)
    {
        List<Subject> subjects = subjectService.findBySubjectName(name);
        Subject su = subjects.get(0);


        int countEasy = getTotalCountEasy(su);
        int countMedium = getTotalCountMedium(su);
        int countHard = getTotalCountHard(su);

        newExaminationGUI.setLabelTotalCountLevel(countEasy, countMedium, countHard);

    }


    private int getTotalCountHard(Subject subject)
    {
        return questionService.findBySubjectIdAndLevel(subject.getSubjectCode(), Constants.HARD).size();
        //return questionService.findBySubjectIdAndLevel(exam.getSubjectCode(), Constants.HARD).size();
    }

    private int getTotalCountMedium(Subject subject)
    {
        return questionService.findBySubjectIdAndLevel(subject.getSubjectCode(), Constants.MEDIUM).size();
    }

    private int getTotalCountEasy(Subject subject)
    {
        return questionService.findBySubjectIdAndLevel(subject.getSubjectCode(), Constants.EASY).size();
    }

    private ActionListener actionListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == newExaminationGUI.getBtnSave())
            {
                if (newExaminationGUI.invalidForm())
                {
                    MessageManager.show("Thông tin về đề thi không hợp lệ.");
                }
                else
                {
                    exam = newExaminationGUI.getExamInfo(exam, subjectList);
                    examService.save(exam);
                    MessageManager.show("Đã lưu thành công.");

                    managementExamController.doSetUp(exam);
                    mainAdminController.doShowManagementExamGUI();
                }
            }
            if (e.getSource() == newExaminationGUI.getBtnCancel())
            {
                managementExamController.doSetUp(exam);
                newExaminationGUI.resetExportExamGUI();
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
//            mainAdminGUI.getNewExaminationGUI().getComboBoxSubject().addItem(s);
//        }
//
//        difficultList = difficultService.getAll();
//        mainAdminGUI.getNewExaminationGUI().getLbDifficult1().setText(difficultList.get(0).getDifficultName());
//        mainAdminGUI.getNewExaminationGUI().getLbDifficult2().setText(difficultList.get(1).getDifficultName());
//        mainAdminGUI.getNewExaminationGUI().getLbDifficult3().setText(difficultList.get(2).getDifficultName());
//
//        mainAdminGUI.getNewExaminationGUI().getComboBoxSubject().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (mainAdminGUI.getNewExaminationGUI().getComboBoxSubject().isPopupVisible()) {
//
//                    subject = subjectService.findBySubjectName(mainAdminGUI.getNewExaminationGUI().getComboBoxSubject().getSelectedItem().toString());
//
//                    questionList = questionService.findBySubjectRelation(subject);
//                    int totalNumberQuestionBank = questionList.size();
//                    mainAdminGUI.getNewExaminationGUI().getLbTotalQuestionBank().setText(String.valueOf(totalNumberQuestionBank));
//                    questionList = questionService.findBySubjectRelationAndDifficultRelation(subject, difficultList.get(0));
//                    mainAdminGUI.getNewExaminationGUI().getLbTotalQuestionDifficult1().setText(String.valueOf(questionList.size()));
//                    questionList = questionService.findBySubjectRelationAndDifficultRelation(subject, difficultList.get(1));
//                    mainAdminGUI.getNewExaminationGUI().getLbTotalQuestionDifficult2().setText(String.valueOf(questionList.size()));
//                    questionList = questionService.findBySubjectRelationAndDifficultRelation(subject, difficultList.get(2));
//                    mainAdminGUI.getNewExaminationGUI().getLbTotalQuestionDifficult3().setText(String.valueOf(questionList.size()));
//
//
//                }
//            }
//        });
//    }
//
//    private void resetComboBoxSubject() {
//        mainAdminGUI.getNewExaminationGUI().getComboBoxSubject().removeAllItems();
//        mainAdminGUI.getNewExaminationGUI().getComboBoxSubject().addItem("Choose subject ...");
//    }
//
//    public void doExportExam() {
//
//        String nameSubject = mainAdminGUI.getNewExaminationGUI().getComboBoxSubject().getSelectedItem().toString();
//        Subject subject1 = subjectService.findBySubjectName(nameSubject);
//        String examName = mainAdminGUI.getNewExaminationGUI().getTxtExamName().getText();
//        int totalNumberQuestion = Integer.parseInt(mainAdminGUI.getNewExaminationGUI().getTxtTotalNumberQuestion().getText());
//        int totalTime = Integer.parseInt(mainAdminGUI.getNewExaminationGUI().getTxtTotalNumberTime().getText());
//        int totalNumberQuestionDifficult1 = Integer.parseInt(mainAdminGUI.getNewExaminationGUI().getTxtNumberQuestionEasy().getText());
//        int totalNumberQuestionDifficult2 = Integer.parseInt(mainAdminGUI.getNewExaminationGUI().getTxtNumberQuestionMedium().getText());
//        int totalNumberQuestionDifficult3 = Integer.parseInt(mainAdminGUI.getNewExaminationGUI().getTxtNumberQuestionHard().getText());
//
//        int totalNumberQuestionBankDifficult1 = Integer.parseInt(mainAdminGUI.getNewExaminationGUI().getLbTotalQuestionDifficult1().getText());
//        int totalNumberQuestionBankDifficult2 = Integer.parseInt(mainAdminGUI.getNewExaminationGUI().getLbTotalQuestionDifficult2().getText());
//        int totalNumberQuestionBankDifficult3 = Integer.parseInt(mainAdminGUI.getNewExaminationGUI().getLbTotalQuestionDifficult3().getText());
//
//       // int totalNumberQuestionBank = Integer.parseInt(mainAdminGUI.getNewExaminationGUI().getLbTotalQuestionBank().getText());
//
//        List<Question> questionList1 = new ArrayList<Question>();
//        getQuestionRandom(questionList1, subject1,difficultList.get(0), totalNumberQuestionDifficult1, totalNumberQuestionBankDifficult1);
//        getQuestionRandom(questionList1, subject1,difficultList.get(1), totalNumberQuestionDifficult2, totalNumberQuestionBankDifficult2);
//        getQuestionRandom(questionList1, subject1,difficultList.get(2), totalNumberQuestionDifficult3, totalNumberQuestionBankDifficult3);
//
//
//        mainAdminGUI.getNewExaminationGUI().getLbTotalNumberSelested().setText(String.valueOf(totalNumberQuestionDifficult1 + totalNumberQuestionDifficult2 + totalNumberQuestionDifficult3));
//
//        Long numberQues = new Long(totalNumberQuestion);
//        Long numberTime = new Long(totalTime*60);
//        // luu Exam
//        String examCode = mainAdminGUI.getNewExaminationGUI().getTxtExamCode().getText();
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
//        mainAdminGUI.getNewExaminationGUI().getTxtExamName().setText("");
//        mainAdminGUI.getNewExaminationGUI().getTxtExamCode().setText("");
//        mainAdminGUI.getNewExaminationGUI().getTxtTotalNumberQuestion().setText("0");
//        mainAdminGUI.getNewExaminationGUI().getTxtTotalNumberTime().setText("0");
//        mainAdminGUI.getNewExaminationGUI().getTxtNumberQuestionEasy().setText("0");
//        mainAdminGUI.getNewExaminationGUI().getTxtNumberQuestionMedium().setText("0");
//        mainAdminGUI.getNewExaminationGUI().getTxtNumberQuestionHard().setText("0");
//    }
}
