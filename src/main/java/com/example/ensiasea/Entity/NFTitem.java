package com.example.ensiasea.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "nftItems")
public class NFTitem {

    // foreign key : "PriceHistoryId" , "ListingsId" maghaykounouch
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

    // enum
    @Column(nullable = false)
    private String nftItemCategory;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "nftItemOwnerId"/*,nullable = false*/)
    private User nftItemOwnerId;

    // Link to the NFT item's price history*
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToOne(mappedBy = "nftItem", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private PriceHistory priceHistory;

    // Link to the NFT item's offers
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "offerNftItemId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Offer> offers;

    /**
     * @return Long return the nftItemId
     */
    public Long getNftItemId() {
        return nftItemId;
    }

    /**
     * @param nftItemId the nftItemId to set
     */
    public void setNftItemId(Long nftItemId) {
        this.nftItemId = nftItemId;
    }

    /**
     * @return String return the nftItemPicture
     */
    public String getNftItemPicture() {
        return nftItemPicture;
    }

    /**
     * @param nftItemPicture the nftItemPicture to set
     */
    public void setNftItemPicture(String nftItemPicture) {
        this.nftItemPicture = nftItemPicture;
    }

    /**
     * @return String return the nftItemName
     */
    public String getNftItemName() {
        return nftItemName;
    }

    /**
     * @param nftItemName the nftItemName to set
     */
    public void setNftItemName(String nftItemName) {
        this.nftItemName = nftItemName;
    }

    /**
     * @return String return the nftItemDescription
     */
    public String getNftItemDescription() {
        return nftItemDescription;
    }

    /**
     * @param nftItemDescription the nftItemDescription to set
     */
    public void setNftItemDescription(String nftItemDescription) {
        this.nftItemDescription = nftItemDescription;
    }

    /**
     * @return float return the nftItemPrice
     */
    public float getNftItemPrice() {
        return nftItemPrice;
    }

    /**
     * @param nftItemPrice the nftItemPrice to set
     */
    public void setNftItemPrice(float nftItemPrice) {
        this.nftItemPrice = nftItemPrice;
    }

    /**
     * @return String return the nftItemCategory
     */
    public String getNftItemCategory() {
        return nftItemCategory;
    }

    /**
     * @param nftItemCategory the nftItemCategory to set
     */
    public void setNftItemCategory(String nftItemCategory) {
        this.nftItemCategory = nftItemCategory;
    }

    /**
     * @return Date return the CreationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param CreationDate the CreationDate to set
     */
    public void setCreationDate(Date CreationDate) {
        this.creationDate = CreationDate;
    }

    /**
     * @return User return the nftItemOwnerId
     */
    public User getNftItemOwnerId() {
        return nftItemOwnerId;
    }

    /**
     * @param nftItemOwnerId the nftItemOwnerId to set
     */
    public void setNftItemOwnerId(User nftItemOwnerId) {
        this.nftItemOwnerId = nftItemOwnerId;
    }

    /**
     * @return PriceHistory return the priceHistory
     */
    public PriceHistory getPriceHistory() {
        return priceHistory;
    }

    /**
     * @param priceHistory the priceHistory to set
     */
    public void setPriceHistory(PriceHistory priceHistory) {
        this.priceHistory = priceHistory;
    }

    /**
     * @return List<Offer> return the offers
     */
    public List<Offer> getOffers() {
        return offers;
    }

    /**
     * @param offers the offers to set
     */
    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @Override
    public String toString() {
        return "NFTitem [creationDate=" + creationDate + ", nftItemCategory=" + nftItemCategory
                + ", nftItemDescription=" + nftItemDescription + ", nftItemId=" + nftItemId + ", nftItemName="
                + nftItemName + ", nftItemOwnerId=" + nftItemOwnerId + ", nftItemPicture=" + nftItemPicture
                + ", nftItemPrice=" + nftItemPrice + ", offers=" + offers + ", priceHistory=" + priceHistory + "]";
    }

    public NFTitem() {
    }

    public NFTitem(Long nftItemId, String nftItemPicture, String nftItemName, String nftItemDescription, float nftItemPrice, String nftItemCategory, Date creationDate, User nftItemOwnerId, PriceHistory priceHistory, List<Offer> offers) {
        this.nftItemId = nftItemId;
        this.nftItemPicture = nftItemPicture;
        this.nftItemName = nftItemName;
        this.nftItemDescription = nftItemDescription;
        this.nftItemPrice = nftItemPrice;
        this.nftItemCategory = nftItemCategory;
        this.creationDate = creationDate;
        this.nftItemOwnerId = nftItemOwnerId;
        this.priceHistory = priceHistory;
        this.offers = offers;
    }
}
