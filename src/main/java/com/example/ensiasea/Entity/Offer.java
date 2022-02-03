package com.example.ensiasea.Entity;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;

    @ManyToOne
    @JoinColumn(name = "offerMakerId")
    @JsonBackReference(value = "useroffers")
    private User offerMakerId;

    @JoinColumn(name = "nftItemId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "nftitemoffers")
    private NFTitem offerNftItemId;

    @Column(nullable = false)
    private Boolean hasExpired;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date offerDate;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    @Column(nullable = false)
    private float offerPrice;

}
