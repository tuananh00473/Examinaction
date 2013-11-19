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
import com.ptit.exam.util.GlobalValues;
import com.ptit.exam.util.MessageManager;
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

    private static final int YES = 0;

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
        questionBankGUI.getComboBoxChapter().setModel(new DefaultComboBoxModel(Constants.chapters));
        questionBankGUI.getComboBoxSubjectCode().setModel(new DefaultComboBoxModel(Constants.subjects));
    }

    private void setUpActionListener()
    {
        if (GlobalValues.MANAGEMENT_QUESTION_ADD_ACTION)
        {
            tableQuestionBank.getSelectionModel().addListSelectionListener(listSelectionListener);

            questionBankGUI.getBtnSearch().addActionListener(actionListener);
            questionBankGUI.getBtnNewQuestion().addActionListener(actionListener);
            questionBankGUI.getBtnDeleteQuestion().addActionListener(actionListener);
            questionBankGUI.getBtnEditQuestion().addActionListener(actionListener);
        }
        GlobalValues.MANAGEMENT_QUESTION_ADD_ACTION = false;
    }

    public ActionListener actionListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == questionBankGUI.getBtnSearch())
            {
                doSearchQuestion();
            }
            if (e.getSource() == questionBankGUI.getBtnNewQuestion())
            {
                doAddQuestion();
            }
            if (e.getSource() == questionBankGUI.getBtnDeleteQuestion())
            {
                doDeleteQuestion();
            }
            if (e.getSource() == questionBankGUI.getBtnEditQuestion())
            {
                doEditQuestion();
            }
        }
    };

    private void doEditQuestion()
    {
        int indexSelected = tableQuestionBank.getSelectedRow();
        if (-1 == indexSelected)
        {
            MessageManager.show("Hãy chọn 1 câu hỏi mà bạn muốn sửa.");
        }
        else
        {
            doSetUpEditQuestionGUI(questionList.get(indexSelected));
            mainAdminController.doShowNewQuestionCard();
        }
    }

    private void doDeleteQuestion()
    {
        int select = tableQuestionBank.getSelectedRow();
        if (-1 == select)
        {
            MessageManager.show("Hãy chọn 1 câu hỏi mà bạn muốn xóa.");
        }
        else
        {
            int confirm = MessageManager.showConfirm("Bạn chắc chắn muốn xóa?");
            if (YES == confirm)
            {
                Question question = questionList.get(select);
                answerService.deleteByQuestionId(question.getId());
                questionService.delete(question);
                questionList.remove(select);

                questionBankGUI.resetPreview();
                doBindingQuestionBank(questionList, tableQuestionBank, scrollQuestionBank);
            }
        }
    }

    private void doAddQuestion()
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

    private void doSearchQuestion()
    {
        String subjectCode = questionBankGUI.getComboBoxSubjectCode().getSelectedItem().toString();
        String chapter = questionBankGUI.getComboBoxChapter().getSelectedItem().toString();
        String level = questionBankGUI.getComboBoxLevel().getSelectedItem().toString();

        List<Question> list1 = ("".equals(subjectCode) ? questionService.getAll() : questionService.findBySubjectCode(subjectCode));
        List<Question> list2 = ("".equals(chapter) ? questionService.getAll() : questionService.findByChapter(value(chapter)));
        List<Question> list3 = ("".equals(level) ? questionService.getAll() : questionService.findByLevel(value(level)));

        questionList = new ArrayList<Question>();
        for (Question question : list1)
        {
            if (list2.contains(question) && list3.contains(question))
            {
                questionList.add(question);
            }
        }
        doBindingQuestionBank(questionList, tableQuestionBank, scrollQuestionBank);
    }

    private int value(String text)
    {
        return Integer.parseInt(text);
    }

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
                        ImageIcon imageIcon = new ImageIcon(questionImage);
                        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                        mainAdminGUI.getQuestionBankGUI().getLbImage().setIcon(new ImageIcon(image));
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

    public void doSetUpEditQuestionGUI(Question question)
    {
        List<Answer> answerList = answerService.getListAnswer(question.getId());
        addQuestionController.doSetUp(question, answerList);
        newQuestionGUI.mappingInfoToField(question, answerList);
    }
}
