package com.ptit.exam.business;

import com.ptit.exam.persistence.entity.Subject;

import java.util.List;

/**
 * User: thuongntt
 * Date: 9/25/13
 * Time: 10:39 AM
 */

public interface SubjectService
{
    public Subject findById(Long id);

    public Subject save(Subject subject);

    public void deleteById(Long id);

    public void delete(Subject subject);

    public List<Subject> getAll();

    public Subject findBySubjectName(String nameOfSubject);

    public List<Subject> findByFaculty(String faculty);

    List<Subject> findByFacultyAndNameSubject(String nameFaculty, String nameSubject);
}
