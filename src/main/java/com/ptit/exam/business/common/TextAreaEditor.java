package com.ptit.exam.business.common;

/**
 * User: Thuongntt
 * Date: 7/31/13
 * Time: 9:09 AM
 */

import javax.swing.*;

public class TextAreaEditor extends DefaultCellEditor
{
    public final JTextArea textArea;

    public TextAreaEditor()
    {
        super(new JTextField());
        textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(null);
        editorComponent = scrollPane;

        delegate = new EditorDelegate()
        {
            public void setValue(final Object value)
            {
                textArea.setText((value != null) ? value.toString() : "");
            }

            public Object getCellEditorValue()
            {
                return textArea.getText();
            }
        };
    }

    public void setEditAble(boolean isCanEdit)
    {
        textArea.setEditable(isCanEdit);
    }
}
