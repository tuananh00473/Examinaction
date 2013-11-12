package com.ptit.exam.persistence.dao;

import com.ptit.exam.persistence.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * User: thuongntt
 * Date: 9/25/13
 * Time: 10:36 AM
 */
public interface SubjectDAO extends JpaRepository<Subject, Long> {
    public Subject findBySubjectName(String nameOfSubject);

    public List<Subject> findByFaculty(String faculty);

    public Subject findByFacultyAndSubjectName(String faculty, String nameOfSubject);
}
