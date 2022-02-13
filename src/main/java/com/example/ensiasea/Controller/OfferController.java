package com.example.ensiasea.Controller;

import java.util.List;

import com.example.ensiasea.Service.OfferService;
import com.example.ensiasea.DTO.OfferDTO;
import com.example.ensiasea.Entity.Offer;
import com.example.ensiasea.Response.OfferResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offersService) {
        this.offerService = offersService;
    }

    @GetMapping()
    public ResponseEntity<OfferResponse> getAllOffers() {
        List<Offer> offers = offerService.findAllOffers();
        return new ResponseEntity<>(
                new OfferResponse(true, null, "Getting All Offers successfully", offers.size(), offers, null),
                HttpStatus.OK);
    }

    @GetMapping("/{OfferId}")
    public ResponseEntity<OfferResponse> getOfferByOfferId(@PathVariable("OfferId") Long OfferId) {
        Offer offer = offerService.findOfferByOfferId(OfferId);
        return new ResponseEntity<>(new OfferResponse(true, null, "Getting Offer successfully", 0, null, offer),
                HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<OfferResponse> addOffer(@RequestBody OfferDTO offer) {
        Offer NewOffer = offerService.addOffer(offer);
        return new ResponseEntity<>(new OfferResponse(true, null, "Creating Offer successfully", 0, null, NewOffer),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/{OfferId}")
    public ResponseEntity<OfferResponse> deleteOfferByOfferId(@PathVariable("OfferId") Long OfferId) {
        offerService.deleteOffer(OfferId);
        return new ResponseEntity<>(new OfferResponse(true, null, "Deleting Offer successfully", 0, null, null),
                HttpStatus.OK);
    }

}
