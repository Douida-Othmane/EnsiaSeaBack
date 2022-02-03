package com.example.ensiasea.Controller;

import java.util.List;

import com.example.ensiasea.Service.OfferService;
import com.example.ensiasea.DTO.OfferDTO;
import com.example.ensiasea.Entity.Offer;
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
    public ResponseEntity<List<Offer>> getAllOffers() {
        List<Offer> offers = offerService.findAllOffers();
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    @GetMapping("/{OfferId}")
    public ResponseEntity<Offer> getOfferByOfferId(@PathVariable("OfferId") Long OfferId) {
        Offer offer = offerService.findOfferByOfferId(OfferId);
        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Offer> addOffer(@RequestBody OfferDTO offer) {
        Offer NewOffer = offerService.addOffer(offer);
        return new ResponseEntity<>(NewOffer, HttpStatus.CREATED);
    }

    @DeleteMapping("/{OfferId}")
    public ResponseEntity<?> deleteOfferByOfferId(@PathVariable("OfferId") Long OfferId) {
        offerService.deleteOffer(OfferId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
