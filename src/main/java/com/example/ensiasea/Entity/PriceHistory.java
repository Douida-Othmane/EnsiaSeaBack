package com.example.ensiasea.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "priceHistory")

public class PriceHistory {

    // foreign keys : "itemId"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PriceHistoryID;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(nullable = false)
    private String PreviousOwner;

    @Column(nullable = false)
    private float price;

    //Every NFT item has ONE Price history
    @JoinColumn(name = "item_id")
    @OneToOne(fetch = FetchType.LAZY)
    private NFTitem nftItem;



    public Long getPriceHistoryID() {
        return this.PriceHistoryID;
    }

    public void setPriceHistoryID(Long PriceHistoryID) {
        this.PriceHistoryID = PriceHistoryID;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPreviousOwner() {
        return this.PreviousOwner;
    }

    public void setPreviousOwner(String PreviousOwner) {
        this.PreviousOwner = PreviousOwner;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public NFTitem getNftItem() {
        return nftItem;
    }

    public void setNftItem(NFTitem nftItem) {
        this.nftItem = nftItem;
    }


}
