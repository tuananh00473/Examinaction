package com.ptit.exam.ui.view.student;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.ptit.exam.ui.control.usercontroller.MainStudentController;
import com.ptit.exam.ui.control.usercontroller.ResultController;
import com.ptit.exam.ui.control.usercontroller.SettingExamController;
import com.ptit.exam.ui.view.LoginGUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * User: thuongntt
 * Date: 10/8/13
 * Time: 10:18 AM
 */
@Component
public class MainStudentGUI extends JFrame {
    private JPanel studentPanel;
    private JButton btnStartExam;
    private JButton btnExamResults;

    private JPanel StudentCardPanel;
    private SettingExamGUI settingExamGUI;
    private ExamGUI examGUI;
    private ResultGUI resultGUI;

    private JLabel lbLogOut;
    private JLabel lbUsername;

    private CardLayout cardLayout;

    @Autowired
    MainStudentController mainStudentController;
    @Autowired
    SettingExamController settingExamController;
    @Autowired
    ResultController resultController;

    @Autowired
    LoginGUI loginGUI;

    public MainStudentGUI() {
        setContentPane(studentPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = (int) tk.getScreenSize().getWidth();
        int ySize = (int) tk.getScreenSize().getHeight() - 50;
        setSize(xSize, ySize);

        lbLogOut.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                loginGUI.setVisible(true);
                MainStudentGUI.this.setVisible(false);
            }
        });

        btnStartExam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingExamController.doSetUp();
                mainStudentController.doShowSettingExamCard();
            }
        });

        btnExamResults.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultController.setUp();
                mainStudentController.doShowResultCard();
            }
        });
//
//        // ================ button SETTING EXAM GUI ==============
//        settingExamGUI.getBtnStart().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                settingExamController.doStart();
//
//            }
//        });
//
//        // ================ button RESULTGUI ========================
//
//        resultGUI.getBtnSearchTab2().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                resultController.doSearch();
//            }
//        });

        cardLayout = (CardLayout) StudentCardPanel.getLayout();
    }

    public ExamGUI getExamGUI() {
        return examGUI;
    }

    public JPanel getStudentCardPanel() {
        return StudentCardPanel;
    }

    public SettingExamGUI getSettingExamGUI() {
        return settingExamGUI;
    }

    public ResultGUI getResultGUI() {
        return resultGUI;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JLabel getLbUsername() {
        return lbUsername;
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
        studentPanel = new JPanel();
        studentPanel.setLayout(new GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        studentPanel.setEnabled(false);
        studentPanel.setFont(new Font(studentPanel.getFont().getName(), Font.BOLD | Font.ITALIC, studentPanel.getFont().getSize()));
        studentPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-16751002)), null));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        studentPanel.add(panel1, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel2, BorderLayout.WEST);
        btnStartExam = new JButton();
        btnStartExam.setText("Bắt Đầu Thi");
        panel2.add(btnStartExam, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnExamResults = new JButton();
        btnExamResults.setText("Xem kết quả thi");
        panel2.add(btnExamResults, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel2.add(spacer1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        StudentCardPanel = new JPanel();
        StudentCardPanel.setLayout(new CardLayout(0, 0));
        StudentCardPanel.setBackground(new Color(-6710785));
        panel1.add(StudentCardPanel, BorderLayout.CENTER);
        StudentCardPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-16737895)), null));
        examGUI = new ExamGUI();
        StudentCardPanel.add(examGUI.$$$getRootComponent$$$(), "examGUI");
        resultGUI = new ResultGUI();
        StudentCardPanel.add(resultGUI.$$$getRootComponent$$$(), "resultGUI");
        settingExamGUI = new SettingExamGUI();
        StudentCardPanel.add(settingExamGUI.$$$getRootComponent$$$(), "settingExamGUI");
        final JLabel label1 = new JLabel();
        label1.setText("Label");
        studentPanel.add(label1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbLogOut = new JLabel();
        lbLogOut.setFont(new Font(lbLogOut.getFont().getName(), Font.BOLD | Font.ITALIC, lbLogOut.getFont().getSize()));
        lbLogOut.setText("Log out");
        studentPanel.add(lbLogOut, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbUsername = new JLabel();
        lbUsername.setFont(new Font(lbUsername.getFont().getName(), Font.BOLD, lbUsername.getFont().getSize()));
        lbUsername.setText("");
        studentPanel.add(lbUsername, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return studentPanel;
    }
}
