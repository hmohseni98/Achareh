package service;

import model.Admin;
import service.base.BaseService;

public interface AdminService extends BaseService<Admin, Integer> {

    Admin login(String email, String password);

    Admin findByEmail(String email);

    void changePassword(Integer id, String oldPassword, String newPassword);
}
