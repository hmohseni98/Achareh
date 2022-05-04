package service.impl;

import model.Admin;
import repository.AdminRepository;
import service.AdminService;
import service.base.BaseServiceImpl;

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
}
