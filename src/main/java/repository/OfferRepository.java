package repository;

import model.Expert;
import model.Offer;
import repository.base.BaseRepository;

import java.sql.Date;
import java.util.List;

public interface OfferRepository extends BaseRepository<Offer, Integer> {
    List<Offer> findAllOfferByExpert(Expert expert);

    List<Offer> findAllOfferByDate(Date date);


}
