package service;

import model.Admin;
import service.base.BaseService;

import java.util.List;

public interface AdminService extends BaseService<Admin, Integer> {
    Admin login(String email, String password);

    Admin findByEmail(String email);

    List<Admin> girdSearch(Integer id,String firstName,String lastName,String email);
}
