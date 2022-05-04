package repository.impl;

import model.Expert;
import model.enumration.AccountStatus;
import repository.ExpertRepository;

import java.util.List;


public class ExpertRepositoryImpl extends BasePersonRepositoryImpl<Expert,Integer> implements ExpertRepository {
    @Override
    public List<Expert> findAllByStatus(AccountStatus status) {
        var session = getSessionFactory().getCurrentSession();
        String sql = "select * from expert where status = :status";
        var query = session.createNativeQuery(sql,Expert.class);
        query.setParameter("status",status);
        return query.getResultList();
    }

    @Override
    public List<Expert> findAllByCategory(String categoryName) {
        var session = getSessionFactory().getCurrentSession();
        String sql = "select * from expert " +
                "inner join expert_service es on expert.id = es.expert_id " +
                "inner join service s on s.id = es.service_id " +
                "where s.name = :category_name";
        var query = session.createNativeQuery(sql,Expert.class);
        query.setParameter("category_name",categoryName);
        return query.getResultList();
    }
}
