package service;

import model.Expert;
import model.Offer;
import service.base.BaseService;
import service.dto.OfferDTO;

import java.sql.Date;
import java.util.List;

public interface OfferService extends BaseService<Offer,Integer> {
    List<OfferDTO> findAllOfferByExpert(Expert expert);

    List<OfferDTO> findAllOfferByDate(Date date);
}
