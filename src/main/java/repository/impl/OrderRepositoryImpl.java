package repository.impl;

import model.*;
import model.enumration.OrderStatus;
import repository.OrderRepository;
import repository.base.BaseRepositoryImpl;

import java.util.List;

public class OrderRepositoryImpl extends BaseRepositoryImpl<Order, Integer> implements OrderRepository {
    @Override
    public Class<Order> getEntityClass() {
        return Order.class;
    }

    @Override
    public List<Order> findAllyByCustomer(Customer customer) {
        var session = getSessionFactory().getCurrentSession();
        String sql = "select * from orders " +
                "inner join comment c on orders.id = c.order_id " +
                "where orders.customer_id = :customer_id";
        var query = session.createNativeQuery(sql, Order.class);
        query.setParameter("customer_id", customer.getId());
        return query.getResultList();
    }

    @Override
    public List<Order> findAllByService(Service service) {
        var session = getSessionFactory().getCurrentSession();
        String sql = "select * from orders " +
                "inner join service s on orders.service_id = s.id " +
                "where orders.service_id = :service_id";
        var query = session.createNativeQuery(sql, Order.class);
        query.setParameter("service_id", service.getId());
        return query.getResultList();
    }

    @Override
    public List<Order> findAllByExpert(Expert expert) {
        var session = getSessionFactory().getCurrentSession();
        String sql = "select * from orders " +
                "inner join expert e on e.id = orders.accept_expert_id " +
                "where orders.accept_expert_id = :expert_id";
        var query = session.createNativeQuery(sql, Order.class);
        query.setParameter("expert_id", expert.getId());
        return query.getResultList();
    }

    @Override
    public List<Order> findAllByStatus(OrderStatus status) {
        var session = getSessionFactory().getCurrentSession();
        String sql = "select * from orders " +
                "where orders.status = :status";
        var query = session.createNativeQuery(sql, Order.class);
        query.setParameter("status", status);
        return query.getResultList();
    }
}
