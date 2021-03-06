package service.base;

import database.SessionFactorySingleton;
import model.base.BaseEntity;
import repository.base.BaseRepository;

import java.io.Serializable;
import java.util.List;

public class BaseServiceImpl<R extends BaseRepository<E, ID>, E extends BaseEntity<ID>, ID extends Serializable>
        implements BaseService<E, ID> {

    private final R repository;
    public final Class<E> entityClass;


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
    public E findById(ID id) {
        return repository.findById(entityClass, id);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll(entityClass);
    }
}
