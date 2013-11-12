package com.ptit.exam.ui.control;

import org.springframework.stereotype.Component;

/**
 * User: thuongntt
 * Date: 9/26/13
 * Time: 10:13 AM
 */
@Component
public class RegistryController {

//    @Autowired
//    StudentService studentService;
//    @Autowired
//    AdminService adminService;
//
//    @Autowired
//    LoginGUI loginGUI;
//    @Autowired
//    RegistryStudentGUI registryStudentGUI;
//    @Autowired
//    RegistryAdminGUI registryAdminGUI;
//
//    public void doStudentCancel() {
//    loginGUI.show();
//    registryStudentGUI.setVisible(false);
//    }
//
//    public void doStudentRegistry() {
//        String firstName = registryStudentGUI.getTxtFirstname().getText();
//        String lastName = registryStudentGUI.getTxtLastname().getText();
//        String studentCode = registryStudentGUI.getTxtStudentCode().getText();
//        String gender = registryStudentGUI.getBtnRadioMale().isSelected()? "Male" : "Female";
//        String dateOfBirth = registryStudentGUI.getComboBoxDay().getSelectedItem().toString() + "/"+ registryStudentGUI.getComboBoxMonth().getSelectedItem().toString() + "/"+ registryStudentGUI.getComboBoxYear().getSelectedItem().toString();
//        String classRoom = registryStudentGUI.getTxtClass().getText();
//        String faculty = registryStudentGUI.getCbBoxFacultyTab2().getSelectedItem().toString();
//        String course = registryStudentGUI.getComboBoxCourse().getSelectedItem().toString();
//        String trainingSystem = registryStudentGUI.getComboBoxTrainingSystem().getSelectedItem().toString();
//        String username = registryStudentGUI.getTxtUsername().getText();
//        String password = registryStudentGUI.getTxtPassword().getText();
//        String confirmPassword = registryStudentGUI.getTxtConfirmPassword().getText();
//
//        if(firstName.isEmpty()|| lastName.isEmpty()||studentCode.isEmpty()|| classRoom.isEmpty()||course.isEmpty()|| username.isEmpty() || password.isEmpty()|| confirmPassword.isEmpty()){
//            doValidateStudentGUI();
//        }else {
//            Student student1 = studentService.findByStudentCode(studentCode);
//            if(student1==null){
//                Student student2 = studentService.findByUserName(username);
//
//                if(student2==null){
//                    if(password.equals(confirmPassword)){
//                        Student student = new Student(firstName,lastName,gender,dateOfBirth,studentCode,classRoom,faculty,course,trainingSystem,username,password);
//                        studentService.save(student);
//                        JOptionPane.showMessageDialog(null,"You registry SUCCESS !!! !!!");
//                        loginGUI.show();
//                    }   else {
//                        JOptionPane.showMessageDialog(null,"Error password !!!");
//                    }
//                }  else {
//                    JOptionPane.showMessageDialog(null,"Username da ton tai, thay username khac");
//                }
//
//            } else {
//                JOptionPane.showMessageDialog(null,"Sinh vien da co tai khoan");
//            }
//        }
//
//
//    }
//
//    private void doValidateStudentGUI() {
//        registryStudentGUI.getLbValidateFistname().setText("(*)");
//        registryStudentGUI.getLbValidateLastname().setText("(*)");
//        registryStudentGUI.getLbValidateStudentCode().setText("(*)");
//        registryStudentGUI.getLbValidateClass().setText("(*)");
//        registryStudentGUI.getLbValidateCourse().setText("(*)");
//        registryStudentGUI.getLbValidateUsername().setText("(*)");
//        registryStudentGUI.getLbValidatePassword().setText("(*)");
//        registryStudentGUI.getLbValidateConfirmPassword().setText("(*)");
//        registryStudentGUI.getLbNote().setText("(*): Can phai nhap dau du");
//    }
//
//    public void doAdminRegistry() {
//        String firstName = registryAdminGUI.getTxtFirstname().getText();
//        String lastName = registryAdminGUI.getTxtLastname().getText();
//        String adminCode = registryAdminGUI.getTxtAdminCode().getText();
//        String gender =  registryAdminGUI.getBtnMale().isSelected()? "Male" : "Female";
//        String dateOfBirth =  registryAdminGUI.getComboBoxDay().getSelectedItem().toString() + "/"+ registryAdminGUI.getComboBoxMonth().getSelectedItem().toString() + "/"+ registryAdminGUI.getComboBoxYear().getSelectedItem().toString();
//        String username = registryAdminGUI.getTxtUsername().getText();
//        String password = registryAdminGUI.getTxtPassword().getText();
//        String confirmPassword = registryAdminGUI.getTxtConfirmPassword().getText();
//        if(firstName.isEmpty()|| lastName.isEmpty()|| adminCode.isEmpty() || username.isEmpty() || password.isEmpty()|| confirmPassword.isEmpty()){
//            doValidateAdminGUI();
//        }else {
//            Admin admin = adminService.findByAdminCode(adminCode);
//            if(admin==null){
//                Admin admin1 = adminService.findByUserName(username);
//                if(admin1==null){
//                    if(password.equals(confirmPassword)){
//                        Admin admin2= new Admin(firstName,lastName, adminCode, gender, dateOfBirth,  username,password);
//                        adminService.save(admin2);
//                        JOptionPane.showMessageDialog(null,"You registry SUCCESS !!! !!!");
//                        loginGUI.show();
//                    }   else {
//                        JOptionPane.showMessageDialog(null,"Error password !!!");
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(null,"Username da ton tai, thay username khac");
//                }
//
//            } else {
//                JOptionPane.showMessageDialog(null,"Admin da co tai khoan");
//            }
//        }
//    }
//
//    private void doValidateAdminGUI() {
//        registryAdminGUI.getLbValidateFirstname().setText("(*)");
//        registryAdminGUI.getLbValidateLastname().setText("(*)");
//        registryAdminGUI.getLbValidateAdminCode().setText("(*)");
//        registryAdminGUI.getLbValidateUsername().setText("(*)");
//        registryAdminGUI.getLbValidatePassword().setText("(*)");
//        registryAdminGUI.getLbValidateConfirmPassword().setText("(*)");
//        registryAdminGUI.getLbNote().setText("(*) : Can nhap du thong tin");
//    }
//
//    public void doAdminCancel() {
//
//        loginGUI.show();
//        registryAdminGUI.setVisible(false);
//    }
}
