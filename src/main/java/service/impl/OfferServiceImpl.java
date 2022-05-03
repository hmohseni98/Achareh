package service.impl;

import model.Offer;
import repository.OfferRepository;
import service.OfferService;
import service.base.BaseServiceImpl;

public class OfferServiceImpl extends BaseServiceImpl<OfferRepository, Offer,Integer> implements OfferService {
    public OfferServiceImpl(OfferRepository repository) {
        super(repository, Offer.class);
    }
}
