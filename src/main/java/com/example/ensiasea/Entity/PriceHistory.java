package com.example.ensiasea.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "priceHistory")

public class PriceHistory {

    // foreign keys : "price", "itemId"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PriceHistoryID;

    @Column(nullable = false, unique = true, updatable = false)
    private Date date;

    @Column(nullable = false, unique = true, updatable = false)
    private String PreviousOwner;


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


    
}
