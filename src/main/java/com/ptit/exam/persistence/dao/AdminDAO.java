package com.ptit.exam.persistence.dao;

import com.ptit.exam.persistence.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User: thuongntt
 * Date: 10/8/13
 * Time: 9:58 AM
 */
public interface AdminDAO extends JpaRepository<Admin, Long> {
    public Admin findByUserNameAndPassWord(String userName, String passWord);
}
