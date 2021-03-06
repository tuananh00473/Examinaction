package com.ptit.exam.business.common;


import com.ptit.exam.business.StudentService;
import com.ptit.exam.persistence.entity.Answer;
import com.ptit.exam.persistence.entity.Exam;
import com.ptit.exam.persistence.entity.Student;
import com.ptit.exam.persistence.entity.Subject;
import com.ptit.exam.persistence.modelbinding.ExamCardDTOBinding;
import com.ptit.exam.persistence.modelbinding.QuestionDTOBinding;
import com.ptit.exam.persistence.modelbinding.ResultDTOBinding;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Thuongntt
 * Date: 7/30/13
 * Time: 3:01 PM
 */
public class TableBinding {
    @Autowired
    StudentService studentService;

    public static Map<String, JTableBinding> bindMap = new HashMap<String, JTableBinding>();

    public static void bindingAnswer(List<Answer> answerList, JTable table, JScrollPane panel) {
        unbinding(table, panel);
        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, answerList, table);
        //-----------------------Option----------------------------------------------
        jTableBinding.addColumnBinding(BeanProperty.create(Answer.ANSWER_CONTENT)).setColumnName("PHƯƠNG ÁN TRẢ LỜI");
        jTableBinding.addColumnBinding(BeanProperty.create(Answer.ANSWER_CORRECT)).setColumnName("ĐÚNG?");

