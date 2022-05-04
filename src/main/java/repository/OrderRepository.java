package repository;

import model.Customer;
import model.Expert;
import model.Order;
import model.Service;
import model.enumration.OrderStatus;
import repository.base.BaseRepository;

import java.util.List;

public interface OrderRepository extends BaseRepository<Order, Integer> {
    List<Order> findAllyByCustomer(Customer customer);

    List<Order> findAllByService(Service service);

    List<Order> findAllByExpert(Expert expert);

    List<Order> findAllByStatus(OrderStatus status);
}
