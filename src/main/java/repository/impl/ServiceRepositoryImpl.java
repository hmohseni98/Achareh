package repository.impl;

import model.Category;
import model.Order;
import model.Service;
import repository.ServiceRepository;
import repository.base.BaseRepositoryImpl;

import java.util.List;

public class ServiceRepositoryImpl extends BaseRepositoryImpl<Service, Integer> implements ServiceRepository {
    @Override
    public Class<Service> getEntityClass() {
        return Service.class;
    }

    @Override
    public List<Service> findAllByCategory(Category category) {
        var session = getSessionFactory().getCurrentSession();
        String sql = "select * from service " +
                "inner join category c on c.id = service.category_id " +
                "where service.category_id = :category_id";
        var query = session.createNativeQuery(sql, Service.class);
        query.setParameter("category_id", category.getId());
        return query.getResultList();
    }
}
