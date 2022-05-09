package repository;

import database.SessionFactorySingleton;
import model.Person;

import javax.persistence.NoResultException;

public interface PersonRepository<E extends Person> {

    public Class<E> getEntityClass();

    default E login(String email, String password) {
        var session = SessionFactorySingleton.getInstance().getCurrentSession();
        try {
            var criteriaBuilder = session.getCriteriaBuilder();
            var criteriaQuery = criteriaBuilder.createQuery(getEntityClass());
            var root = criteriaQuery.from(getEntityClass());
            var emailEqual = criteriaBuilder.equal(root.get("email"), email);
            var passwordEqual = criteriaBuilder.equal(root.get("password"), password);

            var query = criteriaQuery
                    .select(root)
                    .where(criteriaBuilder.and(emailEqual, passwordEqual));
            return session.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
        }
        return null;
    }

    default E findByEmail(String email) {
        var session = SessionFactorySingleton.getInstance().getCurrentSession();
        try {
            var criteriaBuilder = session.getCriteriaBuilder();
            var criteriaQuery = criteriaBuilder.createQuery(getEntityClass());
            var root = criteriaQuery.from(getEntityClass());
            var emailEqual = criteriaBuilder.equal(root.get("email"), email);

            var query = criteriaQuery
                    .select(root)
                    .where(emailEqual);
            return session.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
        }
        return null;
    }
}
