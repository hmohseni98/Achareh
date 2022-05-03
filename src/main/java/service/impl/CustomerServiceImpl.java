package service.impl;

import model.Customer;
import repository.CustomerRepository;
import service.CustomerService;
import service.base.BaseServiceImpl;

public class CustomerServiceImpl extends BaseServiceImpl<CustomerRepository, Customer,Integer> implements CustomerService {
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository, Customer.class);
    }
}
