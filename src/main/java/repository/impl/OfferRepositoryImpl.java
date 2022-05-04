package repository.impl;

import model.Expert;
import model.Offer;
import repository.OfferRepository;
import repository.base.BaseRepositoryImpl;

import java.sql.Date;
import java.util.List;

public class OfferRepositoryImpl extends BaseRepositoryImpl<Offer, Integer> implements OfferRepository {
    @Override
    public List<Offer> findAllOfferByExpert(Expert expert) {
        var session = getSessionFactory().getCurrentSession();
        String sql = "select * from offer " +
                "inner join expert e on e.id = offer.expert_id " +
                "where offer.expert_id = :expert_id ";
        var query = session.createNativeQuery(sql, Offer.class);
        query.setParameter("expert_id", expert.getId());
        return query.getResultList();
    }

    @Override
    public List<Offer> findAllOfferByDate(Date date) {
        var session = getSessionFactory().getCurrentSession();
        String sql = "select * from offer " +
                "where submit_date = :date";
        var query = session.createNativeQuery(sql, Offer.class);
        query.setParameter("date", date);
        return query.getResultList();
    }
}
