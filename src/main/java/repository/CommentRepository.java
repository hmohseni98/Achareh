package repository;

import model.Comment;
import model.Customer;
import model.Expert;
import model.Service;
import repository.base.BaseRepository;
import service.dto.CommentDTO;

import java.util.List;

public interface CommentRepository extends BaseRepository<Comment, Integer> {
    List<CommentDTO> findAllByCustomer(Customer customer);

    List<CommentDTO> findAllByExpert(Expert expert);

    List<CommentDTO> findAllByService(Service service);
}
