package service;

import model.Comment;
import model.Customer;
import model.Expert;
import model.Service;
import service.base.BaseService;
import service.dto.CommentDTO;

import java.util.List;

public interface CommentService extends BaseService<Comment,Integer> {
    List<CommentDTO> findAllByCustomer(Customer customer);

    List<CommentDTO> findAllByExpert(Expert expert);

    List<CommentDTO> findAllByService(Service service);
}
