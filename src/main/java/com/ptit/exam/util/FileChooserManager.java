package com.ptit.exam.util;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;

/**
 * User: thuongntt
 * Date: 12/1/13
 * Time: 2:26 PM
 */
public class FileChooserManager {
    public static String getPath(Component componentParent) {
        String path = null;
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = chooser.showOpenDialog(componentParent);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().getAbsolutePath();
            path = path.replaceAll(Matcher.quoteReplacement("\\"), "/");
        }
        return path;
    }

    public static String getFile(Component componentParent) {
        String path = null;
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnVal = chooser.showOpenDialog(componentParent);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().getAbsolutePath();
            path = path.replaceAll(Matcher.quoteReplacement("\\"), "/");
        }
        return path;
    }
}
