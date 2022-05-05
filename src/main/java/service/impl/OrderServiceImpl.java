package service.impl;

import customException.ProposedPriceMustBeHigherThanTheBasePrice;
import model.*;
import model.enumration.OrderStatus;
import repository.OrderRepository;
import service.OrderService;
import service.base.BaseServiceImpl;

import java.util.List;

public class OrderServiceImpl extends BaseServiceImpl<OrderRepository, Order, Integer> implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        super(orderRepository, Order.class);
        this.orderRepository = orderRepository;
    }

    @Override
    public void save(Order order) {
        try {
            if (order.getSuggestionPrice() < order.getService().getBasePrice()) {
                throw new ProposedPriceMustBeHigherThanTheBasePrice();
            }
            super.save(order);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Order> findAllyByCustomer(Customer customer) {
        List<Order> orderList;
        try (var session = getSessionFactory().getCurrentSession()) {
            var transaction = session.beginTransaction();
            try {
                orderList = orderRepository.findAllyByCustomer(customer);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return orderList;
    }

    @Override
    public List<Order> findAllByService(Service service) {
        List<Order> orderList;
        try (var session = getSessionFactory().getCurrentSession()) {
            var transaction = session.beginTransaction();
            try {
                orderList = orderRepository.findAllByService(service);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return orderList;
    }

    @Override
    public List<Order> findAllByExpert(Expert expert) {
        List<Order> orderList;
        try (var session = getSessionFactory().getCurrentSession()) {
            var transaction = session.beginTransaction();
            try {
                orderList = orderRepository.findAllByExpert(expert);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return orderList;
    }

    @Override
    public List<Order> findAllByStatus(OrderStatus status) {
        List<Order> orderList;
        try (var session = getSessionFactory().getCurrentSession()) {
            var transaction = session.beginTransaction();
            try {
                orderList = orderRepository.findAllByStatus(status);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return orderList;
    }
}
