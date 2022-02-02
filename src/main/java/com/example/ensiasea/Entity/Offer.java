package com.example.ensiasea.Entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "offers")
public class Offer {

    // foreign key : UserId, itemId, UserId

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

    // getters & setters

    /**
     * @return Long return the OfferId
     */
    public Long getOfferId() {
        return offerId;
    }

    /**
     * @param OfferId the OfferId to set
     */
    public void setOfferId(Long OfferId) {
        this.offerId = OfferId;
    }

    /**
     * @return User return the offerMakerId
     */
    public User getOfferMakerId() {
        return offerMakerId;
    }

    /**
     * @param offerMakerId the offerMakerId to set
     */
    public void setOfferMakerId(User offerMakerId) {
        this.offerMakerId = offerMakerId;
    }

    /**
     * @return NFTitem return the offerNftItemId
     */
    public NFTitem getOfferNftItemId() {
        return offerNftItemId;
    }

    /**
     * @param offerNftItemId the offerNftItemId to set
     */
    public void setOfferNftItemId(NFTitem offerNftItemId) {
        this.offerNftItemId = offerNftItemId;
    }

    /**
     * @return Boolean return the hasExpired
     */
    public Boolean isHasExpired() {
        return hasExpired;
    }

    /**
     * @param hasExpired the hasExpired to set
     */
    public void setHasExpired(Boolean hasExpired) {
        this.hasExpired = hasExpired;
    }

    /**
     * @return Date return the OfferDate
     */
    public Date getOfferDate() {
        return OfferDate;
    }

    /**
     * @param OfferDate the OfferDate to set
     */
    public void setOfferDate(Date OfferDate) {
        this.OfferDate = OfferDate;
    }

    /**
     * @return Date return the ExpirationDate
     */
    public Date getExpirationDate() {
        return ExpirationDate;
    }

    /**
     * @param ExpirationDate the ExpirationDate to set
     */
    public void setExpirationDate(Date ExpirationDate) {
        this.ExpirationDate = ExpirationDate;
    }

    /**
     * @return float return the offerPrice
     */
    public float getOfferPrice() {
        return offerPrice;
    }

    /**
     * @param offerPrice the offerPrice to set
     */
    public void setOfferPrice(float offerPrice) {
        this.offerPrice = offerPrice;
    }

    @Override
    public String toString() {
        return "Offer [ExpirationDate=" + ExpirationDate + ", OfferDate=" + OfferDate + ", OfferId=" + offerId
                + ", hasExpired=" + hasExpired + ", offerMakerId=" + offerMakerId + ", offerNftItemId=" + offerNftItemId
                + ", offerPrice=" + offerPrice + "]";
    }

}
