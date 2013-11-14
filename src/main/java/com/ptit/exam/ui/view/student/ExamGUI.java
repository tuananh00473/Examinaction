package com.ptit.exam.ui.view.student;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

/**
 * User: thuongntt
 * Date: 10/1/13
 * Time: 9:52 AM
 */
public class ExamGUI extends JPanel {

    private JPanel examCard;
    private JLabel lbNameExamination;
    private JLabel lbNameStudent;
    private JLabel lbStudentCode;
    private JLabel lbNameSubject;
    private JLabel lbTime;
    private JLabel lbNumberQuestion;
    private JButton btnPrevious;
    private JButton btnNext;
    private JButton btnAnswerA;
    private JButton btnAnswerB;
    private JButton btnAnswerC;
    private JButton btnAnswerD;
    private JButton btnSubmit;
    private JLabel lbRemainTime;
    private JPanel panelButtonQuestion;
    private JPanel panelButtonAnswer;
    private JLabel lbTotalNumberAnswered;
    private JLabel lbTotalNumberNotAnswerYet;
    private JScrollPane contentQuestionScrollpanel;
    private JTextArea txtContentQuestion;
    private JLabel lbImage;

    public JPanel getPanelButtonQuestion() {
        return panelButtonQuestion;
    }


    public JButton getBtnAnswerA() {
        return btnAnswerA;
    }

    public JTextArea getTxtContentQuestion() {
        return txtContentQuestion;
    }

    public JLabel getLbImage() {
        return lbImage;
    }

    public JButton getBtnAnswerB() {
        return btnAnswerB;
    }

    public JButton getBtnAnswerC() {
        return btnAnswerC;
    }

    public JButton getBtnAnswerD() {
        return btnAnswerD;
    }

    public JPanel getExamCard() {
        return examCard;
    }

    public JLabel getLbNameExamination() {
        return lbNameExamination;
    }

    public JLabel getLbNameStudent() {
        return lbNameStudent;
    }

    public JLabel getLbStudentCode() {
        return lbStudentCode;
    }

    public JLabel getLbNameSubject() {
        return lbNameSubject;
    }

    public JLabel getLbTime() {
        return lbTime;
    }

    public JLabel getLbNumberQuestion() {
        return lbNumberQuestion;
    }

    public JButton getBtnPrevious() {
        return btnPrevious;
    }

    public JButton getBtnNext() {
        return btnNext;
    }

    public JButton getBtnSubmit() {
        return btnSubmit;
    }

    public JLabel getLbRemainTime() {
        return lbRemainTime;
    }

    public JPanel getPanelButtonAnswer() {
        return panelButtonAnswer;
    }

    public JLabel getLbTotalNumberAnswered() {
        return lbTotalNumberAnswered;
    }

    public JLabel getLbTotalNumberNotAnswerYet() {
        return lbTotalNumberNotAnswerYet;
    }

