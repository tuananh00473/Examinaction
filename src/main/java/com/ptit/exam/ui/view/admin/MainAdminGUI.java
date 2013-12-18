package com.ptit.exam.ui.view.admin;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.ptit.exam.business.StudentService;
import com.ptit.exam.io.ExcelManager;
import com.ptit.exam.persistence.entity.Student;
import com.ptit.exam.ui.control.LoginController;
import com.ptit.exam.ui.control.admincontroller.*;
import com.ptit.exam.ui.view.ChangePasswordGUI;
import com.ptit.exam.ui.view.LoginGUI;
import com.ptit.exam.util.FileChooserManager;
import com.ptit.exam.util.ImagePanel;
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
public class MainAdminGUI extends JFrame
{
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
    private IntroduceAdminGUI introduceAdminGUI;
    private JPanel headerPanel;
    private JPanel controlPanel;


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


    public MainAdminGUI()
    {
        $$$setupUI$$$();
        setContentPane(mainPanel);

        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = (int) tk.getScreenSize().getWidth();
        int ySize = (int) tk.getScreenSize().getHeight() - 50;
        setSize(xSize, ySize);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initMenuBar();

        lbLogOut.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                loginGUI.setVisible(true);
                MainAdminGUI.this.setVisible(false);
            }
        });

        btnQuestionBank.addActionListener(actionListener);
        btnManagementExam.addActionListener(actionListener);
        btnExportExamination.addActionListener(actionListener);
        btnManagementSubject.addActionListener(actionListener);
        btnManagementStudent.addActionListener(actionListener);

        cardLayout = (CardLayout) AdminCardPanel.getLayout();
    }

    private ActionListener actionListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == btnQuestionBank)
            {
                questionBankController.doSetUp(null);
                mainAdminController.doShowQuestionBankCard();
            }
            if (e.getSource() == btnManagementExam)
            {
                managementExamController.doSetUp(null);
                mainAdminController.doShowManagementExamGUI();
            }
            if (e.getSource() == btnExportExamination)
            {
                exportExamController.doSetUp();
                mainAdminController.doShowExportExamCard();
            }
            if (e.getSource() == btnManagementSubject)
            {
                managementSubjectController.doSetUp();
                mainAdminController.doShowManagementSubjectGUI();
            }
            if (e.getSource() == btnManagementStudent)
            {
                managementStudentController.doSetUp();
                mainAdminController.doShowManagementStudentGUI();
            }
        }
    };

    public NewExaminationGUI getNewExaminationGUI()
    {
        return newExaminationGUI;
    }

    public ManagementExamGUI getManagementExamGUI()
    {
        return managementExamGUI;
    }

    public ManagementStudentGUI getManagementStudentGUI()
    {
        return managementStudentGUI;
    }

    public ManagementSubjectGUI getManagementSubjectGUI()
    {
        return managementSubjectGUI;
    }

    public ExportExamGUI getExportExamGUI()
    {
        return exportExamGUI;
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

    public NewSubjectGUI getNewSubjectGUI()
    {
        return newSubjectGUI;
    }

    public NewStudentGUI getNewStudentGUI()
    {
        return newStudentGUI;
    }

    public void initMenuBar()
    {
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

    private void setMenuItem(JMenu menuFile)
    {
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

    private ActionListener menuItemListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == menuItemQuit)
            {
                System.exit(0);
            }
            if (e.getSource() == menuItemImportStudent)
            {
                String pathFile = FileChooserManager.getFile(MainAdminGUI.this);
                if (checkValidFile(pathFile))
                {
                    List<Student> studentList = ExcelManager.readData(pathFile);
                    for (Student student : studentList)
                    {
                        studentService.save(student);
                    }
                    MessageManager.show("Đã thêm thành công " + studentList.size() + " sinh viên vào danh sách quản lý.");
                }
                else
                {
                    MessageManager.show("File nhập vào không hợp lệ.");
                }
                return;
            }
            if (e.getSource() == menuItemExportStudent)
            {
                String pathLocation = FileChooserManager.getPath(MainAdminGUI.this);
                System.out.println(pathLocation);
                return;
            }
        }
    };

    private boolean checkValidFile(String pathFile)
    {
        //todo : check xem cai file vua nhap vao co phai file excel ko
        //todo : check xem cac gia tri cua file excel co phu hop hay ko
        return true;
    }

    private void createUIComponents()
    {
        mainPanel = new ImagePanel("background_content.jpg");
        headerPanel = new ImagePanel("header_image.png");
        controlPanel = new ImagePanel("background_sub_panel.jpg");
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
        createUIComponents();
        mainPanel.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), null));
        headerPanel.setLayout(new FormLayout("fill:d:grow,left:4dlu:noGrow,fill:max(d;4px):noGrow", "center:max(d;4px):noGrow,top:4dlu:noGrow,center:96px:grow"));
        mainPanel.add(headerPanel, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        lbLogOut = new JLabel();
        lbLogOut.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        lbLogOut.setForeground(new Color(-3407872));
        lbLogOut.setText("Log out");
        CellConstraints cc = new CellConstraints();
        headerPanel.add(lbLogOut, new CellConstraints(3, 3, 1, 1, CellConstraints.RIGHT, CellConstraints.DEFAULT, new Insets(0, 0, 0, 20)));
        lbUsername = new JLabel();
        lbUsername.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbUsername.setForeground(new Color(-3407872));
        lbUsername.setHorizontalAlignment(4);
        lbUsername.setHorizontalTextPosition(0);
        lbUsername.setMaximumSize(new Dimension(250, 37));
        lbUsername.setMinimumSize(new Dimension(250, 37));
        lbUsername.setPreferredSize(new Dimension(250, 37));
        lbUsername.setText("");
        headerPanel.add(lbUsername, new CellConstraints(3, 1, 1, 1, CellConstraints.RIGHT, CellConstraints.DEFAULT, new Insets(20, 0, 0, 20)));
        final JScrollPane scrollPane1 = new JScrollPane();
        mainPanel.add(scrollPane1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new FormLayout("fill:d:grow,left:4dlu:noGrow,fill:d:grow", "center:max(d;4px):noGrow,top:4dlu:noGrow,center:d:noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow"));
        scrollPane1.setViewportView(panel1);
        AdminCardPanel = new JPanel();
        AdminCardPanel.setLayout(new CardLayout(0, 0));
        AdminCardPanel.setInheritsPopupMenu(true);
        AdminCardPanel.setMaximumSize(new Dimension(600, 560));
        AdminCardPanel.setMinimumSize(new Dimension(600, 560));
        AdminCardPanel.setPreferredSize(new Dimension(600, 560));
        panel1.add(AdminCardPanel, cc.xy(3, 3, CellConstraints.DEFAULT, CellConstraints.FILL));
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
        introduceAdminGUI = new IntroduceAdminGUI();
        AdminCardPanel.add(introduceAdminGUI.$$$getRootComponent$$$(), "introduceAdminGUI");
        questionBankGUI = new QuestionBankGUI();
        AdminCardPanel.add(questionBankGUI.$$$getRootComponent$$$(), "questionBankGUI");
        controlPanel.setLayout(new GridLayoutManager(6, 1, new Insets(0, 10, 0, 10), -1, -1));
        controlPanel.setMaximumSize(new Dimension(100, 560));
        controlPanel.setMinimumSize(new Dimension(100, 560));
        controlPanel.setPreferredSize(new Dimension(100, 560));
        controlPanel.setRequestFocusEnabled(true);
        panel1.add(controlPanel, cc.xy(1, 3, CellConstraints.FILL, CellConstraints.FILL));
        controlPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), null));
        btnManagementExam = new JButton();
        btnManagementExam.setBorderPainted(false);
        btnManagementExam.setContentAreaFilled(false);
        btnManagementExam.setIcon(new ImageIcon(getClass().getResource("/images/exam_manager.png")));
        btnManagementExam.setMargin(new Insets(0, 0, 0, 0));
        btnManagementExam.setText("");
        controlPanel.add(btnManagementExam, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(60, 25), null, 0, false));
        btnExportExamination = new JButton();
        btnExportExamination.setBorderPainted(false);
        btnExportExamination.setContentAreaFilled(false);
        btnExportExamination.setIcon(new ImageIcon(getClass().getResource("/images/export_exam.png")));
        btnExportExamination.setMargin(new Insets(0, 0, 0, 0));
        btnExportExamination.setText("");
        controlPanel.add(btnExportExamination, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(60, 25), null, 0, false));
        btnManagementSubject = new JButton();
        btnManagementSubject.setBorderPainted(false);
        btnManagementSubject.setContentAreaFilled(false);
        btnManagementSubject.setIcon(new ImageIcon(getClass().getResource("/images/subject_manager.png")));
        btnManagementSubject.setMargin(new Insets(0, 0, 0, 0));
        btnManagementSubject.setText("");
        controlPanel.add(btnManagementSubject, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(60, 25), null, 0, false));
        final Spacer spacer1 = new Spacer();
        controlPanel.add(spacer1, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(109, 14), null, 0, false));
        btnQuestionBank = new JButton();
        btnQuestionBank.setBorderPainted(false);
        btnQuestionBank.setContentAreaFilled(false);
        btnQuestionBank.setIcon(new ImageIcon(getClass().getResource("/images/question_store.png")));
        btnQuestionBank.setLabel("");
        btnQuestionBank.setMargin(new Insets(0, 0, 0, 0));
        btnQuestionBank.setText("");
        controlPanel.add(btnQuestionBank, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(60, 25), null, 0, false));
        btnManagementStudent = new JButton();
        btnManagementStudent.setBorderPainted(false);
        btnManagementStudent.setContentAreaFilled(false);
        btnManagementStudent.setHorizontalAlignment(0);
        btnManagementStudent.setIcon(new ImageIcon(getClass().getResource("/images/student_manager.png")));
        btnManagementStudent.setMargin(new Insets(0, 0, 0, 0));
        btnManagementStudent.setText("");
        controlPanel.add(btnManagementStudent, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(60, 25), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return mainPanel;
    }
}
