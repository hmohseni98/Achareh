package repository.impl;

import model.Category;
import repository.CategoryRepository;
import repository.base.BaseRepositoryImpl;

public class CategoryRepositoryImpl extends BaseRepositoryImpl<Category,Integer> implements CategoryRepository {
    @Override
    public Class<Category> getEntityClass() {
        return Category.class;
    }
}
