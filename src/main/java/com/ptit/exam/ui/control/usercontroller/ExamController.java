package com.ptit.exam.ui.control.usercontroller;

import com.ptit.exam.business.AnswerService;
import com.ptit.exam.business.QuestionService;
import com.ptit.exam.business.ResultService;
import com.ptit.exam.business.StudentService;
import com.ptit.exam.persistence.entity.*;
import com.ptit.exam.ui.view.student.ExamGUI;
import com.ptit.exam.ui.view.student.MainStudentGUI;
import com.ptit.exam.util.Constants;
import com.ptit.exam.util.GlobalValues;
import com.ptit.exam.util.MessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: thuongntt
 * Date: 10/8/13
 * Time: 4:07 PM
 */
@Component
public class ExamController {

    @Autowired
    MainStudentController mainStudentController;

    @Autowired
    MainStudentGUI mainStudentGUI;

    @Autowired
    SettingExamController settingExamController;

    @Autowired
    StudentService studentService;

    @Autowired
    AnswerService answerService;

    @Autowired
    QuestionService questionService;

    @Autowired
    ResultService resultService;

    private List<Question> questionList = new ArrayList<Question>();
    private MyButton[] buttonQuestions;
    private JTextArea textAreaQuestion;
    private JLabel lbImage;
    private List<Answer> answerList;
    private MyButton[] buttonAnswers = new MyButton[4];

    private int indexQuestion = 0;
    private int totalNumberAnswered = 0;
    private int totalQuestionCount;
    private long second = 0;
    private long minute = 0;
    private Thread thread;
    private Exam exam;
    private Subject subject;
    private Student student;
    private ExamGUI examGUI;

    private int[] correctAnswers;
    private int[] studentAnswers;

    public void doSetUp() {
        setGlobalValues();
        setUpView();
        setUpActionListener();
    }

    private void setGlobalValues() {
        student = GlobalValues.student;
        subject = GlobalValues.subject;
        exam = GlobalValues.exam;

        totalQuestionCount = exam.getTotalQuestion();
        correctAnswers = new int[totalQuestionCount];
        studentAnswers = new int[totalQuestionCount];
    }

    public void setUpView() {
        examGUI = mainStudentGUI.getExamGUI();
        examGUI.setInfoAboutStudentToField(subject, student, exam);
        showButtonQuestion(exam);
        showButtonAnswer(exam);
        setTotalNumberAnswered(totalNumberAnswered);
        startTime(exam.getTotalTime());
    }

