package com.ptit.exam.persistence.entity;

import javax.persistence.*;

/**
 * User: Administrator
 * Date: 8/22/13
 * Time: 10:28 PM
 */
@Entity
@Table(name = "questions")
public class Question
{

    public static final String QUESTION_CONTENT = "content";
    public static final String QUESTION_IMAGE_URL = "urlImage";
    public static final String QUESTION_CHAPTER = "chapter";
    public static final String QUESTION_LEVEL = "level";
    public static final String QUESTION_SUBJECT_CODE = "subjectCode";

    //  ============= Attribute ==============
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "subject_code")
    private String subjectCode;

    @Column(name = "level")
    private int level;

    @Column(name = "chapter")
    private int chapter;

    @Column(name = "question_content")
    private String content;

    @Column(name = "question_urlimage")
    private String urlImage;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getSubjectCode()
    {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode)
    {
        this.subjectCode = subjectCode;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public int getChapter()
    {
        return chapter;
    }

    public void setChapter(int chapter)
    {
        this.chapter = chapter;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getUrlImage()
    {
        return urlImage;
    }

    public void setUrlImage(String urlImage)
    {
        this.urlImage = urlImage;
    }

    @Override
    public String toString()
    {
        return content;
    }
}
