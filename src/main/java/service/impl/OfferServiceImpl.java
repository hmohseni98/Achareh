package service.impl;

import customException.SuggestionPriceMustBeHigherThanTheBasePrice;
import customException.AccountNotActive;
import model.Expert;
import model.Offer;
import model.enumration.AccountStatus;
import repository.OfferRepository;
import service.OfferService;
import service.base.BaseServiceImpl;
import service.dto.OfferDTO;

import java.sql.Date;
import java.util.List;

public class OfferServiceImpl extends BaseServiceImpl<OfferRepository, Offer, Integer> implements OfferService {
    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        super(offerRepository, Offer.class);
        this.offerRepository = offerRepository;
    }

    @Override
    public void save(Offer offer) {
        try {
            if (!(offer.getExpert().getStatus().equals(AccountStatus.active))) {
                throw new AccountNotActive();
            }
            if (offer.getSuggestionPrice() < offer.getOrder().getService().getBasePrice()) {
                throw new SuggestionPriceMustBeHigherThanTheBasePrice();
            }
            super.save(offer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<OfferDTO> findAllOfferByExpert(Expert expert) {
        List<OfferDTO> offerList;
        try (var session = getSessionFactory().getCurrentSession()) {
            var transaction = session.beginTransaction();
            try {
                offerList = offerRepository.findAllOfferByExpert(expert);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return offerList;
    }

    @Override
    public List<OfferDTO> findAllOfferByDate(Date date) {
        List<OfferDTO> offerList;
        try (var session = getSessionFactory().getCurrentSession()) {
            var transaction = session.beginTransaction();
            try {
                offerList = offerRepository.findAllOfferByDate(date);
                transaction.commit();
            } catch (Exception ex) {
                transaction.rollback();
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return offerList;
    }
}
