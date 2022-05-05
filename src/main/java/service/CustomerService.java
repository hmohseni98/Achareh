package service;

import model.Admin;
import model.Customer;
import service.base.BaseService;

import java.util.List;

public interface CustomerService extends BaseService<Customer, Integer> {
    Customer login(String email, String password);

    Customer findByEmail(String email);

    List<Customer> girdSearch(Integer id, String firstName, String lastName, String email);

}
