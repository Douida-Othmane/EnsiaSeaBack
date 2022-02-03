package com.example.ensiasea.Controller;

import java.util.List;

import com.example.ensiasea.Service.OffersService;

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
public class OffersController {

    private final OffersService offersService;

    public OffersController(OffersService offersService) {
        this.offersService = offersService;
    }

    @GetMapping()
    public ResponseEntity<List<Offer>> getAllOffers() {
        List<Offer> offers = offersService.findAllOffers();
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Offer> addOffer(@RequestBody Offer offer) {
        Offer NewOffer = offersService.addOffer(offer);
        return new ResponseEntity<>(NewOffer, HttpStatus.CREATED);
    }

    @DeleteMapping("/{OfferId}")
    public ResponseEntity<?> deleteOffersByOfferId(@PathVariable("OfferId") Long OfferId) {
        offersService.deleteOffersByOfferId(OfferId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
