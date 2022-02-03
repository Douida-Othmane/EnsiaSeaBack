package com.example.ensiasea.Service;

import java.util.List;

import com.example.ensiasea.DTO.OfferDTO;
import com.example.ensiasea.Entity.Offer;
import com.example.ensiasea.Repository.OfferRepo;
import com.example.ensiasea.Exception.OfferNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {
    private final OfferRepo offerRepo;
    private final UserService userService;
    private final NFTitemService nftItemService;

    @Autowired
    public OfferService(OfferRepo offerRepo, UserService userService, NFTitemService nftItemService) {
        this.offerRepo = offerRepo;
        this.userService = userService;
        this.nftItemService = nftItemService;
    }

    public Offer addOffer(OfferDTO offerDTO) {
        Offer offer = new Offer();
        BeanUtils.copyProperties(offerDTO, offer, "offerId", "offerMakerId", "offerNftItemId");
        offer.setOfferMakerId(userService.findUserById(offerDTO.getOfferMakerId()));
        offer.setOfferNftItemId(nftItemService.findNftItemByNftItemId(offerDTO.getOfferNftItemId()));
        return offerRepo.save(offer);
    }

    public List<Offer> findAllOffers() {
        return offerRepo.findAll();
    }

    public Offer findOfferByOfferId(Long OfferId) {
        return offerRepo.findOfferByOfferId(OfferId)
                .orElseThrow(() -> new OfferNotFoundException("Offer by id " + OfferId + "was not found"));
    }

    public void deleteOffer(Long OfferId) {
        offerRepo.deleteById(OfferId);
    }

}
