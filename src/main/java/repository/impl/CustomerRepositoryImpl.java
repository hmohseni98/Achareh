package repository.impl;

import model.Customer;
import repository.CustomerRepository;
import repository.PersonRepository;
import repository.base.BaseRepositoryImpl;


public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer, Integer>
        implements CustomerRepository, PersonRepository<Customer> {
    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
