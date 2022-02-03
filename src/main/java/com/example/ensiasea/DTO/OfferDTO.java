package com.example.ensiasea.DTO;

import java.util.Date;

import lombok.Data;

@Data
public class OfferDTO {

    private Long offerId;
    private Long offerMakerId;
    private Long offerNftItemId;
    private Boolean hasExpired;
    private Date offerDate;
    private Date expirationDate;
    private float offerPrice;
}
