package com.example.ensiasea.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
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

    /**
     * @return Long return the priceHistoryID
     */
    public Long getPriceHistoryID() {
        return priceHistoryID;
    }

    /**
     * @param priceHistoryID the priceHistoryID to set
     */
    public void setPriceHistoryID(Long priceHistoryID) {
        this.priceHistoryID = priceHistoryID;
    }

    /**
     * @return Date return the transactionDate
     */
    public Date getTransactionDate() {
        return transactionDate;
    }

    /**
     * @param transactionDate the transactionDate to set
     */
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    /**
     * @return String return the previousOwner
     */
    public String getPreviousOwner() {
        return previousOwner;
    }

    /**
     * @param previousOwner the previousOwner to set
     */
    public void setPreviousOwner(String previousOwner) {
        this.previousOwner = previousOwner;
    }

    /**
     * @return float return the priceHistoryPrice
     */
    public float getPriceHistoryPrice() {
        return priceHistoryPrice;
    }

    /**
     * @param priceHistoryPrice the priceHistoryPrice to set
     */
    public void setPriceHistoryPrice(float priceHistoryPrice) {
        this.priceHistoryPrice = priceHistoryPrice;
    }

    /**
     * @return NFTitem return the nftItem
     */
    public NFTitem getNftItem() {
        return nftItem;
    }

    /**
     * @param nftItem the nftItem to set
     */
    public void setNftItem(NFTitem nftItem) {
        this.nftItem = nftItem;
    }

    @Override
    public String toString() {
        return "PriceHistory [nftItem=" + nftItem + ", previousOwner=" + previousOwner + ", priceHistoryID="
                + priceHistoryID + ", priceHistoryPrice=" + priceHistoryPrice + ", transactionDate=" + transactionDate
                + "]";
    }

}
