package com.ptit.exam.business.impl;

import com.ptit.exam.business.SubjectService;
import com.ptit.exam.persistence.dao.SubjectDAO;
import com.ptit.exam.persistence.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * User: thuongntt
 * Date: 9/25/13
 * Time: 10:42 AM
 */
@Component("subjectService")
public class SubjectServiceImpl implements SubjectService
{

    @Autowired
    SubjectDAO subjectDAO;

    @Override
    public Subject findById(Long id)
    {
        return subjectDAO.findOne(id);
    }

    @Override
    public Subject save(Subject subject)
    {
        return subjectDAO.saveAndFlush(subject);
    }

    @Override
    public void deleteById(Long id)
    {
        subjectDAO.delete(id);
    }

    @Override
    public void delete(Subject subject)
    {
        subjectDAO.delete(subject);
    }

    @Override
    public List<Subject> getAll()
    {
        return subjectDAO.findAll();
    }

    @Override
    public Subject findBySubjectName(String nameOfSubject)
    {
        return subjectDAO.findBySubjectName(nameOfSubject);
    }

    @Override
    public List<Subject> findByFaculty(String faculty)
    {
        return subjectDAO.findByFaculty(faculty);
    }

    @Override
    public List<Subject> findByFacultyAndNameSubject(String nameFaculty, String nameSubject)
    {
        List<Subject> subjectList = new ArrayList<Subject>();
        Subject subject = subjectDAO.findByFacultyAndSubjectName(nameFaculty, nameSubject);
        if (null != subject)
        {
            subjectList.add(subject);
        }
        return subjectList;
    }
}
