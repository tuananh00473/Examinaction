package com.ptit.exam.io;

import org.apache.poi.hpsf.CustomProperties;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.ParagraphProperties;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * User: anhnt
 * Date: 11/26/13
 * Time: 11:33 AM
 */
public class WordManager {
    public static void readData() {
        try {
//            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("E:\\test.doc"));
            FileInputStream file = new FileInputStream(new File("E:\\test.doc"));
            HWPFDocument doc = new HWPFDocument(file);

            // centered paragraph with large font size
            Range range = doc.getRange();
            Paragraph par1 = range.insertAfter(new ParagraphProperties(), 0);
            par1.setSpacingAfter(200);
            par1.setJustification((byte) 1);
            // justification: 0=left, 1=center, 2=right, 3=left and right

            CharacterRun run1 = par1.insertAfter("one");
            run1.setFontSize(2 * 18);
            // font size: twice the point size

            // paragraph with bold typeface
            Paragraph par2 = run1.insertAfter(new ParagraphProperties(), 0);
            par2.setSpacingAfter(200);
            CharacterRun run2 = par2.insertAfter("two two two two two two two two two two two two two");
            run2.setBold(true);

            // paragraph with italic typeface and a line indent in the first line
            Paragraph par3 = run2.insertAfter(new ParagraphProperties(), 0);
            par3.setFirstLineIndent(200);
            par3.setSpacingAfter(200);
            CharacterRun run3 = par3.insertAfter("three three three three three three three three three "
                    + "three three three three three three three three three three three three three three "
                    + "three three three three three three three three three three three three three three");
            run3.setItalic(true);

            // add a custom document property (needs POI 3.5; POI 3.2 doesn't save custom properties)
            DocumentSummaryInformation dsi = doc.getDocumentSummaryInformation();
            CustomProperties cp = dsi.getCustomProperties();
            if (cp == null)
                cp = new CustomProperties();
            cp.put("myProperty", "foo bar baz");
            dsi.setCustomProperties(cp);

            doc.write(new FileOutputStream("E:\\test.doc"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeToFile(String path, String content) {
        // TODO Auto-generated method stub
        try {
            POIFSFileSystem fs = new POIFSFileSystem();
            DirectoryEntry directory = fs.getRoot();
            directory.createDocument("WordDocument", new ByteArrayInputStream(content.getBytes()));
            FileOutputStream out = new FileOutputStream(path + "\\Exam.doc");
            fs.writeFilesystem(out);
            out.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
