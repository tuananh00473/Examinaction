package com.ptit.exam.ui.view.admin;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.ptit.exam.ui.control.*;
import com.ptit.exam.ui.control.admincontroller.MainAdminController;
import com.ptit.exam.ui.view.LoginGUI;
import com.ptit.exam.ui.view.student.ManagementStudentGUI;
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
public class MainAdminGUI extends JFrame {

    @Autowired
    MainAdminController mainAdminController;


    @Autowired
    LoginController loginController;

    @Autowired
    LoginGUI loginGUI;

    @Autowired
    RegistryController registryController;

    @Autowired
    QuestionBankController questionBankController;

    @Autowired
    NewQuestionGUI newQuestionGUI;

    @Autowired
    ExportExamController exportExamController;

    @Autowired
    ManagementExamController managementExamController;

    @Autowired
    ManagementSubjectController managementSubjectController;

    @Autowired
    ManagementStudentController managementStudentController;

    @Autowired
    NewSubjectGUI newSubjectGUI;

    @Autowired
    NewStudentGUI newStudentGUI;


    private JPanel mainPanel;
    private JButton btnIntroduce;
    private JButton btnQuestionBank;
    private JButton btnManagementExam;
    private JButton btnExportExamination;
    private JButton btnManagementSubject;
    private JPanel AdminCardPanel;
    private JLabel lbLogOut;
    private JLabel lbUsername;
    private QuestionBankGUI questionBankGUI;
    private EditQuestionGUI editQuestionGUI;
    private ExportExamination exportExaminationGUI;
    private ManagermentExamGUI managermentExamGUI;
    private ManagementSubjectGUI managementSubjectGUI;
    private JButton btnManagementStudent;
    private ManagementStudentGUI managementStudentGUI;
    private EditSubjectGUI editSubjectGUI;
    private EditStudentGUI editStudentGUI;


    private CardLayout cardLayout;


    public MainAdminGUI() {

        setContentPane(mainPanel);
        setSize(900, 650);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        lbLogOut.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                loginGUI.setVisible(true);
                MainAdminGUI.this.setVisible(false);
            }
        });
        // ============ button QuestionBankGUI ==============

//        questionBankGUI.getBtnSearch().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                questionBankController.doSearch();   // todo
//            }
//        });
//
//        questionBankGUI.getBtnNewQuestion().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                newQuestionGUI.show();
//            }
//        });
//
//        questionBankGUI.getBtnDeleteQuestion().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                questionBankController.doDeleteQuestion(); // todo
//            }
//        });
//
//        questionBankGUI.getBtnEditQuestion().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                questionBankController.doEditQuestion();     // todo
//                mainAdminController.doShowEditQuestionCard();
//            }
//        });
//
//        // ------------------ EditQuestionGUI----------------
//        editQuestionGUI.getBtnCancel().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mainAdminController.doShowQuestionBankCard();
//            }
//        });
//
//        editQuestionGUI.getBtnEditBrowser().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                questionBankController.doLoadLocation();   // todo
//            }
//        });
//
//        editQuestionGUI.getBtnSaveTab2().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                questionBankController.doSaveEditQuestion();   // todo
//                mainAdminController.doShowQuestionBankCard();
//            }
//        });
//
//        // ============= button ManagementExamGUI ==========
//        managermentExamGUI.getBtnSearch().addActionListener(new ActionListener() {
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
//        exportExaminationGUI.getBtnExportExam().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                exportExamController.doExportExam();  // todo
//
//            }
//        });
//
        // =========== button ManagementSubjectGUI ===========
        // ---------------- xap xep mon thi ===========

        managementSubjectGUI.getBtnSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                managementSubjectController.doSearch();  // todo
            }
        });

        managementSubjectGUI.getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                managementSubjectController.doAdd();   // todo
            }
        });

        managementSubjectGUI.getBtnDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                managementSubjectController.doDelete();       // todo
            }
        });
        managementSubjectGUI.getBtnSaveTab2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                managementSubjectController.doSave();    // todo
            }
        });
//
        // -------------------- quan ly mon thi ----------------
        managementSubjectGUI.getBtnSEARCH().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                managementSubjectController.doSearchSubject();   // todo
            }
        });


