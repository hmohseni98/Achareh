package repository.impl;

import model.Comment;
import model.Customer;
import model.Expert;
import model.Service;
import org.hibernate.transform.Transformers;
import repository.CommentRepository;
import repository.base.BaseRepositoryImpl;
import service.dto.CommentDTO;

import java.util.List;

public class CommentRepositoryImpl extends BaseRepositoryImpl<Comment, Integer> implements CommentRepository {

    @Override
    public Class<Comment> getEntityClass() {
        return Comment.class;
    }

    @Override
    public List<CommentDTO> findAllByCustomer(Customer customer) {
        var session = getSessionFactory().getCurrentSession();
        String sql = "select comment.id                        as id, " +
                "       comment.description                    as commentDescription, " +
                "       comment.score                          as score, " +
                "       comment.date                           as date, " +
                "       comment.time                           as time, " +
                "       concat(c.first_name, ' ', c.last_name) as customerFullName, " +
                "       concat(e.first_name, ' ', e.last_name) as expertFullName, " +
                "       o.description                          as orderDescription " +
                "from comment " +
                "         inner join customer c on c.id = comment.customer_id " +
                "         inner join expert e on e.id = comment.expert_id " +
                "         inner join orders o on c.id = o.customer_id " +
                "where comment.customer_id = :customer_id ";
        var query = session.createNativeQuery(sql);
        query.setParameter("customer_id", customer.getId());
        query.setResultTransformer(Transformers.aliasToBean(CommentDTO.class));
        return query.list();
    }

    @Override
    public List<CommentDTO> findAllByExpert(Expert expert) {
        var session = getSessionFactory().getCurrentSession();
        String sql = "select comment.id                        as id, " +
                "       comment.description                    as commentDescription, " +
                "       comment.score                          as score, " +
                "       comment.date                           as date, " +
                "       comment.time                           as time, " +
                "       concat(c.first_name, ' ', c.last_name) as customerFullName, " +
                "       concat(e.first_name, ' ', e.last_name) as expertFullName, " +
                "       o.description                          as orderDescription " +
                "from comment " +
                "         inner join customer c on c.id = comment.customer_id " +
                "         inner join expert e on e.id = comment.expert_id " +
                "         inner join orders o on c.id = o.customer_id " +
                "where comment.expert_id = :expert_id ";
        var query = session.createNativeQuery(sql);
        query.setParameter("expert_id", expert.getId());
        query.setResultTransformer(Transformers.aliasToBean(CommentDTO.class));
        return query.list();
    }

    @Override
    public List<CommentDTO> findAllByService(Service service) {
        var session = getSessionFactory().getCurrentSession();
        String sql = "select comment.id                        as id, " +
                "       comment.description                    as commentDescription, " +
                "       comment.score                          as score, " +
                "       comment.date                           as date, " +
                "       comment.time                           as time, " +
                "       concat(c.first_name, ' ', c.last_name) as customerFullName, " +
                "       concat(e.first_name, ' ', e.last_name) as expertFullName, " +
                "       o.description                          as orderDescription " +
                "from comment " +
                "         inner join customer c on c.id = comment.customer_id " +
                "         inner join expert e on e.id = comment.expert_id " +
                "         inner join orders o on c.id = o.customer_id " +
                "where o.service_id = :service_id ";
        var query = session.createNativeQuery(sql);
        query.setParameter("service_id", service.getId());
        query.setResultTransformer(Transformers.aliasToBean(CommentDTO.class));
        return query.list();
    }

}
