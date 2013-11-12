package com.ptit.exam;

import com.ptit.exam.ui.control.LoginController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//        QuestionService questionService = (QuestionService) context.getBean("questionService");
//        System.out.println(questionService.findById(1L).getContent());
//        ManagerController managerController = context.getBean(ManagerController.class);
//        managerController.showManagerGUI();
        LoginController loginController = context.getBean(LoginController.class);
        loginController.doStartApp();
//        MainAdminController mainAdminController = context.getBean(MainAdminController.class);
//        mainAdminController.doStartApp();
    }
}
