package com.ptit.exam.ui.control.admincontroller;

import com.ptit.exam.business.AnswerService;
import com.ptit.exam.business.QuestionService;
import com.ptit.exam.business.common.TableBinding;
import com.ptit.exam.business.common.TextAreaEditor;
import com.ptit.exam.business.common.TextAreaRenderer;
import com.ptit.exam.persistence.entity.Answer;
import com.ptit.exam.persistence.entity.Question;
import com.ptit.exam.ui.view.admin.MainAdminGUI;
import com.ptit.exam.ui.view.admin.NewQuestionGUI;
import com.ptit.exam.ui.view.admin.QuestionBankGUI;
import com.ptit.exam.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
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
 * Date: 10/19/13
 * Time: 1:44 AM
 */
@Component
public class QuestionBankController
{
    @Autowired
    MainAdminGUI mainAdminGUI;

    @Autowired
    MainAdminController mainAdminController;

    @Autowired
    AddQuestionController addQuestionController;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    private List<Question> questionList;
    private JTable tableQuestionBank;
    private JScrollPane scrollQuestionBank;

    private QuestionBankGUI questionBankGUI;
    private NewQuestionGUI newQuestionGUI;

    public void doSetUp()
    {
        setUpView();
        setUpActionListener();

        questionList = questionService.getAll();
        doBindingQuestionBank(questionList, tableQuestionBank, scrollQuestionBank);
    }

    private void setUpView()
    {
        questionBankGUI = mainAdminGUI.getQuestionBankGUI();
        newQuestionGUI = mainAdminGUI.getNewQuestionGUI();

        tableQuestionBank = questionBankGUI.getTableQuestionBank();
        scrollQuestionBank = questionBankGUI.getQuestionBankScrollPanel();

        questionBankGUI.getComboBoxLevel().setModel(new DefaultComboBoxModel(Constants.level));
    }

    private void setUpActionListener()
    {
        tableQuestionBank.getSelectionModel().addListSelectionListener(listSelectionListener);

        questionBankGUI.getBtnSearch().addActionListener(actionListener);
        questionBankGUI.getBtnNewQuestion().addActionListener(actionListener);
        questionBankGUI.getBtnDeleteQuestion().addActionListener(actionListener);
        questionBankGUI.getBtnEditQuestion().addActionListener(actionListener);
    }

