package com.ptit.exam.business.impl;

import com.ptit.exam.business.StudentService;
import com.ptit.exam.persistence.dao.StudentDAO;
import com.ptit.exam.persistence.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: thuongntt
 * Date: 9/26/13
 * Time: 4:22 PM
 */
@Component("studentService")

public class StudentServiceImpl implements StudentService
{

    @Autowired
    StudentDAO studentDAO;

    @Override
    public Student findById(Long id)
    {
        return studentDAO.findOne(id);
    }

    @Override
    public Student save(Student student)
    {
        return studentDAO.saveAndFlush(student);
    }

    @Override
    public void deleteById(Long id)
    {
        studentDAO.delete(id);
    }

    @Override
    public void delete(Student student)
    {
        studentDAO.delete(student);
    }

    @Override
    public List<Student> getAll()
    {
        return studentDAO.findAll();
    }

    @Override
    public Student findByUserName(String userName)
    {
        return studentDAO.findByUserName(userName);
    }

    @Override
    public List<Student> findByFaculty(String faculty)
    {
        return studentDAO.findByFaculty(faculty);
    }

    @Override
    public List<Student> findByFacultyAndCourse(String faculty, String course)
    {
        return studentDAO.findByFacultyAndCourse(faculty, course);
    }

    @Override
    public List<Student> findByClassRoom(String classRoom)
    {
        return studentDAO.findByClassRoom(classRoom);
    }

    @Override
    public Student findByStudentCode(String studentCode)
    {
        return studentDAO.findByStudentCode(studentCode);
    }

    @Override
    public Student findByUserNameAndPassWord(String userName, String passWord)
    {
        return studentDAO.findByUserNameAndPassWord(userName, passWord);
    }

    @Override
    public List<Student> findByName(String nameStudent)
    {
        return studentDAO.findByFirstName(nameStudent);
    }
}
