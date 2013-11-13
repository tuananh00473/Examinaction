package com.ptit.exam.ui.control.admincontroller;

import com.ptit.exam.business.QuestionService;
import com.ptit.exam.business.common.TableBinding;
import com.ptit.exam.business.common.TextAreaEditor;
import com.ptit.exam.business.common.TextAreaRenderer;
import com.ptit.exam.persistence.entity.Question;
import com.ptit.exam.ui.view.admin.MainAdminGUI;
import com.ptit.exam.ui.view.admin.QuestionBankGUI;
import com.ptit.exam.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * User: thuongntt
 * Date: 10/19/13
 * Time: 1:44 AM
 */
@Component
public class QuestionBankController {
    @Autowired
    MainAdminGUI mainAdminGUI;

    @Autowired
    MainAdminController mainAdminController;

    //    @Autowired
//    SubjectService subjectService;

    @Autowired
    QuestionService questionService;

    //    @Autowired
//    AnswerService answerService;

    //    private List<Subject> subjectList;
    private List<Question> questionList;

    //    private String nameSubject;
//    private String nameDifficult;
//    private Subject subject;
//    private Difficult difficult;
//    private Question currentQuestion;
    private JTable tableQuestionBank;
    private JScrollPane scrollQuestionBank;

    private JComboBox cbLevel;

    private QuestionBankGUI questionBankGUI;


    //
    public void doSetUp() {
        setUpView();
        setUpActionListener();
//        resetQuestionBankGUI();
//        resetComboBoxSubject();
//        resetComboBoxLevelDifficult();
//
//        subjectList = subjectService.getAll();
//        Set<String> stringSet = new HashSet<String>();
//        for (Subject subject : subjectList) {
//            stringSet.add(subject.getSubjectName());
//        }
//
//        for (String s : stringSet) {
//            mainAdminGUI.getQuestionBankGUI().getComboBoxSubject().addItem(s);
//        }

        questionList = questionService.getAll();
        doBindingQuestionBank(questionList, tableQuestionBank, scrollQuestionBank);
    }

    private void setUpActionListener() {
        questionBankGUI.getBtnSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                questionBankController.doSearch();   // todo
            }
        });

        questionBankGUI.getBtnNewQuestion().addActionListener(actionListener);

        questionBankGUI.getBtnDeleteQuestion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                questionBankController.doDeleteQuestion(); // todo
            }
        });

        questionBankGUI.getBtnEditQuestion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                questionBankController.doEditQuestion();     // todo
                mainAdminController.doShowEditQuestionCard();
            }
        });

    }

    public ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == questionBankGUI.getBtnSearch()) {
            }
            if (e.getSource() == questionBankGUI.getBtnNewQuestion()) {
                mainAdminController.doShowNewQuestionCard();
            }
            if (e.getSource() == questionBankGUI.getBtnDeleteQuestion()) {
            }
            if (e.getSource() == questionBankGUI.getBtnEditQuestion()) {
            }
        }
    };

    private void setUpView() {
        questionBankGUI = mainAdminGUI.getQuestionBankGUI();

        tableQuestionBank = questionBankGUI.getTableQuestionBank();
        scrollQuestionBank = questionBankGUI.getQuestionBankScrollPanel();

        cbLevel = questionBankGUI.getComboBoxLevel();
        cbLevel.setModel(new DefaultComboBoxModel(Constants.level));

    }

    //    private void resetQuestionBankGUI() {
