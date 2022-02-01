package com.example.ensiasea.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "listings")
public class Listings {
    
    // foreign key : "itemId"
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ListingsId;


    public Long getListingsId() {
        return this.ListingsId;
    }

    public void setListingsId(Long ListingsId) {
        this.ListingsId = ListingsId;
    }

}
