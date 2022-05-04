package service;

import model.Expert;
import model.Offer;
import service.base.BaseService;

import java.sql.Date;
import java.util.List;

public interface OfferService extends BaseService<Offer,Integer> {
    List<Offer> findAllOfferByExpert(Expert expert);

    List<Offer> findAllOfferByDate(Date date);
}
