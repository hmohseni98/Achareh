package service;

import model.Customer;
import model.Expert;
import model.Order;
import model.Service;
import model.enumration.OrderStatus;
import service.base.BaseService;

import java.util.List;

public interface OrderService extends BaseService<Order, Integer> {
    List<Order> findAllyByCustomer(Customer customer);

    List<Order> findAllByService(Service service);

    List<Order> findAllByExpert(Expert expert);

    List<Order> findAllByStatus(OrderStatus status);
}
