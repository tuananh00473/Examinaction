package com.ptit.exam.ui.view.admin;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.ptit.exam.persistence.entity.Student;

import javax.swing.*;
import java.awt.*;

/**
 * User: thuongntt
 * Date: 10/23/13
 * Time: 11:17 PM
 */
public class NewStudentGUI extends JPanel
{
    private JPanel studentPanel;
    private JTextField txtFirstname;
    private JButton btnCancel;
    private JButton btnSave;
    private JTextField txtLastname;
    private JTextField txtStudentCode;
    private JRadioButton btnRadioMale;
    private JRadioButton btnRadioFemale;
    private JComboBox comboBoxDay;
    private JComboBox comboBoxMonth;
    private JComboBox comboBoxYear;
    private JTextField txtClass;
    private JComboBox comboBoxFaculty;
    private JComboBox comboBoxTrainingSystem;
    private JComboBox comboBoxCourse;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JPasswordField txtConfirmPassword;
    private JLabel lbValidateFistname;
    private JLabel lbValidateLastname;
    private JLabel lbValidateStudentCode;
    private JLabel lbValidateClass;
    private JLabel lbValidateCourse;
    private JLabel lbValidateUsername;
    private JLabel lbValidatePassword;
    private JLabel lbValidateConfirmPassword;
    private JLabel lbNote;

    public JButton getBtnCancel()
    {
        return btnCancel;
    }

    public JButton getBtnSave()
    {
        return btnSave;
    }

    public JComboBox getComboBoxDay()
    {
        return comboBoxDay;
    }

    public JComboBox getComboBoxMonth()
    {
        return comboBoxMonth;
    }

    public JComboBox getComboBoxYear()
    {
        return comboBoxYear;
    }

    public JComboBox getComboBoxFaculty()
    {
        return comboBoxFaculty;
    }

    public JComboBox getComboBoxTrainingSystem()
    {
        return comboBoxTrainingSystem;
    }

    public JComboBox getComboBoxCourse()
    {
        return comboBoxCourse;
    }

    public boolean invalidForm()
    {
        if ("".equals(txtStudentCode.getText())
                || "".equals(txtFirstname.getText())
                || "".equals(txtLastname.getText())
                || "".equals(txtClass.getText())
                || "".equals(txtUsername.getText())
                || "".equals(txtPassword.getText())
                || "".equals(txtConfirmPassword.getText())
                || !txtPassword.getText().equals(txtConfirmPassword.getText())
                || "".equals(comboBoxCourse.getSelectedItem().toString())
                || "".equals(comboBoxFaculty.getSelectedItem().toString())
                || "".equals(comboBoxTrainingSystem.getSelectedItem().toString()))
        {
            return true;
        }
        return false;
    }

    public Student getSubjectInfo(Student student)
    {
        student.setStudentCode(txtStudentCode.getText());
        student.setFirstName(txtFirstname.getText());
        student.setLastName(txtLastname.getText());
        student.setClassRoom(txtClass.getText());
        student.setGender(getGender());
        student.setCourse(comboBoxCourse.getSelectedItem().toString());
        student.setFaculty(comboBoxFaculty.getSelectedItem().toString());
        student.setTrainingType(comboBoxTrainingSystem.getSelectedItem().toString());
        student.setUserName(txtUsername.getText());
        student.setPassWord(txtPassword.getText());
        student.setDateOfBirth(getDateOfBirth());
        return student;
    }

    private String getDateOfBirth()
    {
        String day = comboBoxDay.getSelectedItem().toString();
        String month = comboBoxMonth.getSelectedItem().toString();
        String year = comboBoxYear.getSelectedItem().toString();
        return day + "/" + month + "/" + year;
    }

    private String getGender()
    {
        if (btnRadioMale.isSelected())
        {
            return "nam";
        }
        else
        {
            return "nữ";
        }
    }

    public void setInfoSubject(Student student)
    {
        txtFirstname.setText(student.getFirstName());
        txtLastname.setText(student.getLastName());
        txtClass.setText(student.getClassRoom());
        txtStudentCode.setText(student.getStudentCode());
        txtUsername.setText(student.getUserName());
        txtPassword.setText(student.getPassWord());
        txtConfirmPassword.setText(student.getPassWord());

        setGender(student.getGender());

        comboBoxCourse.setSelectedItem(student.getCourse());
        comboBoxFaculty.setSelectedItem(student.getFaculty());
        comboBoxTrainingSystem.setSelectedItem(student.getTrainingType());

        setDateOfBirth(student.getDateOfBirth());
    }

    private void setDateOfBirth(String dateOfBirth)
    {
        String[] arg = dateOfBirth.split("/");
        comboBoxDay.setSelectedItem(arg[0]);
        comboBoxMonth.setSelectedItem(arg[1]);
        comboBoxYear.setSelectedItem(arg[2]);
    }

    private void setGender(String gender)
    {
        if ("nam".equals(gender))
        {
            btnRadioMale.setSelected(true);
            btnRadioFemale.setSelected(false);
        }
        if ("nữ".equals(gender))
        {
            btnRadioMale.setSelected(false);
            btnRadioFemale.setSelected(true);
        }
    }

