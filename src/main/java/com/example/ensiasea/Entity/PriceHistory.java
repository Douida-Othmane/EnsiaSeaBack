package com.example.ensiasea.Entity;

import java.util.Date;

public class PriceHistory {

    // foreign keys : "price", "itemId"
   

    private Long PriceHistoryID;
    private Date date;
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
