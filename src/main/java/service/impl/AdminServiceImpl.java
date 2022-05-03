package service.impl;

import model.Admin;
import repository.AdminRepository;
import service.AdminService;
import service.base.BaseServiceImpl;

public class AdminServiceImpl extends BaseServiceImpl<AdminRepository, Admin,Integer> implements AdminService {
    public AdminServiceImpl(AdminRepository adminRepository) {
        super(adminRepository, Admin.class);
    }
}