    public JScrollPane getContentQuestionScrollpanel() {
        return contentQuestionScrollpanel;
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
    private void $$$setupUI$$$() {
        examCard = new JPanel();
        examCard.setLayout(new CardLayout(0, 0));
        examCard.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-13421773)), null));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        examCard.add(panel1, "Card1");
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FormLayout("fill:d:grow,left:4dlu:noGrow,fill:d:grow,left:4dlu:noGrow,fill:d:grow,left:4dlu:noGrow,fill:d:grow", "center:d:grow,top:4dlu:noGrow,center:d:grow,top:4dlu:noGrow,center:d:grow"));
        panel1.add(panel2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        final JLabel label1 = new JLabel();
        label1.setText("Tên môn thi :");
        CellConstraints cc = new CellConstraints();
        panel2.add(label1, cc.xy(1, 1));
        final JLabel label2 = new JLabel();
        label2.setText("Mã sinh viên :");
        panel2.add(label2, cc.xy(1, 5));
        lbNameStudent = new JLabel();
        lbNameStudent.setText("");
        panel2.add(lbNameStudent, cc.xy(3, 3));
        final JLabel label3 = new JLabel();
        label3.setText("Họ và tên sinh viên :");
        panel2.add(label3, cc.xy(1, 3));
        lbStudentCode = new JLabel();
        lbStudentCode.setText("");
        panel2.add(lbStudentCode, cc.xy(3, 5));
        final JLabel label4 = new JLabel();
        label4.setText("Tên kỳ thi :");
        panel2.add(label4, cc.xy(5, 1));
        final JLabel label5 = new JLabel();
        label5.setText("Thời gian làm bài thi :");
        panel2.add(label5, cc.xy(5, 3));
        final JLabel label6 = new JLabel();
        label6.setText("Tổng số câu hỏi :");
        panel2.add(label6, cc.xy(5, 5));
        lbTime = new JLabel();
        lbTime.setText("");
        panel2.add(lbTime, cc.xy(7, 3));
        lbNumberQuestion = new JLabel();
        lbNumberQuestion.setText("");
        panel2.add(lbNumberQuestion, cc.xy(7, 5));
        lbNameExamination = new JLabel();
        lbNameExamination.setText("");
        panel2.add(lbNameExamination, cc.xy(7, 1));
        lbNameSubject = new JLabel();
        lbNameSubject.setText("");
        panel2.add(lbNameSubject, cc.xy(3, 1));
        final Spacer spacer1 = new Spacer();
        panel1.add(spacer1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel3, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), null));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel3.add(panel4, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Câu hỏi :");
        panel4.add(label7, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        panel4.add(scrollPane1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        panelButtonQuestion = new JPanel();
        panelButtonQuestion.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        scrollPane1.setViewportView(panelButtonQuestion);
        final Spacer spacer2 = new Spacer();
        panel4.add(spacer2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        panel4.add(spacer3, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel3.add(panel5, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel5.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-10066330)), null));
        btnPrevious = new JButton();
        btnPrevious.setIcon(new ImageIcon(getClass().getResource("/images/previous.jpg")));
        btnPrevious.setText("");
        panel5.add(btnPrevious, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel5.add(panel6, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panelButtonAnswer = new JPanel();
        panelButtonAnswer.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel6.add(panelButtonAnswer, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panelButtonAnswer.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-13421773)), null));
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel6.add(panel7, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel7.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-13421773)), null));
        final JPanel panel8 = new JPanel();
        panel8.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel7.add(panel8, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Thời gian còn lại :");
        panel8.add(label8, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbRemainTime = new JLabel();
        lbRemainTime.setText("");
        panel8.add(lbRemainTime, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel9 = new JPanel();
        panel9.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel7.add(panel9, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("Số câu đã làm: ");
        panel9.add(label9, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("Số câu chưa làm :");
        panel9.add(label10, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbTotalNumberAnswered = new JLabel();
        lbTotalNumberAnswered.setText("Label");
        panel9.add(lbTotalNumberAnswered, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbTotalNumberNotAnswerYet = new JLabel();
        lbTotalNumberNotAnswerYet.setText("Label");
        panel9.add(lbTotalNumberNotAnswerYet, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnNext = new JButton();
        btnNext.setIcon(new ImageIcon(getClass().getResource("/images/next.jpg")));
        btnNext.setText("");
        panel5.add(btnNext, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel10 = new JPanel();
        panel10.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel3.add(panel10, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        btnSubmit = new JButton();
        btnSubmit.setText("SUBMIT");
        panel10.add(btnSubmit, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        panel10.add(spacer4, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        panel10.add(spacer5, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JScrollPane scrollPane2 = new JScrollPane();
        panel3.add(scrollPane2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel11 = new JPanel();
        panel11.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        scrollPane2.setViewportView(panel11);
        lbImage = new JLabel();
        lbImage.setText("");
        panel11.add(lbImage, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtContentQuestion = new JTextArea();
        txtContentQuestion.setText("");
        panel11.add(txtContentQuestion, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return examCard;
    }
}