package com.example.ensiasea.Entity;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;

    @ManyToOne
    @JoinColumn(name = "offerMkaerId")
    private User offerMakerId;

    @JoinColumn(name = "nftItemId")
    @ManyToOne(fetch = FetchType.LAZY)
    private NFTitem offerNftItemId;

    @Column(nullable = false)
    private Boolean hasExpired;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date OfferDate;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date ExpirationDate;

    @Column(nullable = false)
    private float offerPrice;

}