//        if(questionList!=null){
//            int x = questionList.size();
//            for(int i = 0; i< x;i++){
//                questionList.remove(questionList.get(0));
//            }
//
//        }
//
//
//        if(tableQuestionBank!=null){
//            doBindingQuestionBank(questionList);
//        }
//        mainAdminGUI.getQuestionBankGUI().getTxtContentQuestion().setText("");
//        mainAdminGUI.getQuestionBankGUI().getTxtContentAnswer().setText("");
//        mainAdminGUI.getQuestionBankGUI().getLbImage().setText("");
//
//    }
//
//
//    private void resetComboBoxSubject() {
//        mainAdminGUI.getQuestionBankGUI().getComboBoxSubject().removeAllItems();
//        mainAdminGUI.getQuestionBankGUI().getComboBoxSubject().addItem("Choose subject ...");
//    }
//
//    private void resetComboBoxLevelDifficult() {
//        mainAdminGUI.getQuestionBankGUI().getComboBoxLevel().removeAllItems();
//        mainAdminGUI.getQuestionBankGUI().getComboBoxLevel().addItem("Choose level difficult ...");
//    }
//
//    public void doSearch() {
//        mainAdminGUI.getQuestionBankGUI().getBtnNewQuestion().setEnabled(true);
//        tableQuestionBank = mainAdminGUI.getQuestionBankGUI().getTableQuestionBank();
//        questionList = ObservableCollections.observableList(new ArrayList<Question>());
//
//        nameSubject = mainAdminGUI.getQuestionBankGUI().getComboBoxSubject().getSelectedItem().toString();
//        subject = subjectService.findBySubjectName(nameSubject);
//        nameDifficult = mainAdminGUI.getQuestionBankGUI().getComboBoxLevel().getSelectedItem().toString();
//        difficult = difficultService.findByDifficultName(nameDifficult);
//
//        questionList = questionService.findBySubjectRelationAndDifficultRelation(subject, difficult);
//        for (Question question : questionList) {
//            List<Answer> answerList = answerService.getListAnswer(question);
//            question.setAnswerList(answerList);
//        }
//
//        doBindingQuestionBank(questionList);
//        tableQuestionBank.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        tableQuestionBank.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                int index = tableQuestionBank.getSelectedRow();
//                if (-1 != index) {
//                    mainAdminGUI.getQuestionBankGUI().getBtnEditQuestion().setEnabled(true);
//                    mainAdminGUI.getQuestionBankGUI().getBtnDeleteQuestion().setEnabled(true);
//                    currentQuestion = questionList.get(index);
//                    String contentQuestion = currentQuestion.getContent();
//                    mainAdminGUI.getQuestionBankGUI().getTxtContentQuestion().setText(contentQuestion);
//                    if (currentQuestion.getUrlImage() != null) {
//                        try {
//                            BufferedImage questionImage = ImageIO.read(new File(currentQuestion.getUrlImage()));
//                            mainAdminGUI.getQuestionBankGUI().getLbImage().setIcon(new ImageIcon(questionImage));
//                            mainAdminGUI.getQuestionBankGUI().getLbImage().setVisible(true);
//                        } catch (IOException e1) {
//                            mainAdminGUI.getQuestionBankGUI().getLbImage().setVisible(false);
//                        }
//                    } else {
//                        mainAdminGUI.getQuestionBankGUI().getLbImage().setVisible(false);
//                    }
//                    List<Answer> answers = currentQuestion.getAnswerList();
//                    String answer1 = "A. " + answers.get(0).getContent();
//                    String answer2 = "B. " + answers.get(1).getContent();
//                    String answer3 = "C. " + answers.get(2).getContent();
//                    String answer4 = "D. " + answers.get(3).getContent();
//                    String contentAnswer = answer1 + "\n" + answer2 + "\n" + answer3 + "\n" + answer4;
//                    mainAdminGUI.getQuestionBankGUI().getTxtContentAnswer().setText(contentAnswer);
//                }
//            }
//        });
//
//    }
//
    private void doBindingQuestionBank(List<Question> questionList, JTable jTable, JScrollPane jScrollPane) {
        TableBinding.bindingQuestionBank(questionList, jTable, jScrollPane);

        TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
        TextAreaEditor textEditor = new TextAreaEditor();
        TableColumnModel cmodel = jTable.getColumnModel();
        cmodel.getColumn(0).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(0).setCellEditor(textEditor);
        cmodel.getColumn(1).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(1).setCellEditor(textEditor);
        cmodel.getColumn(2).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(2).setCellEditor(textEditor);


        JTableHeader header = jTable.getTableHeader();
        header.setPreferredSize(new Dimension(10000, 30));
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable.repaint();
    }
