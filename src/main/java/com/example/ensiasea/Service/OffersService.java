package com.example.ensiasea.Service;

import java.util.List;

import com.example.ensiasea.Entity.Offer;
import com.example.ensiasea.Repository.OffersRepo;
import com.example.ensiasea.Exception.OffersNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffersService {
    private final OffersRepo offersRepo;

    @Autowired
    public OffersService(OffersRepo offersRepo) {
        this.offersRepo = offersRepo;
    }

    public Offer addOffer(Offer offer) {
        return offersRepo.save(offer);
    }

    public List<Offer> findAllOffers() {
        return offersRepo.findAll();
    }

    public Offer findOffersByOfferId(Long OfferId) {
        return offersRepo.findOffersByOfferId(OfferId)
                .orElseThrow(() -> new OffersNotFoundException("Offer by id " + OfferId + "was not found"));
    }

    public void deleteOffersByOfferId(Long OfferId) {
        offersRepo.deleteOffersByOfferId(OfferId);
    }

}
