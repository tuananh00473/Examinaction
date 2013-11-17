package com.ptit.exam.business;

import com.ptit.exam.persistence.entity.Student;

import java.util.List;

/**
 * User: thuongntt
 * Date: 9/26/13
 * Time: 4:20 PM
 */
public interface StudentService {
    public Student findById(Long id);

    public Student save(Student student);

    public void deleteById(Long id);

    public void delete(Student student);

    public List<Student> getAll();

    public Student findByUserName(String userName);

    public List<Student> findByFaculty(String faculty);

    public List<Student> findByFacultyAndCourse(String faculty, String course);

    public List<Student> findByClassRoom(String classRoom);

    public Student findByStudentCode(String studentCode);

    public Student findByUserNameAndPassWord(String userName, String passWord);

    public List<Student> findByName(String nameStudent);

    public List<Student> findByCourse(String course);
}
