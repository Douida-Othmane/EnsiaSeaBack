package com.example.ensiasea.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "nft_items")
public class NFTitem {

    // foreign key : "PriceHistoryId" , "ListingsId"
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(nullable = false, unique = true, length = 60)
    private Long itemId;
    // image alkhut

    @Column(nullable = false, unique = true, length = 60)
    private String name;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false)
    private Long category;

    @Column(nullable = false, unique = true, length = 60)
    private String OwnerName;

    @Column(nullable = false, unique = true)
    private Long OffersId;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;

    public Long getId() {
        return this.itemId;
    }

    public void setId(Long id) {
        this.itemId = id;
    }
    
    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getCategory() {
        return this.category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public String getOwnerName() {
        return this.OwnerName;
    }

    public void setOwnerName(String OwnerName) {
        this.OwnerName = OwnerName;
    }

    public Long getOffersId() {
        return this.OffersId;
    }

    public void setOffersId(Long OffersId) {
        this.OffersId = OffersId;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
}
