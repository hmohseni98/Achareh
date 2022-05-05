package service.impl;

import model.Admin;
import repository.AdminRepository;
import service.AdminService;
import service.base.BaseServiceImpl;
import service.dto.CommentDTO;

import java.util.List;

public class AdminServiceImpl extends BaseServiceImpl<AdminRepository, Admin,Integer> implements AdminService {
    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        super(adminRepository, Admin.class);
        this.adminRepository = adminRepository;
    }


    @Override
    public Admin login(String email, String password) {
        Admin admin;
        try (var session = getSessionFactory().getCurrentSession()) {
            var transaction = session.beginTransaction();
            try {
                admin = adminRepository.login(email, password);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return admin;
    }

    @Override
    public Admin findByEmail(String email) {
        Admin admin;
        try (var session = getSessionFactory().getCurrentSession()) {
            var transaction = session.beginTransaction();
            try {
                admin = adminRepository.findByEmail(email);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return admin;
    }

    @Override
    public List<Admin> girdSearch(Integer id,String firstName,String lastName,String email) {
        List<Admin> adminList;
        try (var session = getSessionFactory().getCurrentSession()) {
            var transaction = session.beginTransaction();
            try {
                adminList = adminRepository.gridSearch(id, firstName, lastName, email);
                transaction.commit();
            } catch (Exception ex){
                transaction.rollback();
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return adminList;
    }
}
