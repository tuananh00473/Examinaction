package com.ptit.exam.business;

import com.ptit.exam.persistence.entity.Admin;

import java.util.List;

/**
 * User: thuongntt
 * Date: 10/8/13
 * Time: 10:00 AM
 */

public interface AdminService {
    public Admin findById(Long id);

    public Admin save(Admin admin);

    public void deleteById(Long id);

    public void delete(Admin admin);

    public List<Admin> getAll();

    public Admin findByUserNameAndPassWord(String userName, String passWord);
}
