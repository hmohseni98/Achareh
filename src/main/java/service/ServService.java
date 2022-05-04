package service;

import model.Category;
import model.Service;
import service.base.BaseService;

import java.util.List;

public interface ServService extends BaseService<Service, Integer> {
    List<Service> findAllByCategory(Category category);
}
