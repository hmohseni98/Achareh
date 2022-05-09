package service.impl;

import customException.OldPasswordIsIncorrect;
import model.Admin;
import repository.impl.AdminRepositoryImpl;
import service.AdminService;
import service.base.BaseServiceImpl;

public class AdminServiceImpl extends BaseServiceImpl<AdminRepositoryImpl, Admin, Integer>
        implements AdminService {

    private final AdminRepositoryImpl adminRepository;

    public AdminServiceImpl(AdminRepositoryImpl repository) {
        super(repository, Admin.class);
        adminRepository = repository;
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
    public void changePassword(Integer id, String oldPassword, String newPassword) {
        Admin admin;
        admin = super.findById(id);
        try {
            if (!admin.getPassword().equals(oldPassword)) {
                throw new OldPasswordIsIncorrect();
            }
            admin.setPassword(newPassword);
            super.update(admin);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