    public ActionListener actionListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == questionBankGUI.getBtnSearch())
            {
            }
            if (e.getSource() == questionBankGUI.getBtnNewQuestion())
            {
                Question question = new Question();
                List<Answer> answerList = new ArrayList<Answer>();
                answerList.add(new Answer());
                answerList.add(new Answer());
                answerList.add(new Answer());
                answerList.add(new Answer());
                addQuestionController.doSetUp(question, answerList);
                newQuestionGUI.resetNewQuestionGUI();
                mainAdminController.doShowNewQuestionCard();
            }
            if (e.getSource() == questionBankGUI.getBtnDeleteQuestion())
            {
                int indexSelected = tableQuestionBank.getSelectedRow();
                if (-1 == indexSelected)
                {
                    showMessage("Hãy chọn 1 câu hỏi mà bạn muốn xóa.");
                }
                else
                {
                    int select = showConfirmMessage("Bạn chắc chắn muốn xóa?");
                    if (0 == select)
                    {
                        doDeleteQuestion(questionList.get(indexSelected));
                        doBindingQuestionBank(questionList, tableQuestionBank, scrollQuestionBank);
                    }
                }
            }
            if (e.getSource() == questionBankGUI.getBtnEditQuestion())
            {
                int indexSelected = tableQuestionBank.getSelectedRow();
                if (-1 == indexSelected)
                {
                    showMessage("Hãy chọn 1 câu hỏi mà bạn muốn sửa.");
                }
                else
                {
                    doSetUpEditQuestion(questionList.get(indexSelected));
                    mainAdminController.doShowNewQuestionCard();
                }
            }
        }
    };

    private ListSelectionListener listSelectionListener = new ListSelectionListener()
    {
        @Override
        public void valueChanged(ListSelectionEvent e)
        {
            int rowSelected = tableQuestionBank.getSelectedRow();
            if (-1 != rowSelected)
            {
                Question question = questionList.get(rowSelected);
                questionBankGUI.getTxtContentQuestion().setText(question.getContent());

                if (null != question.getUrlImage())
                {
                    try
                    {
                        BufferedImage questionImage = ImageIO.read(new File(question.getUrlImage()));
                        mainAdminGUI.getQuestionBankGUI().getLbImage().setIcon(new ImageIcon(questionImage));
                        mainAdminGUI.getQuestionBankGUI().getLbImage().setVisible(true);
                    }
                    catch (IOException e1)
                    {
                        mainAdminGUI.getQuestionBankGUI().getLbImage().setVisible(false);
                    }
                }

                List<Answer> answerList = answerService.getListAnswer(question.getId());
                List<JTextArea> txtAnswerList = questionBankGUI.getTxtContentAnswer();
                for (int i = 0; i < 4; i++)
                {
                    txtAnswerList.get(i).setText(answerList.get(i).getContent());
                }
            }
        }
    };

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
//                    mainAdminGUI.getQuestionBankGUI().getTxtContentAnswer4().setText(contentAnswer);
//                }
//            }
//        });
//
//    }
//
    private void doBindingQuestionBank(List<Question> questionList, JTable jTable, JScrollPane jScrollPane)
    {
        TableBinding.bindingQuestionBank(questionList, jTable, jScrollPane);

        TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
        TextAreaEditor textEditor = new TextAreaEditor();
        textEditor.setEditAble(false);
        TableColumnModel cmodel = jTable.getColumnModel();
        cmodel.getColumn(0).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(0).setCellEditor(textEditor);
        cmodel.getColumn(1).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(1).setCellEditor(textEditor);
        cmodel.getColumn(2).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(2).setCellEditor(textEditor);
        cmodel.getColumn(3).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(3).setCellEditor(textEditor);
        cmodel.getColumn(4).setCellRenderer(textAreaRenderer);
        cmodel.getColumn(4).setCellEditor(textEditor);


        JTableHeader header = jTable.getTableHeader();
        header.setPreferredSize(new Dimension(10000, 30));
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable.repaint();
    }

    public void doDeleteQuestion(Question question)
    {
        int index = tableQuestionBank.getSelectedRow();
        if (-1 != index)
        {
            question = questionList.get(index);
            questionList.remove(index);
            questionService.delete(question);
        }
        mainAdminGUI.getQuestionBankGUI().resetPreview();
    }

    public void doSetUpEditQuestion(Question question)
    {
        newQuestionGUI.getTxtSubjectCode().setText(question.getSubjectCode());
        newQuestionGUI.getTxtChapter().setText(String.valueOf(question.getChapter()));
        newQuestionGUI.getCbLevel().setModel(new DefaultComboBoxModel(Constants.level));
        newQuestionGUI.getCbLevel().setSelectedIndex(question.getLevel() - 1);
        newQuestionGUI.getTxtContentQues().setText(question.getContent());
        newQuestionGUI.getTxtUrlImage().setText(question.getUrlImage());
        List<Answer> answerList = answerService.getListAnswer(question.getId());
        List<JTextArea> txtAnswerList = newQuestionGUI.getTxtContentAnswer();
        List<JRadioButton> radioButtonList = newQuestionGUI.getRadioButtonList();

        for (int i = 0; i < 4; i++)
        {
            txtAnswerList.get(i).setText(answerList.get(i).getContent());
            radioButtonList.get(i).setSelected(answerList.get(i).isCorrect());
        }
        addQuestionController.doSetUp(question, answerList);
    }

    private void showMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }

    private int showConfirmMessage(String message)
    {
        return JOptionPane.showConfirmDialog(null, message);
    }
}
