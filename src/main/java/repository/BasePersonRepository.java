package repository;

import model.base.BaseEntity;
import repository.base.BaseRepository;

import java.io.Serializable;

public interface BasePersonRepository<E extends BaseEntity<ID>, ID extends Serializable> extends BaseRepository<E, ID> {
    E login(String email, String password);

    E findByEmail(String email);
}
