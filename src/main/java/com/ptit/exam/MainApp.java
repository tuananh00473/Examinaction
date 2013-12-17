package com.ptit.exam;

import com.ptit.exam.ui.control.LoginController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        LoginController loginController = context.getBean(LoginController.class);
        loginController.doStartApp();
    }
}
