package com.ptit.exam.io;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.ptit.exam.persistence.entity.Answer;
import com.ptit.exam.persistence.entity.Question;

import java.io.FileOutputStream;
import java.util.List;

/**
 * User: thuongntt
 * Date: 12/7/13
 * Time: 12:13 AM
 */
public class PDFManager {
    public static void printData(String path, List<Question> questionList, int[] correctAnswers) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(path + "/Exam.pdf"));
            document.open();
            int count = 1;
            for (Question question : questionList) {

                document.add(new Paragraph("\nCâu " + count + ": " + question.getContent()));

//                Image image = Image.getInstance(question.getUrlImage());
//                document.add(image);

                List<Answer> answerList = question.getAnswerList();
                document.add(new Paragraph("A. " + answerList.get(0).getContent()));
                document.add(new Paragraph("B. " + answerList.get(1).getContent()));
                document.add(new Paragraph("C. " + answerList.get(2).getContent()));
                document.add(new Paragraph("D. " + answerList.get(3).getContent()));

                count++;
            }
            document.close();
        } catch (Exception e) {
        }
    }
}
