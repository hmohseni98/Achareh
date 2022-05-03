package service.impl;

import model.Order;
import repository.OrderRepository;
import service.OrderService;
import service.base.BaseServiceImpl;

public class OrderServiceImpl extends BaseServiceImpl<OrderRepository, Order,Integer> implements OrderService {
    public OrderServiceImpl(OrderRepository repository) {
        super(repository, Order.class);
    }
}
