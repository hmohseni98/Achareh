package service.impl;

import customException.DoNotHaveAccessToThisOrder;
import customException.ScoreOutOfRange;
import customException.StatusOfThisOrderHasNotBeenPaid;
import model.*;
import model.enumration.OrderStatus;
import repository.CommentRepository;
import service.CommentService;
import service.base.BaseServiceImpl;

import java.util.List;

public class CommentServiceImpl extends BaseServiceImpl<CommentRepository, Comment, Integer> implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        super(commentRepository, Comment.class);
        this.commentRepository = commentRepository;
    }

    @Override
    public void save(Comment comment) {
        try {
            if (!(comment.getOrder().getCustomer().getId().equals(comment.getCustomer().getId()))){
                throw new DoNotHaveAccessToThisOrder();
            }
            if (!(comment.getOrder().getStatus().equals(OrderStatus.Paid))) {
                throw new StatusOfThisOrderHasNotBeenPaid();
            }
            if (!(comment.getScore() > 0 && comment.getScore() < 6)){
                throw new ScoreOutOfRange();
            }
            super.save(comment);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Comment> findAllByCustomer(Customer customer) {
        List<Comment> commentList;
        try (var session = getSessionFactory().getCurrentSession()) {
            var transaction = session.beginTransaction();
            try {
                commentList = commentRepository.findAllByCustomer(customer);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return commentList;
    }

    @Override
    public List<Comment> findAllByExpert(Expert expert) {
        List<Comment> commentList;
        try (var session = getSessionFactory().getCurrentSession()) {
            var transaction = session.beginTransaction();
            try {
                commentList = commentRepository.findAllByExpert(expert);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return commentList;
    }

    @Override
    public List<Comment> findAllByService(Service service) {
        List<Comment> commentList;
        try (var session = getSessionFactory().getCurrentSession()) {
            var transaction = session.beginTransaction();
            try {
                commentList = commentRepository.findAllByService(service);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return commentList;
    }
}
