package com.ptit.exam.business.common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * User: anhnt
 * Date: 11/21/13
 * Time: 3:48 PM
 */
public class RadioButtonEditor extends DefaultCellEditor implements ItemListener
{
    private JRadioButton button;

    public RadioButtonEditor(JCheckBox checkBox)
    {
        super(checkBox);
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column)
    {
        if (value == null)
        {
            return null;
        }
        button = (JRadioButton) value;
        button.addItemListener(this);
        return (Component) value;
    }

    public Object getCellEditorValue()
    {
        button.removeItemListener(this);
        return button;
    }

    public void itemStateChanged(ItemEvent e)
    {
        super.fireEditingStopped();
    }
}