    public void resetForm()
    {
        txtLastname.setText("");
        txtFirstname.setText("");
        txtClass.setText("");
        txtStudentCode.setText("");
        txtPassword.setText("");
        txtConfirmPassword.setText("");
        txtUsername.setText("");

        btnRadioMale.setSelected(false);
        btnRadioFemale.setSelected(false);

        comboBoxCourse.setSelectedIndex(0);
        comboBoxDay.setSelectedIndex(0);
        comboBoxMonth.setSelectedIndex(0);
        comboBoxFaculty.setSelectedIndex(0);
        comboBoxYear.setSelectedIndex(0);
        comboBoxTrainingSystem.setSelectedIndex(0);
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
        studentPanel = new JPanel();
        studentPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        studentPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-10066330)), null));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new CardLayout(0, 0));
        studentPanel.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), null));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel1.add(panel2, "Card1");
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(14, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel2.add(panel3);
        final JLabel label1 = new JLabel();
        label1.setText("First Name :");
        panel3.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtFirstname = new JTextField();
        panel3.add(txtFirstname, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Last Name :");
        panel3.add(label2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Student Code:");
        panel3.add(label3, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Gender :");
        panel3.add(label4, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Date Of Birth :");
        panel3.add(label5, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Class :");
        panel3.add(label6, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Faculty :");
        panel3.add(label7, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Course :");
        panel3.add(label8, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("Training System");
        panel3.add(label9, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("Username :");
        panel3.add(label10, new GridConstraints(9, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label11 = new JLabel();
        label11.setText("Password :");
        panel3.add(label11, new GridConstraints(10, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label12 = new JLabel();
        label12.setText("Confirm Password:");
        panel3.add(label12, new GridConstraints(11, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel3.add(panel4, new GridConstraints(12, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        btnCancel = new JButton();
        btnCancel.setText("HỦY");
        panel4.add(btnCancel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel4.add(spacer1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        btnSave = new JButton();
        btnSave.setText("LƯU");
        panel4.add(btnSave, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtLastname = new JTextField();
        panel3.add(txtLastname, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        txtStudentCode = new JTextField();
        txtStudentCode.setText("");
        panel3.add(txtStudentCode, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel3.add(panel5, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        btnRadioMale = new JRadioButton();
        btnRadioMale.setSelected(true);
        btnRadioMale.setText("Male");
        panel5.add(btnRadioMale, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        panel5.add(spacer2, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        btnRadioFemale = new JRadioButton();
        btnRadioFemale.setText("Female");
        panel5.add(btnRadioFemale, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new GridLayoutManager(1, 7, new Insets(0, 0, 0, 0), -1, -1));
        panel3.add(panel6, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label13 = new JLabel();
        label13.setText("Day");
        panel6.add(label13, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        panel6.add(spacer3, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        comboBoxDay = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        comboBoxDay.setModel(defaultComboBoxModel1);
        panel6.add(comboBoxDay, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label14 = new JLabel();
        label14.setText("Month");
        panel6.add(label14, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBoxMonth = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        comboBoxMonth.setModel(defaultComboBoxModel2);
        panel6.add(comboBoxMonth, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label15 = new JLabel();
        label15.setText("Year");
        panel6.add(label15, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBoxYear = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel();
        comboBoxYear.setModel(defaultComboBoxModel3);
        panel6.add(comboBoxYear, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtClass = new JTextField();
        panel3.add(txtClass, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        comboBoxFaculty = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel4 = new DefaultComboBoxModel();
        comboBoxFaculty.setModel(defaultComboBoxModel4);
        panel3.add(comboBoxFaculty, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBoxTrainingSystem = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel5 = new DefaultComboBoxModel();
        comboBoxTrainingSystem.setModel(defaultComboBoxModel5);
        panel3.add(comboBoxTrainingSystem, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtUsername = new JTextField();
        txtUsername.setText("");
        panel3.add(txtUsername, new GridConstraints(9, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        txtPassword = new JPasswordField();
        panel3.add(txtPassword, new GridConstraints(10, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        txtConfirmPassword = new JPasswordField();
        panel3.add(txtConfirmPassword, new GridConstraints(11, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        lbValidateFistname = new JLabel();
        lbValidateFistname.setForeground(new Color(-65536));
        lbValidateFistname.setText("");
        panel3.add(lbValidateFistname, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbValidateLastname = new JLabel();
        lbValidateLastname.setForeground(new Color(-65536));
        lbValidateLastname.setText("");
        panel3.add(lbValidateLastname, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbValidateStudentCode = new JLabel();
        lbValidateStudentCode.setForeground(new Color(-65536));
        lbValidateStudentCode.setText("");
        panel3.add(lbValidateStudentCode, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbValidateClass = new JLabel();
        lbValidateClass.setForeground(new Color(-65536));
        lbValidateClass.setText("");
        panel3.add(lbValidateClass, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbValidateCourse = new JLabel();
        lbValidateCourse.setForeground(new Color(-65536));
        lbValidateCourse.setText("");
        panel3.add(lbValidateCourse, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbValidateUsername = new JLabel();
        lbValidateUsername.setForeground(new Color(-65536));
        lbValidateUsername.setText("");
        panel3.add(lbValidateUsername, new GridConstraints(9, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbValidatePassword = new JLabel();
        lbValidatePassword.setForeground(new Color(-65536));
        lbValidatePassword.setText("");
        panel3.add(lbValidatePassword, new GridConstraints(10, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbValidateConfirmPassword = new JLabel();
        lbValidateConfirmPassword.setForeground(new Color(-65536));
        lbValidateConfirmPassword.setText("");
        panel3.add(lbValidateConfirmPassword, new GridConstraints(11, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lbNote = new JLabel();
        lbNote.setFont(new Font(lbNote.getFont().getName(), Font.ITALIC, lbNote.getFont().getSize()));
        lbNote.setForeground(new Color(-65536));
        lbNote.setText("");
        panel3.add(lbNote, new GridConstraints(13, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBoxCourse = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel6 = new DefaultComboBoxModel();
        comboBoxCourse.setModel(defaultComboBoxModel6);
        panel3.add(comboBoxCourse, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ButtonGroup buttonGroup;
        buttonGroup = new ButtonGroup();
        buttonGroup.add(btnRadioMale);
        buttonGroup.add(btnRadioFemale);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return studentPanel;
    }
}
