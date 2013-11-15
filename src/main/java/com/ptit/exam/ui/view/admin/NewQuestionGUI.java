package com.ptit.exam.ui.view.admin;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.ptit.exam.persistence.entity.Answer;
import com.ptit.exam.persistence.entity.Question;
import com.ptit.exam.ui.control.admincontroller.QuestionBankController;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: thuongntt
 * Date: 10/19/13
 * Time: 2:20 AM
 */
public class NewQuestionGUI extends JPanel
{
    private JTextArea txtContentQues;
    private JTextField txtUrlImage;
    private JButton btnBrowser;
    private JTextArea txtContentAnswer1;
    private JTextArea txtContentAnswer2;
    private JTextArea txtContentAnswer3;
    private JTextArea txtContentAnswer4;
    private JButton btnSave;
    private JPanel newQuestionPanel;
    private JButton btnCancel;
    private JRadioButton rdAnswer1;
    private JRadioButton rdAnswer2;
    private JRadioButton rdAnswer3;
    private JRadioButton rdAnswer4;
    private JTextField txtSubjectCode;
    private JTextField txtChapter;
    private JComboBox cbLevel;

    @Autowired
    QuestionBankController questionBankController;

    public JComboBox getCbLevel()
    {
        return cbLevel;
    }

    public JTextField getTxtChapter()
    {
        return txtChapter;
    }

    public JTextField getTxtSubjectCode()
    {
        return txtSubjectCode;
    }

    public JTextArea getTxtContentQues()
    {
        return txtContentQues;
    }

    public JTextField getTxtUrlImage()
    {
        return txtUrlImage;
    }

    public JButton getBtnBrowser()
    {
        return btnBrowser;
    }

    public JButton getBtnSave()
    {
        return btnSave;
    }

    public JButton getBtnCancel()
    {
        return btnCancel;
    }

    public Question getQuestionInfo(Question question)
    {
        question.setSubjectCode(txtSubjectCode.getText());
        question.setChapter(Integer.parseInt(txtChapter.getText()));
        question.setLevel(Integer.parseInt(cbLevel.getSelectedItem().toString()));
        question.setContent(txtContentQues.getText());
        question.setUrlImage(txtUrlImage.getText());
        return question;
    }

    public Answer getAnswer1(Question question, Answer answer)
    {
        answer.setContent(txtContentAnswer1.getText());
        answer.setCorrect(rdAnswer1.isSelected());
        answer.setQuestionId(question.getId());
        return answer;
    }

    public Answer getAnswer2(Question question, Answer answer)
    {
        answer.setContent(txtContentAnswer2.getText());
        answer.setCorrect(rdAnswer2.isSelected());
        answer.setQuestionId(question.getId());
        return answer;
    }

    public Answer getAnswer3(Question question, Answer answer)
    {
        answer.setContent(txtContentAnswer3.getText());
        answer.setCorrect(rdAnswer3.isSelected());
        answer.setQuestionId(question.getId());
        return answer;
    }

    public Answer getAnswer4(Question question, Answer answer)
    {
        answer.setContent(txtContentAnswer4.getText());
        answer.setCorrect(rdAnswer4.isSelected());
        answer.setQuestionId(question.getId());
        return answer;
    }

    public boolean invalidForm()
    {
        if ("".equals(txtSubjectCode.getText())
                || "".equals(txtChapter.getText())
                || "".equals(txtContentQues.getText())
                || "".equals(txtContentAnswer1.getText())
                || "".equals(txtContentAnswer2.getText())
                || "".equals(txtContentAnswer3.getText())
                || "".equals(txtContentAnswer4.getText()))
        {
            return true;
        }
        return false;
    }

    public List<JTextArea> getTxtContentAnswer()
    {
        List<JTextArea> answerList = new ArrayList<JTextArea>();
        answerList.add(txtContentAnswer1);
        answerList.add(txtContentAnswer2);
        answerList.add(txtContentAnswer3);
        answerList.add(txtContentAnswer4);
        return answerList;
    }

    public List<JRadioButton> getRadioButtonList()
    {
        List<JRadioButton> radioButtonList = new ArrayList<JRadioButton>();
        radioButtonList.add(rdAnswer1);
        radioButtonList.add(rdAnswer2);
        radioButtonList.add(rdAnswer3);
        radioButtonList.add(rdAnswer4);
        return radioButtonList;
    }

