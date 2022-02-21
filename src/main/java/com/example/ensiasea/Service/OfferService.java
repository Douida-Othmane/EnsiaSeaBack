package com.example.ensiasea.Service;

import java.util.List;

import com.example.ensiasea.DTO.OfferDTO;
import com.example.ensiasea.Repository.OfferRepo;
import com.example.ensiasea.Exception.ApiRequestException;
import com.example.ensiasea.Models.Offer;

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
        try {
            Offer offer = new Offer();
            BeanUtils.copyProperties(offerDTO, offer, "offerId", "offerMakerId", "offerNftItemId");
            offer.setOfferMakerId(userService.findUserById(offerDTO.getOfferMakerId()));
            offer.setOfferNftItemId(nftItemService.findNftItemByNftItemId(offerDTO.getOfferNftItemId()));
            return offerRepo.save(offer);
        } catch (Exception exception) {
            throw new ApiRequestException("Error While Creating An Offer", exception.getMessage());
        }
    }

    public List<Offer> findAllOffers() {
        try {
            return offerRepo.findAll();

        } catch (Exception exception) {
            throw new ApiRequestException("Error While Getting All Offers", exception.getMessage());
        }
    }

    public Offer findOfferByOfferId(Long OfferId) {
        return offerRepo.findOfferByOfferId(OfferId)
                .orElseThrow(() -> new ApiRequestException("Error While Getting An Offer"));
    }

    public void deleteOffer(Long OfferId) {
        try {
            offerRepo.deleteById(OfferId);
        } catch (Exception exception) {
            throw new ApiRequestException("Error While Deleting An Offer", exception.getMessage());
        }
    }

}
