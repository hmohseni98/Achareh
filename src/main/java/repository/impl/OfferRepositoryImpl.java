package repository.impl;

import model.Expert;
import model.Offer;
import org.hibernate.transform.Transformers;
import repository.OfferRepository;
import repository.base.BaseRepositoryImpl;
import service.dto.ExpertDTO;
import service.dto.OfferDTO;

import java.sql.Date;
import java.util.List;

public class OfferRepositoryImpl extends BaseRepositoryImpl<Offer, Integer> implements OfferRepository {
    @Override
    public Class<Offer> getEntityClass() {
        return Offer.class;
    }

    @Override
    public List<OfferDTO> findAllOfferByExpert(Expert expert) {
        var session = getSessionFactory().getCurrentSession();
        String sql = "select offer.id                          as id, " +
                "       concat(e.first_name, ' ', e.last_name) as expertFullName, " +
                "       concat(c.first_name, ' ', c.last_name) as customerFullName, " +
                "       o.description                          as orderDescription, " +
                "       s.name                                 as serviceName, " +
                "       o.suggestion_price as customerSuggestionPrice, " +
                "       offer.suggestion_price as expertSuggestionPrice, " +
                "       offer.duration_of_work as durationOfWork, " +
                "       offer.start_work_time as startWorkTime " +
                "from offer " +
                "         inner join expert e on e.id = offer.expert_id " +
                "         inner join orders o on e.id = o.accept_expert_id " +
                "         inner join customer c on c.id = o.customer_id " +
                "         inner join service s on s.id = o.service_id " +
                "where offer.expert_id = :expert_id";
        var query = session.createNativeQuery(sql);
        query.setParameter("expert_id", expert.getId());
        query.setResultTransformer(Transformers.aliasToBean(OfferDTO.class));
        return query.list();
    }

    @Override
    public List<OfferDTO> findAllOfferByDate(Date date) {
        var session = getSessionFactory().getCurrentSession();
        String sql = "select offer.id                          as id, " +
                "       concat(e.first_name, ' ', e.last_name) as expertFullName, " +
                "       concat(c.first_name, ' ', c.last_name) as customerFullName, " +
                "       o.description                          as orderDescription, " +
                "       s.name                                 as serviceName, " +
                "       o.suggestion_price as customerSuggestionPrice, " +
                "       offer.suggestion_price as expertSuggestionPrice, " +
                "       offer.duration_of_work as durationOfWork, " +
                "       offer.start_work_time as startWorkTime " +
                "from offer " +
                "         inner join expert e on e.id = offer.expert_id " +
                "         inner join orders o on e.id = o.accept_expert_id " +
                "         inner join customer c on c.id = o.customer_id " +
                "         inner join service s on s.id = o.service_id " +
                "where offer.submit_date = :date";
        var query = session.createNativeQuery(sql);
        query.setParameter("date", date);
        query.setResultTransformer(Transformers.aliasToBean(OfferDTO.class));
        return query.list();
    }
}