    public void resetNewQuestionGUI()
    {
        txtSubjectCode.setText("");
        txtChapter.setText("");
        txtContentQues.setText("");
        txtUrlImage.setText("");
        txtContentAnswer1.setText("");
        txtContentAnswer2.setText("");
        txtContentAnswer3.setText("");
        txtContentAnswer4.setText("");
        rdAnswer1.setSelected(false);
        rdAnswer2.setSelected(false);
        rdAnswer3.setSelected(false);
        rdAnswer4.setSelected(false);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$()
    {
        newQuestionPanel = new JPanel();
        newQuestionPanel.setLayout(new GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("New question :");
        newQuestionPanel.add(label1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(6, 2, new Insets(0, 0, 0, 0), -1, -1));
        newQuestionPanel.add(panel1, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), null));
        final JLabel label2 = new JLabel();
        label2.setText("Nội dung câu hỏi :");
        panel1.add(label2, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Url Image :");
        panel1.add(label3, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Các phương án trả lời :");
        panel1.add(label4, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtContentQues = new JTextArea();
        panel1.add(txtContentQues, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(53, 100), null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel2, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(53, 29), null, 0, false));
        txtUrlImage = new JTextField();
        txtUrlImage.setText("");
        panel2.add(txtUrlImage, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        btnBrowser = new JButton();
        btnBrowser.setText("Browser");
        panel2.add(btnBrowser, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(4, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel3, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(53, 221), null, 0, false));
        panel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-10066330)), null));
        final JLabel label5 = new JLabel();
        label5.setText("Phương án 1:");
        panel3.add(label5, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtContentAnswer1 = new JTextArea();
        panel3.add(txtContentAnswer1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Phương án 2:");
        panel3.add(label6, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtContentAnswer2 = new JTextArea();
        panel3.add(txtContentAnswer2, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Phương án 3:");
        panel3.add(label7, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtContentAnswer3 = new JTextArea();
        txtContentAnswer3.setText("");
        panel3.add(txtContentAnswer3, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Phương án 4:");
        panel3.add(label8, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtContentAnswer4 = new JTextArea();
        panel3.add(txtContentAnswer4, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        rdAnswer1 = new JRadioButton();
        rdAnswer1.setSelected(true);
        rdAnswer1.setText("");
        panel3.add(rdAnswer1, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        rdAnswer2 = new JRadioButton();
        rdAnswer2.setText("");
        panel3.add(rdAnswer2, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        rdAnswer3 = new JRadioButton();
        rdAnswer3.setEnabled(true);
        rdAnswer3.setText("");
        panel3.add(rdAnswer3, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        rdAnswer4 = new JRadioButton();
        rdAnswer4.setText("");
        panel3.add(rdAnswer4, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("Mã môn học:");
        panel1.add(label9, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtSubjectCode = new JTextField();
        panel1.add(txtSubjectCode, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(53, 22), null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("Nội dung thuộc chương:");
        panel1.add(label10, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtChapter = new JTextField();
        txtChapter.setText("");
        panel1.add(txtChapter, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(53, 22), null, 0, false));
        final JLabel label11 = new JLabel();
        label11.setText("Độ khó");
        panel1.add(label11, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cbLevel = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        cbLevel.setModel(defaultComboBoxModel1);
        panel1.add(cbLevel, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(53, 24), null, 0, false));
        final Spacer spacer1 = new Spacer();
        newQuestionPanel.add(spacer1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        newQuestionPanel.add(spacer2, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        newQuestionPanel.add(panel4, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        btnSave = new JButton();
        btnSave.setText("SAVE");
        panel4.add(btnSave, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        panel4.add(spacer3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        btnCancel = new JButton();
        btnCancel.setText("CANCEL");
        panel4.add(btnCancel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ButtonGroup buttonGroup;
        buttonGroup = new ButtonGroup();
        buttonGroup.add(rdAnswer1);
        buttonGroup.add(rdAnswer2);
        buttonGroup.add(rdAnswer3);
        buttonGroup.add(rdAnswer4);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return newQuestionPanel;
    }
}
