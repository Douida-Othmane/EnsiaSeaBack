package com.example.ensiasea.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;

@Entity
@Data
@Table(name = "nftItems")
@JsonInclude(value = Include.NON_NULL)
public class NFTitem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nftItemId;

    @Column()
    private String nftItemPicture;

    @Column(nullable = false, unique = true, length = 60)
    private String nftItemName;

    @Column(nullable = false, length = 500)
    private String nftItemDescription;

    @Column(nullable = false)
    private float nftItemPrice;

    @Column(nullable = false)
    private String nftItemCategory;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "nftItemOwnerId"/* ,nullable = false */)
    @JsonBackReference(value = "usernftitems")
    private User nftItemOwnerId;

    // Link to the NFT item's price history*
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToOne(mappedBy = "nftItem", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private PriceHistory priceHistory;

    // Link to the NFT item's offers
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "offerNftItemId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "nftitemoffers")
    private List<Offer> offers;

}
