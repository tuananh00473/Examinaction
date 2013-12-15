package com.ptit.exam.ui.view.admin;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;

/**
 * User: thuongntt
 * Date: 12/5/13
 * Time: 1:46 AM
 */
public class ExportExamGUI extends JPanel {
    private JButton btnCancel;
    private JButton btnExport;
    private JPanel exportExamCard;
    private JPanel contentPanel;
    private JComboBox cbSubjectName;
    private JComboBox cbExamName;
    private JButton btnGenerateExam;

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnExport() {
        return btnExport;
    }

    public JComboBox getCbSubjectName() {
        return cbSubjectName;
    }

    public JComboBox getCbExamName() {
        return cbExamName;
    }

    public JButton getBtnGenerateExam() {
        return btnGenerateExam;
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
        exportExamCard = new JPanel();
        exportExamCard.setLayout(new GridLayoutManager(4, 5, new Insets(0, 0, 0, 0), -1, -1));
        final JScrollPane scrollPane1 = new JScrollPane();
        exportExamCard.add(scrollPane1, new GridConstraints(2, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        scrollPane1.setViewportView(contentPanel);
        btnExport = new JButton();
        btnExport.setText("XUẤT RA FILE");
        exportExamCard.add(btnExport, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        exportExamCard.add(spacer1, new GridConstraints(3, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, new Dimension(76, 11), null, 0, false));
        btnCancel = new JButton();
        btnCancel.setText("HỦY");
        exportExamCard.add(btnCancel, new GridConstraints(3, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Chọn môn thi");
        exportExamCard.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(76, 14), null, 0, false));
        cbSubjectName = new JComboBox();
        exportExamCard.add(cbSubjectName, new GridConstraints(0, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Chọn đề thi");
        exportExamCard.add(label2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cbExamName = new JComboBox();
        exportExamCard.add(cbExamName, new GridConstraints(1, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnGenerateExam = new JButton();
        btnGenerateExam.setText("TẠO ĐỀ THI");
        exportExamCard.add(btnGenerateExam, new GridConstraints(1, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return exportExamCard;
    }
}
