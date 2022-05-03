package service.impl;

import model.Category;
import repository.CategoryRepository;
import service.CategoryService;
import service.base.BaseServiceImpl;

public class CategoryServiceImpl extends BaseServiceImpl<CategoryRepository, Category,Integer> implements CategoryService {
    public CategoryServiceImpl(CategoryRepository repository) {
        super(repository,Category.class);
    }
}