//
//    public void doSaveNewQuestion() {
//        String questionCode = newQuestionGUI.getTxtQuestionCode().getText();
//
//        String contentAnswer1 = newQuestionGUI.getTxtContentAnswer1().getText();
//        String contentAnswer2 = newQuestionGUI.getTxtContentAnswer2().getText();
//        String contentAnswer3 = newQuestionGUI.getTxtContentAnswer3().getText();
//        String contentAnswer4 = newQuestionGUI.getTxtContentAnswer4().getText();
//
//        boolean answerCorrect1 = newQuestionGUI.getRdAnswer1().isSelected() ? true : false;
//        boolean answerCorrect2 = newQuestionGUI.getRdAnswer2().isSelected() ? true : false;
//        boolean answerCorrect3 = newQuestionGUI.getRdAnswer3().isSelected() ? true : false;
//        boolean answerCorrect4 = newQuestionGUI.getRdAnswer4().isSelected() ? true : false;
//
//        String contentQuestion = newQuestionGUI.getTxtContentQues().getText();
//        String urlImage = newQuestionGUI.getTxtUrlImage().getText();
//
//        Question ques = questionService.save(new Question(difficult, subject,questionCode, contentQuestion, urlImage, false));
//        List<Answer> answerList = new ArrayList<Answer>();
//
//        answerList.add(answerService.save(new Answer(answerCorrect1, contentAnswer1, ques)));
//        answerList.add(answerService.save(new Answer(answerCorrect2, contentAnswer2, ques)));
//        answerList.add(answerService.save(new Answer(answerCorrect3, contentAnswer3, ques)));
//        answerList.add(answerService.save(new Answer(answerCorrect4, contentAnswer4, ques)));
//        ques.setAnswerList(answerList);
//        questionList.add(ques);
//        doBindingQuestionBank(questionList);
//        resetNewQuestionGUI();
//    }
//    private void resetNewQuestionGUI() {
//        newQuestionGUI.getTxtContentQues().setText("");
//        newQuestionGUI.getTxtUrlImage().setText("");
//        newQuestionGUI.getTxtContentAnswer1().setText("");
//        newQuestionGUI.getTxtContentAnswer2().setText("");
//        newQuestionGUI.getTxtContentAnswer3().setText("");
//        newQuestionGUI.getTxtContentAnswer4().setText("");
//        newQuestionGUI.getRdAnswer1().setSelected(true);
//        newQuestionGUI.getRdAnswer2().setSelected(false);
//        newQuestionGUI.getRdAnswer3().setSelected(false);
//        newQuestionGUI.getRdAnswer4().setSelected(false);
//
//    }
//
//    public void doDeleteQuestion() {
//        int index = tableQuestionBank.getSelectedRow();
//        if (-1 != index) {
//            currentQuestion = questionList.get(index);
//            questionList.remove(index);
//            questionService.delete(currentQuestion);
//            currentQuestion = null;
//        }
//        mainAdminGUI.getQuestionBankGUI().getTxtContentQuestion().setText("");
//        mainAdminGUI.getQuestionBankGUI().getTxtContentAnswer().setText("");
//        mainAdminGUI.getQuestionBankGUI().getLbImage().setText("");
//    }
//
//    public void doEditQuestion() {
//        int index = tableQuestionBank.getSelectedRow();
//        if (-1 != index) {
//            currentQuestion = questionList.get(index);
//            mainAdminGUI.getEditQuestionGUI().getTxtQuestionCode().setText(currentQuestion.getQuestionCode());
//            mainAdminGUI.getEditQuestionGUI().getTxtEditContentQuestion().setText(currentQuestion.getContent());
//            mainAdminGUI.getEditQuestionGUI().getTxtEditUrlImage().setText(currentQuestion.getUrlImage());
//            List<Answer> answers = currentQuestion.getAnswerList();
//            mainAdminGUI.getEditQuestionGUI().getTxtEditAnswer1().setText(answers.get(0).getContent());
//            mainAdminGUI.getEditQuestionGUI().getTxtEditAnswer2().setText(answers.get(1).getContent());
//            mainAdminGUI.getEditQuestionGUI().getTxtEditAnswer3().setText(answers.get(2).getContent());
//            mainAdminGUI.getEditQuestionGUI().getTxtEditAnswer4().setText(answers.get(3).getContent());
//            setRadioButtonSelect(answers.get(0),  mainAdminGUI.getEditQuestionGUI().getRdEditAnswer1());
//            setRadioButtonSelect(answers.get(1),  mainAdminGUI.getEditQuestionGUI().getRdEditAnswer2());
//            setRadioButtonSelect(answers.get(2),  mainAdminGUI.getEditQuestionGUI().getRdEditAnswer3());
//            setRadioButtonSelect(answers.get(3),  mainAdminGUI.getEditQuestionGUI().getRdEditAnswer4());
//
//        }
//    }
//
//
//    private void setRadioButtonSelect(Answer answer, JRadioButton radioButton) {
//        if (answer.isCorrect()) {
//            radioButton.setSelected(true);
//        } else {
//            radioButton.setSelected(false);
//        }
//    }
//
//    public void doLoadLocation() {
//        JFileChooser chooser = new JFileChooser();
//        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//        int returnVal = chooser.showOpenDialog(mainAdminGUI.getEditQuestionGUI());
//        if (returnVal == JFileChooser.APPROVE_OPTION) {
//            String path = chooser.getSelectedFile().getAbsolutePath();
//            path = path.replaceAll(Matcher.quoteReplacement("\\"), "/");
//            mainAdminGUI.getEditQuestionGUI().getTxtEditUrlImage().setText(path);
//        }
//    }
//    public void doSaveEditQuestion() {
//        currentQuestion.setQuestionCode(mainAdminGUI.getEditQuestionGUI().getTxtQuestionCode().getText());
//        currentQuestion.setContent( mainAdminGUI.getEditQuestionGUI().getTxtEditContentQuestion().getText());
//        currentQuestion.setUrlImage( mainAdminGUI.getEditQuestionGUI().getTxtEditUrlImage().getText());
//        List<Answer> answerList = currentQuestion.getAnswerList();
//        answerList.get(0).setContent( mainAdminGUI.getEditQuestionGUI().getTxtEditAnswer1().getText());
//        answerList.get(0).setCorrect( mainAdminGUI.getEditQuestionGUI().getRdEditAnswer1().isSelected() ? true : false);
//        answerList.get(1).setContent( mainAdminGUI.getEditQuestionGUI().getTxtEditAnswer2().getText());
//        answerList.get(1).setCorrect( mainAdminGUI.getEditQuestionGUI().getRdEditAnswer2().isSelected() ? true : false);
//        answerList.get(2).setContent( mainAdminGUI.getEditQuestionGUI().getTxtEditAnswer3().getText());
//        answerList.get(2).setCorrect( mainAdminGUI.getEditQuestionGUI().getRdEditAnswer3().isSelected() ? true : false);
//        answerList.get(3).setContent( mainAdminGUI.getEditQuestionGUI().getTxtEditAnswer4().getText());
//        answerList.get(3).setCorrect( mainAdminGUI.getEditQuestionGUI().getRdEditAnswer4().isSelected() ? true : false);
//
//        questionService.save(currentQuestion);
//        answerService.save(answerList.get(0));
//        answerService.save(answerList.get(1));
//        answerService.save(answerList.get(2));
//        answerService.save(answerList.get(3));
//
//        doBindingQuestionBank(questionList);
//    }
}
