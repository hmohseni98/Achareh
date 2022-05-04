package repository;

import model.Comment;
import model.Customer;
import model.Expert;
import model.Service;
import repository.base.BaseRepository;

import java.util.List;

public interface CommentRepository extends BaseRepository<Comment, Integer> {
    List<Comment> findAllByCustomer(Customer customer);

    List<Comment> findAllByExpert(Expert expert);

    List<Comment> findAllByService(Service service);
}
