package com.ptit.exam.business;

import com.ptit.exam.persistence.entity.Result;

import java.util.List;

/**
 * User: Admin
 * Date: 11/24/13
 * Time: 2:24 AM
 */
public interface ResultService {
    public Result save(Result result);

    public Result findByExamIdAndStudentId(Long examId, Long studentId);

    public List<Result> findByFaculty(String faculty);

    public List<Result> findByClassRoom(String classRoom);

    public List<Result> findBySubjectName(String subjectName);

    public List<Result> findByExamName(String examName);

    public List<Result> getAll();
}
