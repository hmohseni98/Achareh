package repository.impl;

import model.Customer;
import model.Expert;
import model.enumration.AccountStatus;
import org.hibernate.transform.Transformers;
import repository.ExpertRepository;
import repository.PersonRepository;
import repository.base.BaseRepositoryImpl;
import service.dto.ExpertDTO;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


public class ExpertRepositoryImpl extends BaseRepositoryImpl<Expert,Integer>
        implements ExpertRepository, PersonRepository<Expert> {

    @Override
    public Class<Expert> getEntityClass() {
        return Expert.class;
    }

    @Override
    public List<ExpertDTO> findAllByStatus(AccountStatus status) {
        var session = getSessionFactory().getCurrentSession();
        String sql = "select expert.id                                   as id," +
                "       concat(expert.first_name, ' ', expert.last_name) as expertFullName, " +
                "       s.name                                           as serviceName, " +
                "       c.name                                           as categoryName " +
                "from expert " +
                "         inner join expert_service es on expert.id = es.expert_id " +
                "         inner join service s on s.id = es.service_id " +
                "         inner join category c on c.id = s.category_id " +
                "where expert.status = :status";
        var query = session.createNativeQuery(sql);
        query.setParameter("status",status);
        query.setResultTransformer(Transformers.aliasToBean(ExpertDTO.class));
        return query.list();
    }

    @Override
    public List<ExpertDTO> findAllByCategory(String categoryName) {
        var session = getSessionFactory().getCurrentSession();
        String sql = "select expert.id                                   as id, " +
                "       concat(expert.first_name, ' ', expert.last_name) as expertFullName, " +
                "       s.name                                           as serviceName, " +
                "       c.name                                           as categoryName " +
                "from expert " +
                "         inner join expert_service es on expert.id = es.expert_id " +
                "         inner join service s on s.id = es.service_id " +
                "         inner join category c on c.id = s.category_id " +
                "where c.name = :categoryName";
        var query = session.createNativeQuery(sql);
        query.setParameter("categoryName",categoryName);
        query.setResultTransformer(Transformers.aliasToBean(ExpertDTO.class));
        return query.list();
    }


}
