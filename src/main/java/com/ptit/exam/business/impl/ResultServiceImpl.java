package com.ptit.exam.business.impl;

import com.ptit.exam.business.ResultService;
import com.ptit.exam.persistence.dao.ResultDAO;
import com.ptit.exam.persistence.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User: Admin
 * Date: 11/24/13
 * Time: 9:06 AM
 */
@Component("resultService")
public class ResultServiceImpl implements ResultService
{
    @Autowired
    ResultDAO resultDAO;

    @Override
    public Result save(Result result)
    {
        return resultDAO.save(result);
    }

    @Override
    public Result findByExamIdAndStudentId(Long examId, Long studentId)
    {
        return resultDAO.findByExamIdAndStudentId(examId, studentId);
    }
}
