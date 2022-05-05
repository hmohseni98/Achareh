package repository;

import model.Expert;
import model.Offer;
import repository.base.BaseRepository;
import service.dto.OfferDTO;

import java.sql.Date;
import java.util.List;

public interface OfferRepository extends BaseRepository<Offer, Integer> {
    List<OfferDTO> findAllOfferByExpert(Expert expert);

    List<OfferDTO> findAllOfferByDate(Date date);


}
