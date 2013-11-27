package com.ptit.exam.business;

import com.ptit.exam.persistence.entity.Result;

/**
 * User: Admin
 * Date: 11/24/13
 * Time: 2:24 AM
 */
public interface ResultService
{
    public Result save(Result result);

    public Result findByExamIdAndStudentId(Long examId, Long studentId);
}
