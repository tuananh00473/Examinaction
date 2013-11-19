package com.ptit.exam.ui.control.usercontroller;

import com.ptit.exam.persistence.entity.Student;
import com.ptit.exam.ui.view.student.ExamGUI;
import com.ptit.exam.ui.view.student.MainStudentGUI;
import com.ptit.exam.util.GlobalValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User: thuongntt
 * Date: 10/8/13
 * Time: 4:07 PM
 */
@Component
public class ExamController
{

    //    @Autowired
//    MainStudentController mainStudentController;
//
    @Autowired
    MainStudentGUI mainStudentGUI;

    //    @Autowired
//    SettingExamController settingExamController;
//
//    @Autowired
//    StudentService studentService;
//
//    @Autowired
//    AnswerService answerService;
//
//    @Autowired
//    QuestionService questionService;
//
//    @Autowired
//    ExamCardService resultService;
//
//    @Autowired
//    LoginGUI loginGUI;
//
//    private List<Question> questionList = new ArrayList<Question>();
//    private MyButton[] buttonQuestions;
//    private JTextArea textAreaQuestion;
//    private JLabel lbImage;
//    private List<Answer> answerList;
//    private MyButton[] buttonAnswers = new MyButton[4];
//
//    private int indexQuestion = 0;
//    private int totalNumberAnswered = 0;
//    private int totalQuestion;
//    private long second = 0;
//    private long minute = 0;
//    private Thread thread;
//    private ExamCard result;
//    private Exam exam;
    private Student student;
    private ExamGUI examGUI;

