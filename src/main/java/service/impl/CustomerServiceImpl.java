package service.impl;

import model.Customer;
import repository.CustomerRepository;
import service.CustomerService;
import service.base.BaseServiceImpl;

public class CustomerServiceImpl extends BaseServiceImpl<CustomerRepository, Customer,Integer> implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        super(customerRepository, Customer.class);
        this.customerRepository = customerRepository;
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
