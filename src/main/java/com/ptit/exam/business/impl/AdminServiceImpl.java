package com.ptit.exam.business.impl;

import com.ptit.exam.business.AdminService;
import com.ptit.exam.persistence.dao.AdminDAO;
import com.ptit.exam.persistence.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: thuongntt
 * Date: 10/8/13
 * Time: 10:01 AM
 */
@Component("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDAO adminDAO;

    @Override
    public Admin findById(Long id) {
        return adminDAO.findOne(id);
    }

    @Override
    public Admin save(Admin admin) {
        return adminDAO.saveAndFlush(admin);
    }

    @Override
    public void deleteById(Long id) {

        adminDAO.delete(id);
    }

    @Override
    public void delete(Admin admin) {
        adminDAO.delete(admin);
    }

    @Override
    public List<Admin> getAll() {
        return adminDAO.findAll();
    }

    @Override
    public Admin findByUserNameAndPassWord(String userName, String passWord) {
        return adminDAO.findByUserNameAndPassWord(userName, passWord);
    }
}
