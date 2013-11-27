package com.ptit.exam.persistence.dao;

import com.ptit.exam.persistence.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User: thuongntt
 * Date: 9/25/13
 * Time: 10:37 AM
 */
public interface ResultDAO extends JpaRepository<Result, Long>
{
    public Result findByExamIdAndStudentId(Long examId, Long studentId);
}
