package com.ptit.exam.ui.control.admincontroller;

import com.ptit.exam.business.AnswerService;
import com.ptit.exam.business.ExamService;
import com.ptit.exam.business.QuestionService;
import com.ptit.exam.business.SubjectService;
import com.ptit.exam.io.PDFManager;
import com.ptit.exam.persistence.entity.Exam;
import com.ptit.exam.persistence.entity.Question;
import com.ptit.exam.persistence.entity.Subject;
import com.ptit.exam.ui.view.admin.ExportExamGUI;
import com.ptit.exam.ui.view.admin.MainAdminGUI;
import com.ptit.exam.util.ComboboxManager;
import com.ptit.exam.util.FileChooserManager;
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
 * Date: 12/12/13
 * Time: 11:29 PM
 */
@Component
public class ExportExamController {

    @Autowired
    MainAdminGUI mainAdminGUI;

    @Autowired
    SubjectService subjectService;

    @Autowired
    ExamService examService;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    private ExportExamGUI exportExamGUI;
    private List<Question> questionList;
    private int[] correctAnswers;

    public void doSetUp() {
        setUpView();
        setUpActionListener();
    }

    private void setUpView() {
        exportExamGUI = mainAdminGUI.getExportExamGUI();

        List<Subject> subjectList = subjectService.getAll();
        ComboboxManager.setListSubject(exportExamGUI.getCbSubjectName(), subjectList);
    }

    private void setUpActionListener() {
        exportExamGUI.getCbSubjectName().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Subject subject = (Subject) e.getItem();
                List<Exam> examList = examService.findBySubjectCode(subject.getSubjectCode());
                exportExamGUI.getCbExamName().removeAllItems();
                ComboboxManager.setListExam(exportExamGUI.getCbExamName(), examList);
            }
        });

        exportExamGUI.getBtnGenerateExam().addActionListener(actionListener);
        exportExamGUI.getBtnExport().addActionListener(actionListener);
        exportExamGUI.getBtnCancel().addActionListener(actionListener);
    }

    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exportExamGUI.getBtnGenerateExam()) {
                Exam exam = (Exam) exportExamGUI.getCbExamName().getSelectedItem();
                questionList = questionService.loadRandomExamQuestionList(exam);
                correctAnswers = answerService.loadCorrectAnswer(questionList);

            }
            if (e.getSource() == exportExamGUI.getBtnExport()) {
                try {
                    String path = FileChooserManager.getPath(mainAdminGUI);
                    PDFManager.printData(path, questionList, correctAnswers);
                    MessageManager.show("Kết xuất đề thi thành công.");
                } catch (Exception ex) {
                    MessageManager.show("Kết xuất đề thi lỗi do hệ thống.");
                }
            }
            if (e.getSource() == exportExamGUI.getBtnCancel()) {
            }
        }
    };
}
