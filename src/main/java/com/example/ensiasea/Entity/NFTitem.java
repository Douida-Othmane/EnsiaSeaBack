package com.example.ensiasea.Entity;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "nftItems")
public class NFTitem {

    // foreign key : "PriceHistoryId" , "ListingsId" maghaykounouch
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String nft;

    @Column(nullable = false, unique = true, length = 60)
    private String name;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false)
    private float price;

    //enum
    @Column(nullable = false)
    private String category;

    @Column(nullable = false, unique = true)
    private Long OffersId;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "OwnerId")
    private User itemOwnerId;

    //Link to the NFT item's price history
    @OneToOne(mappedBy = "nftItem", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private PriceHistory priceHistory;

    //Link to the NFT item's offers
    @OneToOne(mappedBy = "nftItemId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Offers offer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNft() {
        return nft;
    }

    public void setNft(String nft) {
        this.nft = nft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getOffersId() {
        return OffersId;
    }

    public void setOffersId(Long offersId) {
        OffersId = offersId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getItemOwnerId() {
        return itemOwnerId;
    }

    public void setItemOwnerId(User itemOwnerId) {
        this.itemOwnerId = itemOwnerId;
    }

    public PriceHistory getPriceHistory() {
        return priceHistory;
    }

    public void setPriceHistory(PriceHistory priceHistory) {
        this.priceHistory = priceHistory;
    }

    public Offers getOffer() {
        return offer;
    }

    public void setOffer(Offers offer) {
        this.offer = offer;
    }
}
