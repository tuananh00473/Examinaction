package com.ptit.exam.util;

import com.ptit.exam.persistence.entity.Exam;
import com.ptit.exam.persistence.entity.Subject;

import javax.swing.*;
import java.util.List;

/**
 * User: anhnt
 * Date: 11/15/13
 * Time: 5:13 PM
 */
public class ComboboxManager {
    public static void setValue(final JComboBox comboBox, final int minValue, final int maxValue) {
        comboBox.removeAllItems();
        for (int i = minValue; i <= maxValue; i++) {
            comboBox.addItem(i);
        }
    }

    public static void setListSubject(JComboBox comboBox, List<Subject> subjectList) {
        if (subjectList.size() == 0) {
            resetCombobox(comboBox);
            return;
        }
        Subject[] subjects = new Subject[subjectList.size()];

        for (int i = 0; i < subjectList.size(); i++) {
            subjects[i] = subjectList.get(i);
        }
        comboBox.setModel(new DefaultComboBoxModel(subjects));
    }

    public static void setListExam(JComboBox comboBox, List<Exam> examList) {
        if (examList.size() == 0) {
            resetCombobox(comboBox);
            return;
        }
        Exam[] exams = new Exam[examList.size()];

        for (int i = 0; i < examList.size(); i++) {
            exams[i] = examList.get(i);
        }

        comboBox.setModel(new DefaultComboBoxModel(exams));
    }

    public static void resetCombobox(JComboBox comboBox) {
        comboBox.setModel(new DefaultComboBoxModel(new String[]{}));
    }
}
