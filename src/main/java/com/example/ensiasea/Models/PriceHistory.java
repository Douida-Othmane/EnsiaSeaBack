package com.example.ensiasea.Models;

import javax.persistence.*;

import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "priceHistory")
public class PriceHistory {

    // foreign keys : "itemId"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceHistoryID;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date transactionDate;

    @Column(nullable = false)
    private String previousOwner;

    @Column(nullable = false)
    private float priceHistoryPrice;

    // Every NFT item has ONE Price history
    @JoinColumn(name = "item_id")
    @OneToOne(fetch = FetchType.LAZY)
    private NFTitem nftItem;

}
