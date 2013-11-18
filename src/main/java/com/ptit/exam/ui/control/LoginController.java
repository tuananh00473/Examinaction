package com.ptit.exam.ui.control;

import com.ptit.exam.business.AdminService;
import com.ptit.exam.business.StudentService;
import com.ptit.exam.persistence.entity.Admin;
import com.ptit.exam.persistence.entity.Student;
import com.ptit.exam.ui.view.LoginGUI;
import com.ptit.exam.ui.view.admin.MainAdminGUI;
import com.ptit.exam.ui.view.student.MainStudentGUI;
import com.ptit.exam.util.GlobalValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * User: thuongntt
 * Date: 10/1/13
 * Time: 10:49 PM
 */
@Component
public class LoginController
{

    public static final int ADMIN = 0;
    public static final int USER = 1;

    @Autowired
    MainAdminGUI mainAdminGUI;

    @Autowired
    MainStudentGUI mainStudentGUI;

    @Autowired
    StudentService studentService;

    @Autowired
    AdminService adminService;

    @Autowired
    LoginGUI loginGUI;

    public void doStartApp()
    {
        loginGUI.setVisible(true);
    }

    public boolean checkLoginStudent(String userName, String passWord)
    {
        Student student = studentService.findByUserNameAndPassWord(userName, passWord);
        if (null != student)
        {
            GlobalValues.student = student;
            return true;
        }
        return false;
    }

    public boolean checkLoginAdmin(String userName, String passWord)
    {
        Admin admin = adminService.findByUserNameAndPassWord(userName, passWord);
        return null != admin;
    }


    public void doLogin()
    {
        String userName = loginGUI.getTxtUsername().getText();
        String passWord = loginGUI.getTxtPassword().getText();
        switch (loginGUI.getCbxBusiness().getSelectedIndex())
        {
            case ADMIN:
                loginForAdmin(userName, passWord);
                break;
            case USER:
                loginForUser(userName, passWord);
                break;
        }
    }

    private void loginForUser(String userName, String passWord)
    {
        if (checkLoginStudent(userName, passWord))
        {
            mainStudentGUI.getLbUsername().setText("Hi ! " + userName);
            mainStudentGUI.setVisible(true);
            loginGUI.setVisible(false);
        }
        else
        {
            showMessage("Username and/or password inCORRECT !!!");
        }
    }

    private void loginForAdmin(String userName, String passWord)
    {
        if (checkLoginAdmin(userName, passWord))
        {
            mainAdminGUI.getLbUsername().setText("Hi ! " + userName);
            mainAdminGUI.setVisible(true);
            loginGUI.setVisible(false);
        }
        else
        {
            showMessage("Username and/or password inCORRECT !!!");
        }
    }

    public void showMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }

    public void doQuit()
    {
        System.exit(0);
    }
}
