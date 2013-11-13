package com.ptit.exam.persistence.dao;

import com.ptit.exam.persistence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * User: thuongntt
 * Date: 9/26/13
 * Time: 4:19 PM
 */
public interface StudentDAO extends JpaRepository<Student, Long>
{
    public List<Student> findByFaculty(String faculty);

    public List<Student> findByFacultyAndCourse(String faculty, String course);

    public Student findByUserName(String userName);

    public List<Student> findByClassRoom(String classRoom);

    public Student findByStudentCode(String studentCode);

    public Student findByUserNameAndPassWord(String userName, String passWord);

    public List<Student> findByFirstName(String nameStudent);
}
