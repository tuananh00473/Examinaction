package com.ptit.exam.business.common;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Thuongntt
 * Date: 7/31/13
 * Time: 9:09 AM
 */


public class TextAreaRenderer extends JTextArea
        implements TableCellRenderer {
    private final DefaultTableCellRenderer adaptee =
            new DefaultTableCellRenderer();
    private final Map cellSizes = new HashMap();

    public TextAreaRenderer() {
        setLineWrap(true);
        setWrapStyleWord(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
        // set the colours, etc. using the standard for that platform
        adaptee.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, column);
        setForeground(adaptee.getForeground());
        setBackground(adaptee.getBackground());
        setBorder(adaptee.getBorder());
        setFont(adaptee.getFont());
        setText(adaptee.getText());

        // This line was very important to get it working with JDK1.4
        TableColumnModel columnModel = table.getColumnModel();
        setSize(columnModel.getColumn(column).getWidth(), 100);
        int height_wanted = (int) getPreferredSize().getHeight();

        table.setRowHeight(40);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));


        return this;
    }

}