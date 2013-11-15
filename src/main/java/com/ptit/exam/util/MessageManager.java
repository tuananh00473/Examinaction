package com.ptit.exam.util;

import javax.swing.*;

/**
 * User: thuongntt
 * Date: 11/16/13
 * Time: 5:25 AM
 */
public class MessageManager {
    public static void show(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static int showConfirm(String message) {
        return JOptionPane.showConfirmDialog(null, message);
    }
}
