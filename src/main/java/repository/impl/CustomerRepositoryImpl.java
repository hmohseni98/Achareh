package repository.impl;

import model.Customer;
import repository.CustomerRepository;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


public class CustomerRepositoryImpl extends BasePersonRepositoryImpl<Customer, Integer> implements CustomerRepository {
    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }

    @Override
    public List<Customer> gridSearch(Integer id, String firstName, String lastName, String email) {
        var session = getSessionFactory().getCurrentSession();

        var cb = session.getCriteriaBuilder();

        var customerQuery = cb.createQuery(Customer.class);
        var root = customerQuery.from(Customer.class);

        customerQuery
                .select(root);
        List<Predicate> predicates = new ArrayList<>();

        if (id != null) {
            predicates.add(cb.equal(root.get("id"), id));
        }

        if (firstName != null && !firstName.isEmpty()) {
            predicates.add(cb.like(root.get("firstName"), "%" + firstName + "%"));
        }

        if (lastName != null && !lastName.isEmpty()) {
            predicates.add(cb.like(root.get("lastName"), "%" + lastName + "%"));
        }

        if (email != null && !email.isEmpty()) {
            predicates.add(cb.like(root.get("email"), "%" + email + "%"));
        }

        customerQuery
                .where(predicates.toArray(new Predicate[0]));

        return session.createQuery(customerQuery).list();
    }
}
