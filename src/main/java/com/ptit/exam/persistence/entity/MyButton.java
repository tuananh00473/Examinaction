package com.ptit.exam.persistence.entity;

import javax.swing.*;
import java.awt.*;

/**
 * User: thuongntt
 * Date: 10/4/13
 * Time: 3:34 PM
 */
public class MyButton extends JButton {
    private Long id;
    private Long idQuestion;
    private String nameButton;
    private Color myColor;
    private boolean selected;

    public MyButton() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getNameButton() {
        return nameButton;
    }

    public void setNameButton(String nameButton) {
        this.nameButton = nameButton;
        this.setName(nameButton);
    }

    public void setForegroundColor(Color myColor) {
        this.myColor = myColor;
        setBackground(myColor);
    }

    public Color getForegroundColor() {
        return this.myColor;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
