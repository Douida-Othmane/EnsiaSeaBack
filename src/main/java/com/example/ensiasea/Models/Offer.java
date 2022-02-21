package com.example.ensiasea.Models;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Entity
@Data
@Table(name = "offers")
@JsonInclude(value = Include.NON_NULL)
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
