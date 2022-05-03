package service.base;

import database.SessionFactorySingleton;
import model.base.BaseEntity;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends BaseEntity<ID>, ID extends Serializable> {

    default SessionFactory getSessionFactory() {
        return SessionFactorySingleton.getInstance();
    }

    void save(E e);

    void delete(E e);

    void update(E e);

    E findById(Class<E> eClass, ID id);

    List<E> findAll(Class<E> eClass);
}
