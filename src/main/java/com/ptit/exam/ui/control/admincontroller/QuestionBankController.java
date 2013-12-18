package com.ptit.exam.ui.control.admincontroller;

import com.ptit.exam.business.AnswerService;
import com.ptit.exam.business.QuestionService;
import com.ptit.exam.business.SubjectService;
import com.ptit.exam.business.common.TableBinding;
import com.ptit.exam.business.common.TextAreaEditor;
import com.ptit.exam.business.common.TextAreaRenderer;
import com.ptit.exam.persistence.entity.Answer;
import com.ptit.exam.persistence.entity.Question;
import com.ptit.exam.persistence.entity.Subject;
import com.ptit.exam.persistence.modelbinding.QuestionDTOBinding;
import com.ptit.exam.ui.view.admin.MainAdminGUI;
import com.ptit.exam.ui.view.admin.NewQuestionGUI;
import com.ptit.exam.ui.view.admin.QuestionBankGUI;
import com.ptit.exam.util.ComboboxManager;
import com.ptit.exam.util.Constants;
import com.ptit.exam.util.GlobalValues;
import com.ptit.exam.util.MessageManager;
import org.jdesktop.observablecollections.ObservableCollections;
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
import java.util.Collections;
import java.util.Comparator;
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

    @Autowired
    SubjectService subjectService;

    private List<QuestionDTOBinding> questionDTOBindingList;
    private List<Question> questionList;
    private JTable tableQuestionBank;
    private JScrollPane scrollQuestionBank;

    private QuestionBankGUI questionBankGUI;
    private NewQuestionGUI newQuestionGUI;
    private List<Subject> subjectList;

    public void doSetUp(Question question)
    {
        questionBankGUI = mainAdminGUI.getQuestionBankGUI();
        newQuestionGUI = mainAdminGUI.getNewQuestionGUI();

        setUpView(question);
        setUpActionListener();
    }

    private void setUpView(Question question)
    {


        tableQuestionBank = questionBankGUI.getTableQuestionBank();
        scrollQuestionBank = questionBankGUI.getQuestionBankScrollPanel();

        subjectList = subjectService.getAll();
        ComboboxManager.setListSubject(questionBankGUI.getComboBoxSubjectName(), subjectList);

        questionBankGUI.getComboBoxLevel().setModel(new DefaultComboBoxModel(Constants.level));
        questionBankGUI.getComboBoxChapter().setModel(new DefaultComboBoxModel(Constants.chapters));

        resetView(question);
    }

    private void resetView(Question question)
    {
        // todo : cho~ nay can reset toan bo TextArea content questions detail va TextField content answer detail
        if (null == question || null == question.getContent())
        {
            questionList = ObservableCollections.observableList(new ArrayList<Question>());
        }
        else
        {
            updateQuestionList(questionList, question);
            Subject subject = subjectService.findBySubjectCode(question.getSubjectCode());
            questionBankGUI.getComboBoxSubjectName().setSelectedItem(subject);
            questionBankGUI.getComboBoxChapter().setSelectedItem(String.valueOf(question.getChapter()));
            questionBankGUI.getComboBoxLevel().setSelectedItem(String.valueOf(question.getLevel()));
        }
        doBindingQuestionBank(questionList, tableQuestionBank, scrollQuestionBank);
    }

    private void updateQuestionList(List<Question> questionList, Question question)
    {
        for (Question questionItem : questionList)
        {
            if (question.getId() == questionItem.getId())
            {
                questionList.remove(questionItem);
                questionList.add(question);
                break;
            }
        }
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
            MessageManager.show("Hãy ch?n 1 câu h?i mà b?n mu?n s?a.");
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
            MessageManager.show("Hãy ch?n 1 câu h?i mà b?n mu?n xóa.");
        }
        else
        {
            int confirm = MessageManager.showConfirm("B?n ch?c ch?n mu?n xóa?");
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
        String subjectName = questionBankGUI.getComboBoxSubjectName().getSelectedItem().toString();
        String chapter = questionBankGUI.getComboBoxChapter().getSelectedItem().toString();
        String level = questionBankGUI.getComboBoxLevel().getSelectedItem().toString();

        List<Question> list1 = ("".equals(subjectName) ? questionService.getAll() : questionService.findBySubjectName(subjectName));
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
                if (null != question.getUrlImage() && !"".equals(question.getUrlImage()))
                {
                    try
                    {
                        BufferedImage questionImage = ImageIO.read(new File(question.getUrlImage()));
                        ImageIcon imageIcon = new ImageIcon(questionImage);
                        Image image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                        mainAdminGUI.getQuestionBankGUI().getLbImage().setIcon(new ImageIcon(image));
                        mainAdminGUI.getQuestionBankGUI().getLbImage().setVisible(true);
                    }
                    catch (IOException e1)
                    {
                        setImageDefault();
                    }
                }
                else
                {
                    setImageDefault();
                }

                List<Answer> answerList = answerService.findByQuestionId(question.getId());
                Collections.sort(answerList, new Comparator<Answer>()
                {
                    public int compare(Answer answer1, Answer answer2)
                    {
                        return answer1.getId().compareTo(answer2.getId());
                    }
                });
                List<JTextArea> txtAnswerList = questionBankGUI.getTxtContentAnswer();
                for (int i = 0; i < 4; i++)
                {
                    txtAnswerList.get(i).setText(answerList.get(i).getContent());
                }
            }
        }

        private void setImageDefault()
        {
            try
            {
                ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/no_image.png"));
                mainAdminGUI.getQuestionBankGUI().getLbImage().setIcon(imageIcon);
                mainAdminGUI.getQuestionBankGUI().getLbImage().setVisible(true);
            }
            catch (Exception e)
            {
                mainAdminGUI.getQuestionBankGUI().getLbImage().setVisible(false);
            }
        }
    };

    private void doBindingQuestionBank(List<Question> questionList, JTable jTable, JScrollPane jScrollPane)
    {
        Collections.sort(questionList, new Comparator<Question>()
        {
            public int compare(Question question1, Question question2)
            {
                return question1.getId().compareTo(question2.getId());
            }
        });

        questionDTOBindingList = ObservableCollections.observableList(new ArrayList<QuestionDTOBinding>());
        for (Question question : questionList)
        {
            Subject subject = subjectService.findBySubjectCode(question.getSubjectCode());

            QuestionDTOBinding questionDTOBinding = new QuestionDTOBinding();
            questionDTOBinding.setSubjectName(subject.getSubjectName());
            questionDTOBinding.setContent(question.getContent());
            questionDTOBinding.setUrlImage(question.getUrlImage());
            questionDTOBinding.setChapter(question.getChapter());
            questionDTOBinding.setLevel(question.getLevel());

            questionDTOBindingList.add(questionDTOBinding);
        }

        TableBinding.bindingQuestionBank(questionDTOBindingList, jTable, jScrollPane);

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
        List<Answer> answerList = answerService.findByQuestionId(question.getId());
        Collections.sort(answerList, new Comparator<Answer>()
        {
            public int compare(Answer answer1, Answer answer2)
            {
                return answer1.getId().compareTo(answer2.getId());
            }
        });
        addQuestionController.doSetUp(question, answerList);
        newQuestionGUI.mappingInfoToField(questionBankGUI.getComboBoxSubjectName().getSelectedIndex(), question, answerList);
    }
}
