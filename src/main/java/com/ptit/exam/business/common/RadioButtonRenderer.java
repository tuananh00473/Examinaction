package com.ptit.exam.business.common;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * User: anhnt
 * Date: 11/21/13
 * Time: 3:49 PM
 */
public class RadioButtonRenderer implements TableCellRenderer
{
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column)
    {
        if (value == null)
        {
            return null;
        }
        return (Component) value;
    }
}
