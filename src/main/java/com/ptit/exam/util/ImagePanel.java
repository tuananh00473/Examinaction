package com.ptit.exam.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * User: thuongntt
 * Date: 12/17/13
 * Time: 11:56 PM
 */
public class ImagePanel extends JPanel {

    private BufferedImage img;

    public ImagePanel(String imageName) {
        try {
            img = ImageIO.read(getClass().getResource("/images/" + imageName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // paint the background image and scale it to fill the entire space
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}
