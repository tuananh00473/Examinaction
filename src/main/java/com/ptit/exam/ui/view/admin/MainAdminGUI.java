package com.ptit.exam.ui.view.admin;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.ptit.exam.ui.control.LoginController;
import com.ptit.exam.ui.control.admincontroller.*;
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
 * Date: 9/28/13
 * Time: 11:17 AM
 */
@Component
public class MainAdminGUI extends JFrame
{
    @Autowired
    MainAdminController mainAdminController;

    @Autowired
    LoginController loginController;

    @Autowired
    LoginGUI loginGUI;

    @Autowired
    QuestionBankController questionBankController;

    @Autowired
    ExportExamController exportExamController;

    @Autowired
    ManagementExamController managementExamController;

    @Autowired
    ManagementSubjectController managementSubjectController;

    @Autowired
    ManagementStudentController managementStudentController;

    private JPanel mainPanel;
    private JButton btnIntroduce;
    private JButton btnQuestionBank;
    private JButton btnManagementExam;
    private JButton btnExportExamination;
    private JButton btnManagementStudent;
    private JButton btnManagementSubject;
    private JPanel AdminCardPanel;
    private JLabel lbLogOut;
    private JLabel lbUsername;
    private QuestionBankGUI questionBankGUI;
    private NewQuestionGUI newQuestionGUI;
    private NewSubjectGUI newSubjectGUI;
    private NewStudentGUI newStudentGUI;
    private ExportExamination exportExaminationGUI;
    private ManagermentExamGUI managermentExamGUI;
    private ManagementSubjectGUI managementSubjectGUI;
    private ManagementStudentGUI managementStudentGUI;

    private CardLayout cardLayout;


    public MainAdminGUI()
    {

        setContentPane(mainPanel);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = (int) tk.getScreenSize().getWidth();
        int ySize = (int) tk.getScreenSize().getHeight() - 50;
        setSize(xSize, ySize);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        lbLogOut.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                loginGUI.setVisible(true);
                MainAdminGUI.this.setVisible(false);
            }
        });

//
//        // ============= button ManagementExamGUI ==========
//        managermentExamGUI.getBtnSearchTab2().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                managementExamController.doSearch();  // todo
//            }
//        });
//        managermentExamGUI.getBtnSaveTab2().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                managementExamController.doSave();  // todo
//            }
//        });
//
//        // ============ button ExportExamGUI ==============
//        exportExaminationGUI.getBtnSave().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                exportExamController.doExportExam();  // todo
//
//            }
//        });
//
        // ============ ManagermentStudentGUI ================
//
//        // ------------------ byClass ---------------
//        managementStudentGUI.getBtnSearchTab2().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                managementStudentController.doSearch();
//
//            }
//        });
//
//        // -------------- bySubject -----------------
//
//        managementStudentGUI.getBtnSearchTab1().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                managementStudentController.doSEARCH();
//            }
//        });
//        managementStudentGUI.getBtnSAVE().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                managementStudentController.doSAVE();
//            }
//        });
//         ============ button MainAdminGUI ================

        btnQuestionBank.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                questionBankController.doSetUp();
                mainAdminController.doShowQuestionBankCard();
            }
        });


        btnManagementExam.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                managementExamController.doSetUp();
                mainAdminController.doShowManagementExamGUI();
            }
        });

        btnExportExamination.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mainAdminController.doShowExportExamCard();
