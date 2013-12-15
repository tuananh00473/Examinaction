package com.ptit.exam.persistence.modelbinding;

/**
 * User: thuongntt
 * Date: 12/11/13
 * Time: 9:19 PM
 */
public class QuestionDTOBinding {
    public static final String QUESTION_CONTENT = "content";
    public static final String QUESTION_SUBJECT_CODE = "subjectCode";
    public static final String QUESTION_SUBJECT_NAME = "subjectName";
    public static final String QUESTION_IMAGE_URL = "urlImage";
    public static final String QUESTION_CHAPTER = "chapter";
    public static final String QUESTION_LEVEL = "level";

    private String content;
    private String subjectCode;
    private String subjectName;
    private String urlImage;
    private int chapter;
    private int level;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
