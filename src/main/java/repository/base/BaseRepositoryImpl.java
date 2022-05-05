package repository.base;

import model.base.BaseEntity;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>, ID extends Serializable> implements BaseRepository<E, ID> {

    public abstract Class<E> getEntityClass();

    @Override
    public void save(E e) {
        var session = getSessionFactory().getCurrentSession();
        session.save(e);
    }

    @Override
    public void delete(E e) {
        var session = getSessionFactory().getCurrentSession();
        session.delete(e);
    }

    @Override
    public void update(E e) {
        var session = getSessionFactory().getCurrentSession();
        session.update(e);
    }

    @Override
    public E findById(Class<E> eClass, ID id) {
        try (var session = getSessionFactory().openSession()) {
            return session.get(eClass, id);
        }
    }

    @Override
    public List<E> findAll(Class<E> eClass) {
        try (var session = getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(eClass);
            Root<E> root = criteriaQuery.from(eClass);
            return session.createQuery(criteriaQuery.select(root)).list();
        }
    }
}
