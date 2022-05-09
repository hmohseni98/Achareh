package service.impl;

import customException.OldPasswordIsIncorrect;
import model.Customer;
import repository.impl.CustomerRepositoryImpl;
import service.CustomerService;
import service.base.BaseServiceImpl;

public class CustomerServiceImpl extends BaseServiceImpl<CustomerRepositoryImpl, Customer, Integer>
        implements CustomerService {
    private final CustomerRepositoryImpl customerRepository;

    public CustomerServiceImpl(CustomerRepositoryImpl repository) {
        super(repository, Customer.class);
        customerRepository = repository;
    }

    @Override
    public void changePassword(Integer id, String oldPassword, String newPassword) {
        Customer customer;
        customer = super.findById(id);
        try {
            if (!customer.getPassword().equals(oldPassword)) {
                throw new OldPasswordIsIncorrect();
            }
            customer.setPassword(newPassword);
            super.update(customer);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Override
    public Customer login(String email, String password) {
        Customer customer;
        try (var session = getSessionFactory().getCurrentSession()) {
            var transaction = session.beginTransaction();
            try {
                customer = customerRepository.login(email, password);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return customer;
    }

    @Override
    public Customer findByEmail(String email) {
        Customer customer;
        try (var session = getSessionFactory().getCurrentSession()) {
            var transaction = session.beginTransaction();
            try {
                customer = customerRepository.findByEmail(email);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return customer;
    }

}
