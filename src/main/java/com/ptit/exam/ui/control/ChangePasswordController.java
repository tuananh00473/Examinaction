package com.ptit.exam.ui.control;

import com.ptit.exam.business.AdminService;
import com.ptit.exam.business.StudentService;
import com.ptit.exam.persistence.entity.Admin;
import com.ptit.exam.persistence.entity.Student;
import com.ptit.exam.ui.view.ChangePasswordGUI;
import com.ptit.exam.ui.view.LoginGUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * User: thuongntt
 * Date: 10/30/13
 * Time: 11:51 PM
 */
@Component
public class ChangePasswordController {
    @Autowired
    LoginGUI loginGUI;

    @Autowired
    StudentService studentService;

    @Autowired
    AdminService adminService;

    @Autowired
    ChangePasswordGUI changePasswordGUI;

    public void doChangePassword() {
        String business = loginGUI.getCbxBusiness().getSelectedItem().toString();

        String username = changePasswordGUI.getTxtUsername().getText();
        String currentPassword = changePasswordGUI.getTxtCurrentPassword().getText();
        String newPassword = changePasswordGUI.getTxtNewPassword().getText();
        String confirmNewPassword = changePasswordGUI.getTxtConfirmNewPassword().getText();
        if (business.equals("Student")) {
            changePasswordStudent(username, currentPassword, newPassword, confirmNewPassword);
        } else {
            changePasswordAdmin(username, currentPassword, newPassword, confirmNewPassword);
        }

    }

    private void changePasswordAdmin(String username, String currentPassword, String newPassword, String confirmNewPassword) {
        Admin admin = adminService.findByUserNameAndPassWord(username, currentPassword);
        if (admin != null) {
            if (newPassword.equals(confirmNewPassword)) {
                admin.setPassWord(newPassword);
                Admin admin1 = adminService.save(admin);
                if (admin1 != null) {
                    JOptionPane.showMessageDialog(null, "Bạn đã đổi mật khẩu thành công !");

                    changePasswordGUI.setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "NewPassword và confirmPassword phải giống nhau . Hãy nhập lại !");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Sai username hoặc/ và password. Hãy nhập lại !");
        }
    }


    private void changePasswordStudent(String username, String currentPassword, String newPassword, String confirmNewPassword) {
        Student student = studentService.findByUserNameAndPassWord(username, currentPassword);
        if (student != null) {
            if (newPassword.equals(confirmNewPassword)) {
                student.setPassWord(newPassword);
                Student student1 = studentService.save(student);
                if (student1 != null) {
                    JOptionPane.showMessageDialog(null, "Bạn đã đổi mật khẩu thành công !");
                    loginGUI.show();
                    changePasswordGUI.setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "NewPassword và confirmPassword phải giống nhau . Hãy nhập lại !");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Sai username hoặc/ và password. Hãy nhập lại !");
        }
    }
}



