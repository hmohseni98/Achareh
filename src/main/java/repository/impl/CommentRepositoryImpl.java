package repository.impl;

import model.Comment;
import model.Customer;
import model.Expert;
import model.Service;
import repository.CommentRepository;
import repository.base.BaseRepositoryImpl;

import java.util.List;

public class CommentRepositoryImpl extends BaseRepositoryImpl<Comment,Integer> implements CommentRepository {
    @Override
    public List<Comment> findAllByCustomer(Customer customer) {
        var session = getSessionFactory().getCurrentSession();
        String sql = "select * from comment " +
                "inner join customer c on c.id = comment.customer_id " +
                "where comment.customer_id = :customer_id";
        var query = session.createNativeQuery(sql,Comment.class);
        query.setParameter("customer",customer.getId());
        return query.getResultList();
    }

    @Override
    public List<Comment> findAllByExpert(Expert expert) {
        var session = getSessionFactory().getCurrentSession();
        String sql = "select * from comment " +
                "inner join expert e on e.id = comment.expert_id " +
                "where comment.expert_id = :expert_id";
        var query = session.createNativeQuery(sql,Comment.class);
        query.setParameter("expert_id",expert.getId());
        return query.getResultList();
    }

    @Override
    public List<Comment> findAllByService(Service service) {
        var session = getSessionFactory().getCurrentSession();
        String sql = "select * from comment " +
                "inner join orders o on comment.order_id = o.id " +
                "inner join service s on s.id = o.service_id " +
                "where s.id = :service_id";
        var query = session.createNativeQuery(sql,Comment.class);
        query.setParameter("service_id",service.getId());
        return query.getResultList();
    }
}