    public void setUpActionListener() {
        if (GlobalValues.EXAM_CARD_ACTION) {
            examGUI.getBtnNext().addActionListener(actionListener);
            examGUI.getBtnPrevious().addActionListener(actionListener);
            examGUI.getBtnSubmit().addActionListener(actionListener);
        }
        GlobalValues.EXAM_CARD_ACTION = false;
    }

    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == examGUI.getBtnNext()) {
                doNext();
            }
            if (e.getSource() == examGUI.getBtnPrevious()) {
                doPrevious();
            }
            if (e.getSource() == examGUI.getBtnSubmit()) {
                doSubmit();
            }
        }
    };

    private void doSubmit() {
        showResultExam();
        settingExamController.resetEnableButton();
    }

    private void doPrevious() {
        if (indexQuestion > 0) {
            indexQuestion--;
            setQuestionSelected(indexQuestion);
        }
    }

    private void doNext() {
        if (indexQuestion < totalQuestionCount - 1) {
            indexQuestion++;
            setQuestionSelected(indexQuestion);
        }
    }

    private void startTime(final long totalTime) {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                minute = totalTime;
                second = 0;
                while (!(minute == 0 && second == 0)) {
                    try {
                        Thread.sleep(1000);
                        if (second == 0) {
                            second = 60;
                            minute--;
                        }
                        second--;
                        String textMinute = minute < 10 ? "0" + minute : String.valueOf(minute);
                        String textSecond = second < 10 ? "0" + second : String.valueOf(second);
                        examGUI.getLbRemainTime().setText(textMinute + ":" + textSecond);
                    } catch (InterruptedException e) {
                    }
                }
                MessageManager.show("Time over !");
                showResultExam();
            }
        });
        thread.start();
    }

    private void showResultExam() {
        int score = 0;
        for (int i = 0; i < totalQuestionCount; i++) {
            if (studentAnswers[i] == correctAnswers[i]) {
                if (i < exam.getTotalEasyQuestion()) {
                    score += Constants.EASY;
                } else if (i < exam.getTotalEasyQuestion() + exam.getTotalMediumQuestion()) {
                    score += Constants.MEDIUM;
                } else {
                    score += Constants.HARD;
                }
            }
        }

        int maxScore = exam.getTotalEasyQuestion() + exam.getTotalMediumQuestion() * 2 + exam.getTotalHardQuestion() * 3;

        Result result = new Result();
        result.setExamId(exam.getId());
        result.setStudentId(student.getId());
        result.setScore(score);
        result.setMaxScore(maxScore);

        resultService.save(result);
        thread.stop();
        MessageManager.show("Điểm bài thi của bạn : " + score + "/" + maxScore + ".");
        mainStudentController.doShowSettingExamCard();
    }

    public void showButtonQuestion(Exam exam) {
        questionList = questionService.loadRandomExamQuestionList(exam);
        correctAnswers = answerService.loadCorrectAnswer(questionList);

        textAreaQuestion = examGUI.getTxtContentQuestion();
        JPanel panelButtonQuestion = examGUI.getPanelButtonQuestion();
        panelButtonQuestion.setLayout(new GridLayout(0, 3));
        buttonQuestions = new MyButton[totalQuestionCount];

        for (int i = 0; i < totalQuestionCount; i++) {
            final int index = i + 1;
            buttonQuestions[i] = new MyButton();
            buttonQuestions[i].setNameButton(String.valueOf(index));
            buttonQuestions[i].setText(String.valueOf(index));
            buttonQuestions[i].setIdQuestion(questionList.get(index - 1).getId());
            buttonQuestions[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    indexQuestion = getInt(buttonQuestions[index - 1].getNameButton()) - 1;
                    setQuestionSelected(indexQuestion);
                    //indexQuestion1++;
                }
            });
            panelButtonQuestion.add(buttonQuestions[i]);

        }
        showQuestionByIndex(indexQuestion, textAreaQuestion, questionList);
        panelButtonQuestion.revalidate();
        panelButtonQuestion.repaint();
    }

    private void setQuestionSelected(int indexQuestion) {
        showQuestionByIndex(indexQuestion, textAreaQuestion, questionList);
        resetForegroundButtonAnswer();
    }

    // dat lai foreground cho cac button answer
    // neu cau tra loi da duoc chon thi dat la mau GRAY
    // neu cau tra loi chua duoc(khong duoc) chon thi set mau Default.
    private void resetForegroundButtonAnswer() {
        for (int i = 0; i < answerList.size(); i++) {
            if (i + 1 == studentAnswers[indexQuestion]) {
                buttonAnswers[i].setForegroundColor(Color.GRAY);
            } else {
                buttonAnswers[i].setForegroundColor(new JButton().getForeground());
            }
        }
        // todo
    }

    private void showQuestionByIndex(int indexQuestion, JTextArea textAreaQuestion, List<Question> questionList) {
        lbImage = examGUI.getLbImage();
        buttonQuestions[indexQuestion].setForegroundColor(Color.RED);

        for (int i = 1; i < totalQuestionCount; i++) {

            int index = (indexQuestion + i) % totalQuestionCount;
            if (buttonQuestions[index].isSelected()) {
                buttonQuestions[index].setForegroundColor(Color.GREEN);
            } else {
                buttonQuestions[index].setForegroundColor(new JButton().getForeground());
            }
        }

        answerList = questionList.get(indexQuestion).getAnswerList();
        String textAnswerA = "\nA. " + answerList.get(0).getContent();
        String textAnswerB = "\nB. " + answerList.get(1).getContent();
        String textAnswerC = "\nC. " + answerList.get(2).getContent();
        String textAnswerD = "\nD. " + answerList.get(3).getContent();
        String textAnswer = textAnswerA + textAnswerB + textAnswerC + textAnswerD;
        textAreaQuestion.setText(questionList.get(indexQuestion).getContent() + "\n" + textAnswer);
        if (questionList.get(indexQuestion).getUrlImage() != null) {
            try {
                BufferedImage questionImage = ImageIO.read(new File(questionList.get(indexQuestion).getUrlImage()));
                examGUI.getLbImage().setIcon(new ImageIcon(questionImage));
                examGUI.getLbImage().setVisible(true);
            } catch (IOException e1) {
                examGUI.getLbImage().setVisible(false);
            }
        } else {
            examGUI.setVisible(false);
        }
    }

    public void showButtonAnswer(Exam exam) {
        JPanel panelButtonAnswer = examGUI.getPanelButtonAnswer();
        panelButtonAnswer.setLayout(new GridLayout(0, 4));

        for (int i = 0; i < 4; i++) {
            final int indexAnswer = i;
            buttonAnswers[i] = new MyButton();
            buttonAnswers[i].setNameButton(String.valueOf(i));
            buttonAnswers[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setStudentSelected(indexAnswer);
                    questionList.get(indexQuestion).setAnswerList(answerList);
                }
            });
            panelButtonAnswer.add(buttonAnswers[i]);
        }
        setLabelButtonAnswer();
        panelButtonAnswer.revalidate();
        panelButtonAnswer.repaint();
    }


    // set text cho 4 button answer tuong ung la A, B, C, D.
    private void setLabelButtonAnswer() {
        buttonAnswers[0].setText("A");
        buttonAnswers[1].setText("B");
        buttonAnswers[2].setText("C");
        buttonAnswers[3].setText("D");
    }

    public void setStudentSelected(int indexAnswer) {
        if (!buttonQuestions[indexQuestion].isSelected()) {    // neu cau hoi chua duoc tra loi moi tang numberAnswered them 1
            totalNumberAnswered++;
        }

        setTotalNumberAnswered(totalNumberAnswered);     // edit lai so luong cau hoi da dc tra loi

        // danh dau cho cau tra loi ma sinh vien lua chon
        studentAnswers[indexQuestion] = indexAnswer + 1;
        buttonAnswers[indexAnswer].setForegroundColor(Color.GRAY);
        buttonAnswers[indexAnswer].setSelected(true);


        // danh dau cac cau tra loi con lai ma sv ko chon
        for (int i = 1; i <= 3; i++) {
            int otherButton = (indexAnswer + i) % 4;
//            answerList.get(otherButton).setStudenSelectted(false);  // todo
            buttonAnswers[otherButton].setForegroundColor(new JButton().getForeground());
        }

        //danh dau rang cau hoi nay sinh vien da tra loi roi
        buttonQuestions[indexQuestion].setSelected(true);
    }


    // gan lai label so luong cau hoi da tra loi va label so luong cau hoi con lai
    public void setTotalNumberAnswered(int totalNumberAnswered) {
        examGUI.getLbTotalNumberAnswered().setText(String.valueOf(totalNumberAnswered));
        examGUI.getLbTotalNumberNotAnswerYet().setText(String.valueOf(totalQuestionCount - totalNumberAnswered));
    }

    public int getInt(String textInt) {
        return Integer.parseInt(textInt);
    }
}