//                exportExamController.showExportExamGUI();
            }
        });

        btnManagementSubject.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                managementSubjectController.doSetUp();
                mainAdminController.doShowManagementSubjectGUI();
            }
        });

        btnManagementStudent.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                managementStudentController.doSetUp();
                mainAdminController.doShowManagementStudentGUI();
            }
        });


        cardLayout = (CardLayout) AdminCardPanel.getLayout();
    }

    public JButton getBtnQuestionBank()
    {
        return btnQuestionBank;
    }

    public JButton getBtnManagementExam()
    {
        return btnManagementExam;
    }

    public ExportExamination getExportExaminationGUI()
    {
        return exportExaminationGUI;
    }

    public ManagermentExamGUI getManagermentExamGUI()
    {
        return managermentExamGUI;
    }

    public JButton getBtnIntroduce()
    {
        return btnIntroduce;
    }

    public ManagementStudentGUI getManagementStudentGUI()
    {
        return managementStudentGUI;
    }

    public ManagementSubjectGUI getManagementSubjectGUI()
    {
        return managementSubjectGUI;
    }


    public QuestionBankGUI getQuestionBankGUI()
    {
        return questionBankGUI;
    }

    public NewQuestionGUI getNewQuestionGUI()
    {
        return newQuestionGUI;
    }

    public CardLayout getCardLayout()
    {
        return cardLayout;
    }

    public JPanel getAdminCardPanel()
    {
        return AdminCardPanel;
    }

    public JLabel getLbUsername()
    {
        return lbUsername;
    }

    public JLabel getLbLogOut()
    {
        return lbLogOut;
    }


    public NewSubjectGUI getNewSubjectGUI()
    {
        return newSubjectGUI;
    }

    public NewStudentGUI getNewStudentGUI()
    {
        return newStudentGUI;
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
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(3, 2, new Insets(10, 10, 10, 10), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        mainPanel.add(panel1, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(7, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel2, BorderLayout.WEST);
        btnIntroduce = new JButton();
        btnIntroduce.setText("Introduce");
        panel2.add(btnIntroduce, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnManagementExam = new JButton();
        btnManagementExam.setText("Quản Lý Đề Thi");
        panel2.add(btnManagementExam, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnExportExamination = new JButton();
        btnExportExamination.setText("Xuất Đề Thi");
        panel2.add(btnExportExamination, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnManagementSubject = new JButton();
        btnManagementSubject.setText("Quản Lý Môn Học");
        panel2.add(btnManagementSubject, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel2.add(spacer1, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        btnQuestionBank = new JButton();
        btnQuestionBank.setText("Ngân Hàng Câu Hỏi");
        panel2.add(btnQuestionBank, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnManagementStudent = new JButton();
        btnManagementStudent.setText("Quản Lý Sinh Viên");
        panel2.add(btnManagementStudent, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        AdminCardPanel = new JPanel();
        AdminCardPanel.setLayout(new CardLayout(0, 0));
        panel1.add(AdminCardPanel, BorderLayout.CENTER);
        questionBankGUI = new QuestionBankGUI();
        AdminCardPanel.add(questionBankGUI.$$$getRootComponent$$$(), "questionBankGUI");
        exportExaminationGUI = new ExportExamination();
        AdminCardPanel.add(exportExaminationGUI.$$$getRootComponent$$$(), "exportExaminationGUI");
        managermentExamGUI = new ManagermentExamGUI();
        AdminCardPanel.add(managermentExamGUI.$$$getRootComponent$$$(), "managermentExamGUI");
        managementSubjectGUI = new ManagementSubjectGUI();
        AdminCardPanel.add(managementSubjectGUI.$$$getRootComponent$$$(), "managementSubjectGUI");
        managementStudentGUI = new ManagementStudentGUI();
        AdminCardPanel.add(managementStudentGUI.$$$getRootComponent$$$(), "managementStudentGUI");
        newQuestionGUI = new NewQuestionGUI();
        AdminCardPanel.add(newQuestionGUI.$$$getRootComponent$$$(), "newQuestionGUI");
        newSubjectGUI = new NewSubjectGUI();
        AdminCardPanel.add(newSubjectGUI.$$$getRootComponent$$$(), "newSubjectGUI");
        newStudentGUI = new NewStudentGUI();
        AdminCardPanel.add(newStudentGUI.$$$getRootComponent$$$(), "newStudentGUI");
        final JLabel label1 = new JLabel();
        label1.setText("Label");
        mainPanel.add(label1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbLogOut = new JLabel();
        lbLogOut.setFont(new Font(lbLogOut.getFont().getName(), Font.BOLD | Font.ITALIC, lbLogOut.getFont().getSize()));
        lbLogOut.setText("Log out");
        mainPanel.add(lbLogOut, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbUsername = new JLabel();
        lbUsername.setFont(new Font(lbUsername.getFont().getName(), Font.BOLD, lbUsername.getFont().getSize()));
        lbUsername.setText("");
        mainPanel.add(lbUsername, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return mainPanel;
    }
}
