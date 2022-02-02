package com.example.ensiasea.Entity;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "offers")
public class Offers {
    
    //foreign key : UserId, itemId, UserId

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OfferId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User offerMakerId;

    @JoinColumn(name = "item_id")
    @OneToOne(fetch = FetchType.LAZY)
    private NFTitem nftItemId;

    @Column(nullable = false)
    private Boolean hasExpired;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date OfferDate;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date ExpirationDate;

    @Column(nullable = false)
    private float price;

    // getters & setters

    public Long getOfferId() {
        return this.OfferId;
    }

    public void setOfferId(Long OfferId) {
        this.OfferId = OfferId;
    }

    public Date getOfferDate() {
        return this.OfferDate;
    }

    public void setOfferDate(Date OfferDate) {
        this.OfferDate = OfferDate;
    }

    public Date getExpirationDate() {
        return this.ExpirationDate;
    }

    public void setExpirationDate(Date ExDate) {
        this.ExpirationDate = ExDate;
    }

    public User getOfferMakerId() {
        return offerMakerId;
    }

    public void setOfferMakerId(User offerMakerId) {
        this.offerMakerId = offerMakerId;
    }

    public NFTitem getNftItemId() {
        return nftItemId;
    }

    public void setNftItemId(NFTitem nftItemId) {
        this.nftItemId = nftItemId;
    }

    public Boolean getHasExpired() {
        return hasExpired;
    }

    public void setHasExpired(Boolean hasExpired) {
        this.hasExpired = hasExpired;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Offers{" +
                "OfferId=" + OfferId +
                ", offerMakerId=" + offerMakerId +
                ", nftItemId=" + nftItemId +
                ", hasExpired=" + hasExpired +
                ", OfferDate=" + OfferDate +
                ", ExpirationDate=" + ExpirationDate +
                ", price=" + price +
                '}';
    }
}
