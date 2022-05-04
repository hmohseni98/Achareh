package repository;

import model.Category;
import model.Service;
import repository.base.BaseRepository;

import java.util.List;

public interface ServiceRepository extends BaseRepository<Service, Integer> {
    List<Service> findAllByCategory(Category category);
}
