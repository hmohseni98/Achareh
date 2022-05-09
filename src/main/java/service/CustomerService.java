package service;

import model.Customer;
import service.base.BaseService;

public interface CustomerService extends BaseService<Customer, Integer> {
    Customer login(String email, String password);

    Customer findByEmail(String email);

    void changePassword(Integer id, String oldPassword, String newPassword);

}
