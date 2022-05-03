package service.base;

import database.SessionFactorySingleton;
import model.base.BaseEntity;
import repository.base.BaseRepository;

import java.io.Serializable;
import java.util.List;

public class BaseServiceImpl<R extends BaseRepository<E, ID>, E extends BaseEntity<ID>, ID extends Serializable>
        implements service.base.BaseService<E, ID> {

    private final R repository;
    private Class<E> entityClass;


    public BaseServiceImpl(R repository, Class<E> entityClass) {
        this.repository = repository;
        this.entityClass = entityClass;
    }

    @Override
    public void save(E e) {
        try (var session = SessionFactorySingleton.getInstance().getCurrentSession()) {
            var transaction = session.beginTransaction();
            try {
                repository.save(e);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void delete(E e) {
        try (var session = SessionFactorySingleton.getInstance().getCurrentSession()) {
            var transaction = session.beginTransaction();
            try {
                repository.delete(e);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void update(E e) {
        try (var session = SessionFactorySingleton.getInstance().getCurrentSession()) {
            var transaction = session.beginTransaction();
            try {
                repository.update(e);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public E findById(Class<E> eClass, ID id) {
        return repository.findById(eClass, id);
    }

    @Override
    public List<E> findAll(Class<E> eClass) {
        return repository.findAll(eClass);
    }
}