    public void doSetUp()
    {
        examGUI = mainStudentGUI.getExamGUI();

        student = GlobalValues.student;
        examGUI.setInfoAboutStudentToField(student);
    }

//    public void doExam(final ExamCard result, final Exam exam,final Student student) {
////        Long idExam = examCard.getIdExamination();
////        Examination examination = examinationService.findById(idExam);
//
//        this.result = result;
//        this.exam = exam;
//        this.student = student;
//
//        startTime(exam.getTotalTime());
//        mainStudentGUI.getExamGUI().getLbNameExamination().setText(exam.getExamName());
//        mainStudentGUI.getExamGUI().getLbTime().setText(exam.getTotalTime().toString());
//        mainStudentGUI.getExamGUI().getLbNumberQuestion().setText(exam.getTotalNumber().toString());
//        mainStudentGUI.getExamGUI().getLbNameStudent().setText(result.getStudentRelation().getLastName() + " " + result.getStudentRelation().getFirstName());
//        mainStudentGUI.getExamGUI().getLbStudentCode().setText(result.getStudentRelation().getStudentCode());
//        //  mainStudentGUI.getExamGUI().getLbNameSubject().setText(result.get().getNameOfSubject());
//        mainStudentGUI.getExamGUI().getBtnNext().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (indexQuestion < totalQuestion - 1) {    // neu chua phai cau hoi cuoi cung thi moi cho phep next
//                    indexQuestion++;
//                    setQuestionSelected(indexQuestion);
//                }
//            }
//        });
//        mainStudentGUI.getExamGUI().getBtnPrevious().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (indexQuestion > 0) {                     // neu khong phai cau hoi dau tien thi moi cho phep previos
//                    indexQuestion--;
//                    setQuestionSelected(indexQuestion);
//                }
//            }
//        });
//
//        mainStudentGUI.getExamGUI().getBtnSubmit().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                showResultExam();
//            }
//        });
//    }
//
//    private void showResultExam() {
//        int numberCorrectAnswer = 0;
//        for (Question question : questionList) {
//            int count = 0;
//            ExamQuestion examQuestion = examQuestionService.findByQuestionRelationExamQuestionAndExamRelation(question,exam);
//            for (Answer answer : question.getAnswerList()) {
//                if (answer.isStudenSelectted() && answer.isCorrect()) {
//                    numberCorrectAnswer++;
//                    count++;
//
//                }
//            }
// }
//        result.setTotalNumberCorrect((long) numberCorrectAnswer);
//        result.setTotalNumberIncorrect((long) (totalQuestion - numberCorrectAnswer));
//
//        Long markExam = (Long) (long) Math.round((10 / totalQuestion) * numberCorrectAnswer);
//        result.setScore(markExam);
//        result.setTotalNumberNotAnswer(0L);
//        String[] str = mainStudentGUI.getExamGUI().getLbRemainTime().getText().split(":");
//        long timeUse = getInt(str[0]) * 60 + getInt(str[1]);
//        result.setTotalExamTime(exam.getTotalTime() - timeUse);
//        resultService.save(result);
//        JOptionPane.showMessageDialog(null, "Your course : " + numberCorrectAnswer + "/" + totalQuestion + ".");
//        mainStudentController.doShowSettingExamCard();
//
//    }
//
//
//    private void startTime(final long totalTime) {
//        thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                minute = totalTime/60;
//                second = totalTime%60;
//                while (!(minute == 0 && second == 0)) {
//                    try {
//                        Thread.sleep(1000);
//                        if (second == 0) {
//                            second = 60;
//                            minute--;
//                        }
//                        second--;
//                        String textMinute = minute < 10 ? "0" + minute : String.valueOf(minute);
//                        String textSecond = second < 10 ? "0" + second : String.valueOf(second);
//                        mainStudentGUI.getExamGUI().getLbRemainTime().setText(textMinute + ":" + textSecond);
//                    } catch (InterruptedException e) {
//                    }
//                }
//                JOptionPane.showMessageDialog(null, "Time over !");
//                showResultExam();
//            }
//        });
//        thread.start();
//
//    }
//
//    public void showButtonQuestion( Exam exam) {
//        // examCard.setIdExamination(examination.getId());
//        //================== question button ================
//        // doan nay de lay ra 1 list question
//
//        List<ExamQuestion> examQuestionList = examQuestionService.findByExamRelation(exam);
//        for (ExamQuestion examQuestion : examQuestionList) {
//            Question question = examQuestion.getQuestionRelationExamQuestion();
//            questionList.add(question);
//        }
//
//        totalQuestion = questionList.size();
//        // lay ra list cac Answer gan vao tung cau hoi tuong ung
//
//        for (Question question : questionList) {
//            List<Answer> answers = answerService.findByQuestionRelation(question);
//            question.setAnswerList(answers);
//        }
//
//
//        textAreaQuestion = mainStudentGUI.getExamGUI().getTxtContentQuestion();
//
//
//        JPanel panelButtonQuestion = mainStudentGUI.getExamGUI().getPanelButtonQuestion();
//        panelButtonQuestion.setLayout(new GridLayout(0, 3));
//        buttonQuestions = new MyButton[totalQuestion];
//
//        for (int i = 0; i < totalQuestion; i++) {
//            final int index = i + 1;
//            buttonQuestions[i] = new MyButton();
//            buttonQuestions[i].setNameButton(String.valueOf(index));
//            buttonQuestions[i].setText(String.valueOf(index));
//            buttonQuestions[i].setIdQuestion(questionList.get(index - 1).getId());
//            buttonQuestions[i].addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    indexQuestion = getInt(buttonQuestions[index - 1].getNameButton()) - 1;
//                    setQuestionSelected(indexQuestion);
//                    //indexQuestion1++;
//                }
//            });
//            panelButtonQuestion.add(buttonQuestions[i]);
//
//        }
//        showQuestionByIndex(indexQuestion, textAreaQuestion, questionList);
//        panelButtonQuestion.revalidate();
//        panelButtonQuestion.repaint();
//
//
//    }
//
//    private void setQuestionSelected(int indexQuestion) {
//        showQuestionByIndex(indexQuestion, textAreaQuestion, questionList);
//        resetForegroundButtonAnswer();
//    }
//
//    // dat lai foreground cho cac button answer
//    // neu cau tra loi da duoc chon thi dat la mau GRAY
//    // neu cau tra loi chua duoc(khong duoc) chon thi set mau Default.
//    private void resetForegroundButtonAnswer() {
//        for (int i = 0; i < answerList.size(); i++) {
//            if (answerList.get(i).isStudenSelectted()) {
//                buttonAnswers[i].setForegroundColor(Color.GRAY);
//            } else {
//                buttonAnswers[i].setForegroundColor(new JButton().getForeground());
//            }
//        }
//    }
//
//    private void showQuestionByIndex(int indexQuestion, JTextArea textAreaQuestion, List<Question> questionList) {
//        lbImage = mainStudentGUI.getExamGUI().getLbImage();
//        buttonQuestions[indexQuestion].setForegroundColor(Color.RED);
//
//        for (int i = 1; i < totalQuestion; i++) {
//
//            int index = (indexQuestion + i) % totalQuestion;
//            if (buttonQuestions[index].isSelected()) {
//                buttonQuestions[index].setForegroundColor(Color.GREEN);
//            } else {
//                buttonQuestions[index].setForegroundColor(new JButton().getForeground());
//            }
//        }
//
//
//        answerList = questionList.get(indexQuestion).getAnswerList();
//        String textAnswerA = "\nA. " + answerList.get(0).getContent();
//        String textAnswerB = "\nB. " + answerList.get(1).getContent();
//        String textAnswerC = "\nC. " + answerList.get(2).getContent();
//        String textAnswerD = "\nD. " + answerList.get(3).getContent();
//        String textAnswer = textAnswerA + textAnswerB + textAnswerC + textAnswerD;
//        textAreaQuestion.setText(questionList.get(indexQuestion).getContent() + "\n" + textAnswer);
//        if (questionList.get(indexQuestion).getUrlImage() != null) {
//            try {
//                BufferedImage questionImage = ImageIO.read(new File(questionList.get(indexQuestion).getUrlImage()));
//                mainStudentGUI.getExamGUI().getLbImage().setIcon(new ImageIcon(questionImage));
//                mainStudentGUI.getExamGUI().getLbImage().setVisible(true);
//            } catch (IOException e1) {
//                mainStudentGUI.getExamGUI().getLbImage().setVisible(false);
//            }
//        } else {
//            mainStudentGUI.getExamGUI().setVisible(false);
//        }
//    }
//
//    public void showButtonAnswer(Exam exam) {
//        JPanel panelButtonAnswer = mainStudentGUI.getExamGUI().getPanelButtonAnswer();
//        panelButtonAnswer.setLayout(new GridLayout(0, 4));
//
//        for (int i = 0; i < 4; i++) {
//            final int indexAnswer = i;
//            buttonAnswers[i] = new MyButton();
//            buttonAnswers[i].setNameButton(String.valueOf(i));
//            buttonAnswers[i].addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    setStudentSelected(indexAnswer);
//                    questionList.get(indexQuestion).setAnswerList(answerList);
//                }
//            });
//            panelButtonAnswer.add(buttonAnswers[i]);
//        }
//        setLabelButtonAnswer();
//        panelButtonAnswer.revalidate();
//        panelButtonAnswer.repaint();
//    }
//
//
//    // set text cho 4 button answer tuong ung la A, B, C, D.
//    private void setLabelButtonAnswer() {
//        buttonAnswers[0].setText("A");
//        buttonAnswers[1].setText("B");
//        buttonAnswers[2].setText("C");
//        buttonAnswers[3].setText("D");
//    }
//
//    public void setStudentSelected(int indexAnswer) {
//        if (!buttonQuestions[indexQuestion].isSelected()) {    // neu cau hoi chua duoc tra loi moi tang numberAnswered them 1
//            totalNumberAnswered++;
//        }
//
//        setTotalNumberAnswered(totalNumberAnswered);     // edit lai so luong cau hoi da dc tra loi
//
//        // danh dau cho cau tra loi ma sinh vien lua chon
//        answerList.get(indexAnswer).setStudenSelectted(true);
//        buttonAnswers[indexAnswer].setForegroundColor(Color.GRAY);
//        buttonAnswers[indexAnswer].setSelected(true);
//
//
//        // danh dau cac cau tra loi con lai ma sv ko chon
//        for (int i = 1; i <= 3; i++) {
//            int otherButton = (indexAnswer + i) % 4;
//            answerList.get(otherButton).setStudenSelectted(false);
//            buttonAnswers[otherButton].setForegroundColor(new JButton().getForeground());
//        }
//
//        //danh dau rang cau hoi nay sinh vien da tra loi roi
//        buttonQuestions[indexQuestion].setSelected(true);
//    }
//
//
//    // gan lai label so luong cau hoi da tra loi va label so luong cau hoi con lai
//    public void setTotalNumberAnswered(int totalNumberAnswered) {
//        mainStudentGUI.getExamGUI().getLbTotalNumberAnswered().setText(String.valueOf(totalNumberAnswered));
//        mainStudentGUI.getExamGUI().getLbTotalNumberNotAnswerYet().setText(String.valueOf(totalQuestion - totalNumberAnswered));
//    }
//
//    public int getInt(String textInt) {
//        return Integer.parseInt(textInt);
//    }
}
