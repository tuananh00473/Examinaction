package com.ptit.exam.persistence.entity;

import javax.persistence.*;

/**
 * User: thuongntt
 * Date: 9/25/13
 * Time: 8:08 PM
 */
@Entity
@Table(name = "students")
public class Student
{
    public static String STUDENT_LAST_NAME = "lastName";
    public static String STUDENT_FIRST_NAME = "firstName";
    public static String STUDENT_GENDER = "gender";
    public static String STUDENT_DATE_OF_BIRTH = "dateOfBirth";
    public static String STUDENT_CODE = "studentCode";
    public static String STUDENT_CLASS = "classRoom";
    public static String STUDENT_FACULTY = "faculty";
    public static String STUDENT_COURSE = "course";
    public static String STUDENT_TRAINING_TYPE = "trainingType";
    public static String STUDENT_USERNAME = "userName";
    public static String STUDENT_PASSWORD = "passWord";


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dateofbirth")
    private String dateOfBirth;

    @Column(name = "student_code")
    private String studentCode;

    @Column(name = "class_room")
    private String classRoom;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "course")
    private String course;

    @Column(name = "trainning_type")
    private String trainingType;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String passWord;

    public Student()
    {
    }

    public Student(String userName, String passWord)
    {
        this.userName = userName;
        this.passWord = passWord;
    }

    public Student(String firstName, String lastName, String gender, String dateOfBirth, String studentCode, String classRoom, String faculty, String course, String trainingType, String userName, String passWord)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.studentCode = studentCode;
        this.classRoom = classRoom;
        this.faculty = faculty;
        this.course = course;
        this.trainingType = trainingType;
        this.userName = userName;
        this.passWord = passWord;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStudentCode()
    {
        return studentCode;
    }

    public void setStudentCode(String studentCode)
    {
        this.studentCode = studentCode;
    }

    public String getClassRoom()
    {
        return classRoom;
    }

    public void setClassRoom(String classRoom)
    {
        this.classRoom = classRoom;
    }

    public String getFaculty()
    {
        return faculty;
    }

    public void setFaculty(String faculty)
    {
        this.faculty = faculty;
    }

    public String getCourse()
    {
        return course;
    }

    public void setCourse(String course)
    {
        this.course = course;
    }

    public String getTrainingType()
    {
        return trainingType;
    }

    public void setTrainingType(String trainingType)
    {
        this.trainingType = trainingType;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassWord()
    {
        return passWord;
    }

    public void setPassWord(String passWord)
    {
        this.passWord = passWord;
    }

    public boolean equals(Object object)
    {
        Student student = (Student) object;
        if (firstName.equals(student.getFirstName())
                && lastName.equals(student.getLastName())
                && gender.equals(student.getGender())
                && dateOfBirth.equals(student.getDateOfBirth())
                && studentCode.equals(student.getStudentCode())
                && classRoom.equals(student.getClassRoom())
                && faculty.equals(student.getFaculty())
                && course.equals(student.getCourse())
                && trainingType.equals(student.getTrainingType())
                && userName.equals(student.getUserName())
                && passWord.equals(student.getPassWord()))
        {
            return true;
        }
        {
            return false;
        }
    }

    public boolean inValid()
    {
        if (isValueNull(studentCode)
                || isValueNull(firstName)
                || isValueNull(lastName)
                || isValueNull(gender)
                || isValueNull(dateOfBirth)
                || isValueNull(classRoom)
                || isValueNull(faculty)
                || isValueNull(course)
                || isValueNull(trainingType)
                || isValueNull(userName)
                || isValueNull(passWord))
        {
            return true;
        }
        return false;
    }

    public boolean isValueNull(String attribute)
    {
        if (null == attribute || "".equals(attribute))
        {
            return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        return studentCode + " : " + firstName + lastName;
    }
}
