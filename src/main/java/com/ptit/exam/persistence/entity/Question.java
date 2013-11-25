package com.ptit.exam.persistence.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Transient
    private List<Answer> answerList;

    public Question()
    {
        answerList = new ArrayList<Answer>();
    }

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

    public void setAnswerList(List<Answer> answerList)
    {
        this.answerList = answerList;
    }

    public List<Answer> getAnswerList()
    {
        return answerList;
    }

    @Override
    public boolean equals(Object obj)
    {
        Question question = (Question) obj;
        return subjectCode.equals(question.getSubjectCode())
                && level == question.getLevel()
                && chapter == question.getChapter()
                && content.equals(question.getContent())
                && urlImage.equals(question.getUrlImage())
                && compare(answerList, question.getAnswerList());
    }

    public boolean compare(List<Answer> list1, List<Answer> list2)
    {
        if (list1.size() != list2.size())
        {
            return false;
        }
        for (int i = 0; i < list1.size(); i++)
        {
            if (!list1.get(i).equals(list2.get(i)))
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString()
    {
        return content;
    }
}
