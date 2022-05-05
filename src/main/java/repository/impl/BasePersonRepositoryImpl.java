package repository.impl;

import model.base.BaseEntity;
import repository.BasePersonRepository;
import repository.base.BaseRepositoryImpl;

import java.io.Serializable;

public abstract class BasePersonRepositoryImpl<E extends BaseEntity<ID>, ID extends Serializable> extends BaseRepositoryImpl<E, ID>
        implements BasePersonRepository<E, ID> {

    @Override
    public E login(String email, String password) {
        var session = getSessionFactory().getCurrentSession();
        String sql = "select * from " + getEntityClass().getSimpleName()
                + " where email = :email AND password = :password";
        var query = session.createNativeQuery(sql, getEntityClass());
        query.setParameter("email", email);
        query.setParameter("password", password);
        return query.getSingleResult();
    }

    @Override
    public E findByEmail(String email) {
        var session = getSessionFactory().getCurrentSession();
        String sql = "select * from " + getEntityClass().getSimpleName()
                + " where email = :email";
        var query = session.createNativeQuery(sql, getEntityClass());
        query.setParameter("email", email);
        return query.getSingleResult();
    }
}
