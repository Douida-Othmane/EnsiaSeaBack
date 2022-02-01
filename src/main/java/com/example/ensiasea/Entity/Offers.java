package com.example.ensiasea.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "offers")
public class Offers {
    
    //foreign key : UserId, itemId, price, UserId

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OfferId;

    @Column(nullable = false)
    private Long statut;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date OfferDate;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date ExDate;

    // getters & setters

    public Long getOfferId() {
        return this.OfferId;
    }

    public void setOfferId(Long OfferId) {
        this.OfferId = OfferId;
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
