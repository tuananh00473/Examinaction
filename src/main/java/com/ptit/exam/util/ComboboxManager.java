package com.ptit.exam.util;

import javax.swing.*;

/**
 * User: anhnt
 * Date: 11/15/13
 * Time: 5:13 PM
 */
public class ComboboxManager
{
    public static void setValue(final JComboBox comboBox, final int minValue, final int maxValue)
    {
        comboBox.removeAllItems();
        for (int i = minValue; i <= maxValue; i++)
        {
            comboBox.addItem(i);
        }
    }
}
