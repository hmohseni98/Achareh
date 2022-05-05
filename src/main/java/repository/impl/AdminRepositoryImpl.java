package repository.impl;

import model.Admin;
import repository.AdminRepository;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class AdminRepositoryImpl extends BasePersonRepositoryImpl<Admin, Integer> implements AdminRepository {
    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }


    public List<Admin> gridSearch(Integer id, String firstName, String lastName, String email) {
        var session = getSessionFactory().getCurrentSession();

        var cb = session.getCriteriaBuilder();

        var adminQuery = cb.createQuery(Admin.class);
        var root = adminQuery.from(Admin.class);

        adminQuery
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

        adminQuery
                .where(predicates.toArray(new Predicate[0]));

        return session.createQuery(adminQuery).list();

    }
}
