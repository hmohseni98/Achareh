package service;

import model.Comment;
import model.Customer;
import model.Expert;
import model.Service;
import service.base.BaseService;

import java.util.List;

public interface CommentService extends BaseService<Comment,Integer> {
    List<Comment> findAllByCustomer(Customer customer);

    List<Comment> findAllByExpert(Expert expert);

    List<Comment> findAllByService(Service service);
}
