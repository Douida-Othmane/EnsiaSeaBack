package com.example.ensiasea.Entity;

import java.util.Date;

import javax.persistence.Column;

public class Offers {
    
    //foreign key : itemId, price, UserId
    
    @Column(nullable = false, unique = true)
    private Long OfferId;

    private Long OfferMakerId;

    private Long statut;

    private Date OfferDate;

    private Date ExDate;

    public Long getOfferId() {
        return this.OfferId;
    }

    public void setOfferId(Long OfferId) {
        this.OfferId = OfferId;
    }

    public Long getOfferMakerId() {
        return this.OfferMakerId;
    }

    public void setOfferMakerId(Long OfferMakerId) {
        this.OfferMakerId = OfferMakerId;
    }

    public Long getStatut() {
        return this.statut;
    }

    public void setStatut(Long statut) {
        this.statut = statut;
    }

    public Date getOfferDate() {
        return this.OfferDate;
    }

    public void setOfferDate(Date OfferDate) {
        this.OfferDate = OfferDate;
    }

    public Date getExDate() {
        return this.ExDate;
    }

    public void setExDate(Date ExDate) {
        this.ExDate = ExDate;
    }
    



}