//
//        // ---------------- EditSubjectGUI-------------
//
//        editSubjectGUI.getBtnSaveTab2().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                managementSubjectController.doSaveEditSubject();
//                mainAdminController.doShowManagementSubjectGUI();
//            }
//        });
//        editSubjectGUI.getBtnCancel().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mainAdminController.doShowManagementSubjectGUI();
//            }
//        });
//
//        // ============ ManagermentStudentGUI ================
//
//        // ------------------ byClass ---------------
//        managementStudentGUI.getBtnSearch().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                managementStudentController.doSearch();
//
//            }
//        });
//        managementStudentGUI.getBtnAdd().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                newStudentGUI.show();
//
//            }
//        });
//        managementStudentGUI.getBtnEdit().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mainAdminController.doShowEditStudentGUI();
//                managementStudentController.doEdit();
//
//            }
//        });
//        managementStudentGUI.getBtnDel().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                managementStudentController.doDelete();
//
//            }
//        });
//
//        // --------------button EditStudentGUI -------------
//        editStudentGUI.getBtnOk().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                managementStudentController.doSaveEditStudent();
//                mainAdminController.doShowManagementStudentGUI();
//            }
//        });
//        editStudentGUI.getBtnCancel().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mainAdminController.doShowManagementStudentGUI();
//            }
//        });
//
//        // -------------- bySubject -----------------
//
//        managementStudentGUI.getBtnSEARCH().addActionListener(new ActionListener() {
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
        // ============ button MainAdminGUI ================

//        btnQuestionBank.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                mainAdminController.doShowQuestionBankCard();
//                questionBankController.showQuestionBankGUI();
//            }
//        });

//        btnExportExamination.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mainAdminController.doShowExportExamCard();
//                exportExamController.showExportExamGUI();
//            }
//        });

//        btnManagementExam.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mainAdminController.doShowManagementExamGUI();
//                managementExamController.doSetUp();
//            }
//        });

        btnManagementSubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainAdminController.doShowManagementSubjectGUI();
                managementSubjectController.doSetUp();
            }
        });

//        btnManagementStudent.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mainAdminController.doShowManagementStudentGUI();
//                managementStudentController.doSetUp();
//            }
//        });


        cardLayout = (CardLayout) AdminCardPanel.getLayout();
    }

    public JButton getBtnQuestionBank() {
        return btnQuestionBank;
    }

    public JButton getBtnManagementExam() {
        return btnManagementExam;
    }

    public ExportExamination getExportExaminationGUI() {
        return exportExaminationGUI;
    }

    public ManagermentExamGUI getManagermentExamGUI() {
        return managermentExamGUI;
    }

    public JButton getBtnIntroduce() {
        return btnIntroduce;
    }

    public EditStudentGUI getEditStudentGUI() {
        return editStudentGUI;
    }

    public ManagementStudentGUI getManagementStudentGUI() {
        return managementStudentGUI;
    }

    public ManagementSubjectGUI getManagementSubjectGUI() {
        return managementSubjectGUI;
    }


    public QuestionBankGUI getQuestionBankGUI() {
        return questionBankGUI;
    }

    public EditQuestionGUI getEditQuestionGUI() {
        return editQuestionGUI;
    }

    public EditSubjectGUI getEditSubjectGUI() {
        return editSubjectGUI;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }


    public JPanel getAdminCardPanel() {
        return AdminCardPanel;
    }


    public JLabel getLbUsername() {
        return lbUsername;
    }

    public JLabel getLbLogOut() {
        return lbLogOut;
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
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
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
        editQuestionGUI = new EditQuestionGUI();
        AdminCardPanel.add(editQuestionGUI.$$$getRootComponent$$$(), "editQuestionGUI");
        exportExaminationGUI = new ExportExamination();
        AdminCardPanel.add(exportExaminationGUI.$$$getRootComponent$$$(), "exportExaminationGUI");
        managermentExamGUI = new ManagermentExamGUI();
        AdminCardPanel.add(managermentExamGUI.$$$getRootComponent$$$(), "managermentExamGUI");
        managementSubjectGUI = new ManagementSubjectGUI();
        AdminCardPanel.add(managementSubjectGUI.$$$getRootComponent$$$(), "managementSubjectGUI");
        managementStudentGUI = new ManagementStudentGUI();
        AdminCardPanel.add(managementStudentGUI.$$$getRootComponent$$$(), "managementStudentGUI");
        editSubjectGUI = new EditSubjectGUI();
        AdminCardPanel.add(editSubjectGUI.$$$getRootComponent$$$(), "editSubjectGUI");
        editStudentGUI = new EditStudentGUI();
        AdminCardPanel.add(editStudentGUI.$$$getRootComponent$$$(), "editStudentGUI");
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
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