        jTableBinding.bind();
        bindMap.put(panel.hashCode() + "." + table.hashCode(), jTableBinding);
    }

    public static void bindingQuestionBank(List<QuestionDTOBinding> questionDTOBindingList, JTable table, JScrollPane panel) {
        unbinding(table, panel);
        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, questionDTOBindingList, table);
        //-----------------------Option----------------------------------------------
        jTableBinding.addColumnBinding(BeanProperty.create(QuestionDTOBinding.QUESTION_SUBJECT_NAME)).setColumnName("TÊN MÔN");
        jTableBinding.addColumnBinding(BeanProperty.create(QuestionDTOBinding.QUESTION_CONTENT)).setColumnName("NỘI DUNG");
        jTableBinding.addColumnBinding(BeanProperty.create(QuestionDTOBinding.QUESTION_IMAGE_URL)).setColumnName("HÌNH ẢNH ");
        jTableBinding.addColumnBinding(BeanProperty.create(QuestionDTOBinding.QUESTION_CHAPTER)).setColumnName("CHƯƠNG");
        jTableBinding.addColumnBinding(BeanProperty.create(QuestionDTOBinding.QUESTION_LEVEL)).setColumnName("MỨC KHÓ");

        jTableBinding.bind();
        bindMap.put(panel.hashCode() + "." + table.hashCode(), jTableBinding);
    }


    public static void bindingSubject(List<Subject> subjectList, JTable table, JScrollPane panel) {
        unbinding(table, panel);
        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, subjectList, table);
        //-----------------------Option----------------------------------------------
        jTableBinding.addColumnBinding(BeanProperty.create(Subject.SUBJECT_CODE)).setColumnName("MÃ MÔN HỌC");
        jTableBinding.addColumnBinding(BeanProperty.create(Subject.SUBJECT_NAME)).setColumnName("TÊN MÔN HỌC");
        jTableBinding.addColumnBinding(BeanProperty.create(Subject.SUBJECT_FACULTY)).setColumnName("KHOA");
        jTableBinding.addColumnBinding(BeanProperty.create(Subject.SUBJECT_UNIT_STUDY)).setColumnName("ĐVHT");
        jTableBinding.addColumnBinding(BeanProperty.create(Subject.SUBJECT_DESCRIPTION)).setColumnName("MÔ TẢ");

        jTableBinding.bind();
        bindMap.put(panel.hashCode() + "." + table.hashCode(), jTableBinding);
    }

    public static void bindingSubjectToExam(List<Subject> subjectList, JTable table, JScrollPane panel) {
        unbinding(table, panel);
        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, subjectList, table);
        //-----------------------Option----------------------------------------------
        jTableBinding.addColumnBinding(BeanProperty.create(Subject.SUBJECT_CODE)).setColumnName("MÃ MÔN HỌC");
        jTableBinding.addColumnBinding(BeanProperty.create(Subject.SUBJECT_NAME)).setColumnName("TÊN MÔN HỌC");
        jTableBinding.addColumnBinding(BeanProperty.create(Subject.SUBJECT_UNIT_STUDY)).setColumnName("ĐVHT");

        jTableBinding.bind();
        bindMap.put(panel.hashCode() + "." + table.hashCode(), jTableBinding);
    }

    public static void bindingManagementExam(List<Exam> examList, JTable table, JScrollPane panel) {
        unbinding(table, panel);
        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, examList, table);
        //-----------------------Option----------------------------------------------
        jTableBinding.addColumnBinding(BeanProperty.create(Exam.EXAM_NAME)).setColumnName("TÊN ĐỀ THI");
        jTableBinding.addColumnBinding(BeanProperty.create(Exam.EXAM_CODE)).setColumnName("MÃ ĐỀ THI");
        jTableBinding.addColumnBinding(BeanProperty.create(Exam.EXAM_SUBJECT_CODE)).setColumnName("MÃ MÔN");
        jTableBinding.addColumnBinding(BeanProperty.create(Exam.EXAM_TOTAL_TIME)).setColumnName("THỜI GIAN THI");
        jTableBinding.addColumnBinding(BeanProperty.create(Exam.EXAM_TOTAL_HARD_QUESTION)).setColumnName("SỐ CÂU KHÓ");
        jTableBinding.addColumnBinding(BeanProperty.create(Exam.EXAM_TOTAL_MEDIUM_QUESTION)).setColumnName("SỐ CÂU TRUNG BÌNH");
        jTableBinding.addColumnBinding(BeanProperty.create(Exam.EXAM_TOTAL_EASY_QUESTION)).setColumnName("SỐ CÂU DỄ");
        jTableBinding.addColumnBinding(BeanProperty.create(Exam.EXAM_IS_ACTIVE)).setColumnName("KÍCH HOẠT");

        jTableBinding.bind();
        bindMap.put(panel.hashCode() + "." + table.hashCode(), jTableBinding);
    }

    public static void bindingStudent(List<Student> studentList, JTable table, JScrollPane panel) {
        unbinding(table, panel);
        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, studentList, table);
        //-----------------------Option----------------------------------------------
        jTableBinding.addColumnBinding(BeanProperty.create(Student.STUDENT_CODE)).setColumnName("MÃ SINH VIÊN");
        jTableBinding.addColumnBinding(BeanProperty.create(Student.STUDENT_FIRST_NAME)).setColumnName("TÊN CHÍNH");
        jTableBinding.addColumnBinding(BeanProperty.create(Student.STUDENT_LAST_NAME)).setColumnName("TÊN ĐỆM");
        jTableBinding.addColumnBinding(BeanProperty.create(Student.STUDENT_GENDER)).setColumnName("GIỚI TÍNH");
        jTableBinding.addColumnBinding(BeanProperty.create(Student.STUDENT_DATE_OF_BIRTH)).setColumnName("NGÀY SINH");
        jTableBinding.addColumnBinding(BeanProperty.create(Student.STUDENT_CLASS)).setColumnName("LỚP");
        jTableBinding.addColumnBinding(BeanProperty.create(Student.STUDENT_FACULTY)).setColumnName("KHOA");
        jTableBinding.addColumnBinding(BeanProperty.create(Student.STUDENT_COURSE)).setColumnName("KHÓA HỌC");
        jTableBinding.addColumnBinding(BeanProperty.create(Student.STUDENT_TRAINING_TYPE)).setColumnName("HÌNH THỨC ĐÀO TẠO");
        jTableBinding.addColumnBinding(BeanProperty.create(Student.STUDENT_USERNAME)).setColumnName("USERNAME");
        jTableBinding.addColumnBinding(BeanProperty.create(Student.STUDENT_PASSWORD)).setColumnName("PASSWORD");
        jTableBinding.bind();
        bindMap.put(panel.hashCode() + "." + table.hashCode(), jTableBinding);
    }


    public static void bindingExamCard(List<ExamCardDTOBinding> examCardDTOList, JTable tableExamCard, JScrollPane examCardScrollPane) {
        unbinding(tableExamCard, examCardScrollPane);
        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, examCardDTOList, tableExamCard);
        //-----------------------Option----------------------------------------------
        jTableBinding.addColumnBinding(BeanProperty.create(ExamCardDTOBinding.EXAM_ID)).setColumnName("MÃ TH? D? THI");
        jTableBinding.addColumnBinding(BeanProperty.create(ExamCardDTOBinding.STUDENT_CODE)).setColumnName("MÃ SINH VIÊN");
        jTableBinding.addColumnBinding(BeanProperty.create(ExamCardDTOBinding.STUDENT_NAME)).setColumnName("H? VÀ TÊN");
        jTableBinding.addColumnBinding(BeanProperty.create(ExamCardDTOBinding.FACULTY)).setColumnName("KHOA");
        jTableBinding.addColumnBinding(BeanProperty.create(ExamCardDTOBinding.CLASS_ROOM)).setColumnName("L?P");
        jTableBinding.addColumnBinding(BeanProperty.create(ExamCardDTOBinding.NAME_SUBJECT)).setColumnName("TÊN MÔN H?C");
        jTableBinding.addColumnBinding(BeanProperty.create(ExamCardDTOBinding.UNIT_OF_STUDY)).setColumnName("?VHT");
        jTableBinding.addColumnBinding(BeanProperty.create(ExamCardDTOBinding.CAN_DO_EXAM)).setColumnName("?? ?KDT");

        jTableBinding.bind();
        bindMap.put(examCardScrollPane.hashCode() + "." + tableExamCard.hashCode(), jTableBinding);
    }

    public static void bindingExamination(List<Exam> examList, JTable tableExamination, JScrollPane examinationScrollPanel) {
        unbinding(tableExamination, examinationScrollPanel);
        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, examList, tableExamination);
        //-----------------------Option----------------------------------------------
        jTableBinding.addColumnBinding(BeanProperty.create(Exam.EXAM_NAME)).setColumnName("TÊN ?? THI");
        jTableBinding.addColumnBinding(BeanProperty.create(Exam.EXAM_CODE)).setColumnName("MÃ ?? THI");
        jTableBinding.addColumnBinding(BeanProperty.create(Exam.EXAM_SUBJECT_CODE)).setColumnName("MÃ MÔN");
        jTableBinding.addColumnBinding(BeanProperty.create(Exam.EXAM_TOTAL_TIME)).setColumnName("TH?I GIAN THI");

        jTableBinding.bind();
        bindMap.put(examinationScrollPanel.hashCode() + "." + tableExamination.hashCode(), jTableBinding);
    }

    //----------------- unbinding-------------------------------
    public static void unbinding(JTable table, JScrollPane panel) {
        String key = table.hashCode() + "." + panel.hashCode();
        if (bindMap.containsKey(key)) {
            bindMap.get(key).unbind();
            bindMap.remove(bindMap.get(key));
        }
    }

    public static void bindingResult(List<ResultDTOBinding> resultList, JTable resultTable, JScrollPane resultScrollPanel) {
        unbinding(resultTable, resultScrollPanel);
        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, resultList, resultTable);
        //-----------------------Option----------------------------------------------\
        jTableBinding.addColumnBinding(BeanProperty.create(ResultDTOBinding.EXAM_NAME)).setColumnName("KỲ THI");
        jTableBinding.addColumnBinding(BeanProperty.create(ResultDTOBinding.STUDENT_CODE)).setColumnName("MÃ SINH VIÊN");
        jTableBinding.addColumnBinding(BeanProperty.create(ResultDTOBinding.STUDENT_FIRST_NAME)).setColumnName("HỌ ĐỆM");
        jTableBinding.addColumnBinding(BeanProperty.create(ResultDTOBinding.STUDENT_LAST_NAME)).setColumnName("TÊN");
        jTableBinding.addColumnBinding(BeanProperty.create(ResultDTOBinding.FACULTY)).setColumnName("KHOA");
        jTableBinding.addColumnBinding(BeanProperty.create(ResultDTOBinding.CLASS_ROOM)).setColumnName("LỚP");
        jTableBinding.addColumnBinding(BeanProperty.create(ResultDTOBinding.NAME_SUBJECT)).setColumnName("TÊN MÔN HỌC");
        jTableBinding.addColumnBinding(BeanProperty.create(ResultDTOBinding.SOCRE)).setColumnName("ĐIỂM");
        jTableBinding.addColumnBinding(BeanProperty.create(ResultDTOBinding.MAX_SCORE)).setColumnName("ĐIỂM TỐI ĐA");

        jTableBinding.bind();
        bindMap.put(resultScrollPanel.hashCode() + "." + resultList.hashCode(), jTableBinding);
    }
}
