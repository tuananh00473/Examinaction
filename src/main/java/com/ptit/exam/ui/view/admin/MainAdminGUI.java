package com.ptit.exam.ui.view.admin;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.ptit.exam.business.StudentService;
import com.ptit.exam.io.ExcelManager;
import com.ptit.exam.persistence.entity.Student;
import com.ptit.exam.ui.control.LoginController;
import com.ptit.exam.ui.control.admincontroller.*;
import com.ptit.exam.ui.view.ChangePasswordGUI;
import com.ptit.exam.ui.view.LoginGUI;
import com.ptit.exam.util.FileChooserManager;
import com.ptit.exam.util.MessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

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
    ChangePasswordGUI changePasswordGUI;

    @Autowired
    QuestionBankController questionBankController;

    @Autowired
    NewExamController newExamController;

    @Autowired
    ExportExamController exportExamController;

    @Autowired
    ManagementExamController managementExamController;

    @Autowired
    ManagementSubjectController managementSubjectController;

    @Autowired
    ManagementStudentController managementStudentController;

    @Autowired
    StudentService studentService;

    private JPanel mainPanel;
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
    private NewExaminationGUI newExaminationGUI;
    private ManagementExamGUI managementExamGUI;
    private ManagementSubjectGUI managementSubjectGUI;
    private ManagementStudentGUI managementStudentGUI;
    private ExportExamGUI exportExamGUI;


    //    menu
    private JMenuBar menuBar;

    private JMenu menuFile;
    private JMenu menuTools;
    private JMenu menuOptions;
    private JMenu menuHelps;

    private JMenuItem menuItemImportStudent;
    private JMenuItem menuItemExportStudent;
    private JMenuItem menuItemQuit;


    private CardLayout cardLayout;


    public MainAdminGUI() {
        $$$setupUI$$$();
        setContentPane(mainPanel);

        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = (int) tk.getScreenSize().getWidth();
        int ySize = (int) tk.getScreenSize().getHeight() - 50;
        setSize(xSize, ySize);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initMenuBar();

        lbLogOut.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                loginGUI.setVisible(true);
                MainAdminGUI.this.setVisible(false);
            }
        });

        lbUsername.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                changePasswordGUI.setVisible(true);
            }
        });

        btnQuestionBank.addActionListener(actionListener);
        btnManagementExam.addActionListener(actionListener);
        btnExportExamination.addActionListener(actionListener);
        btnManagementSubject.addActionListener(actionListener);
        btnManagementStudent.addActionListener(actionListener);

        cardLayout = (CardLayout) AdminCardPanel.getLayout();
    }

    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnQuestionBank) {
                questionBankController.doSetUp(null);
                mainAdminController.doShowQuestionBankCard();
            }
            if (e.getSource() == btnManagementExam) {
                managementExamController.doSetUp(null);
                mainAdminController.doShowManagementExamGUI();
            }
            if (e.getSource() == btnExportExamination) {
                exportExamController.doSetUp();
                mainAdminController.doShowExportExamCard();
            }
            if (e.getSource() == btnManagementSubject) {
                managementSubjectController.doSetUp();
                mainAdminController.doShowManagementSubjectGUI();
            }
            if (e.getSource() == btnManagementStudent) {
                managementStudentController.doSetUp();
                mainAdminController.doShowManagementStudentGUI();
            }
        }
    };

    public NewExaminationGUI getNewExaminationGUI() {
        return newExaminationGUI;
    }

    public ManagementExamGUI getManagementExamGUI() {
        return managementExamGUI;
    }

    public ManagementStudentGUI getManagementStudentGUI() {
        return managementStudentGUI;
    }

    public ManagementSubjectGUI getManagementSubjectGUI() {
        return managementSubjectGUI;
    }

    public ExportExamGUI getExportExamGUI() {
        return exportExamGUI;
    }

    public QuestionBankGUI getQuestionBankGUI() {
        return questionBankGUI;
    }

    public NewQuestionGUI getNewQuestionGUI() {
        return newQuestionGUI;
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

    public NewSubjectGUI getNewSubjectGUI() {
        return newSubjectGUI;
    }

    public NewStudentGUI getNewStudentGUI() {
        return newStudentGUI;
    }

    public void initMenuBar() {
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        setMenuItem(menuFile);
        menuTools = new JMenu("Tools");
        menuOptions = new JMenu("Options");
        menuHelps = new JMenu("Helps");
        menuBar.add(menuFile);
        menuBar.add(menuTools);
        menuBar.add(menuOptions);
        menuBar.add(menuHelps);
        this.setJMenuBar(menuBar);
    }

    private void setMenuItem(JMenu menuFile) {
        menuItemImportStudent = new JMenuItem("Import student from excel");
        menuItemExportStudent = new JMenuItem("Export student to excel");
        menuItemQuit = new JMenuItem("Quit");

        menuItemQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        menuItemQuit.addActionListener(menuItemListener);

        menuItemImportStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        menuItemImportStudent.addActionListener(menuItemListener);

        menuItemExportStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        menuItemExportStudent.addActionListener(menuItemListener);

        menuFile.add(menuItemImportStudent);
        menuFile.add(menuItemExportStudent);
        menuFile.add(menuItemQuit);
    }

    private ActionListener menuItemListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == menuItemQuit) {
                System.exit(0);
            }
            if (e.getSource() == menuItemImportStudent) {
                String pathFile = FileChooserManager.getFile(MainAdminGUI.this);
                if (checkValidFile(pathFile)) {
                    List<Student> studentList = ExcelManager.readData(pathFile);
                    for (Student student : studentList) {
                        studentService.save(student);
                    }
                    MessageManager.show("Đã thêm thành công " + studentList.size() + " sinh viên vào danh sách quản lý.");
                } else {
                    MessageManager.show("File nhập vào không hợp lệ.");
                }
                return;
            }
            if (e.getSource() == menuItemExportStudent) {
                String pathLocation = FileChooserManager.getPath(MainAdminGUI.this);
                System.out.println(pathLocation);
                return;
            }
        }
    };

    private boolean checkValidFile(String pathFile) {
        //todo : check xem cai file vua nhap vao co phai file excel ko
        //todo : check xem cac gia tri cua file excel co phu hop hay ko
        return true;
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
        mainPanel.setLayout(new GridLayoutManager(3, 2, new Insets(10, 10, 10, 10), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        mainPanel.add(panel1, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(6, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel2, BorderLayout.WEST);
        btnManagementExam = new JButton();
        btnManagementExam.setText("Quản Lý Đề Thi");
        panel2.add(btnManagementExam, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnExportExamination = new JButton();
        btnExportExamination.setText("Xuất Đề Thi");
        panel2.add(btnExportExamination, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnManagementSubject = new JButton();
        btnManagementSubject.setText("Quản Lý Môn Học");
        panel2.add(btnManagementSubject, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel2.add(spacer1, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        btnQuestionBank = new JButton();
        btnQuestionBank.setText("Ngân Hàng Câu Hỏi");
        panel2.add(btnQuestionBank, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnManagementStudent = new JButton();
        btnManagementStudent.setText("Quản Lý Sinh Viên");
        panel2.add(btnManagementStudent, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        AdminCardPanel = new JPanel();
        AdminCardPanel.setLayout(new CardLayout(0, 0));
        panel1.add(AdminCardPanel, BorderLayout.CENTER);
        questionBankGUI = new QuestionBankGUI();
        AdminCardPanel.add(questionBankGUI.$$$getRootComponent$$$(), "questionBankGUI");
        newExaminationGUI = new NewExaminationGUI();
        AdminCardPanel.add(newExaminationGUI.$$$getRootComponent$$$(), "newExaminationGUI");
        managementExamGUI = new ManagementExamGUI();
        AdminCardPanel.add(managementExamGUI.$$$getRootComponent$$$(), "managementExamGUI");
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
        exportExamGUI = new ExportExamGUI();
        AdminCardPanel.add(exportExamGUI.$$$getRootComponent$$$(), "exportExamGUI");
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
