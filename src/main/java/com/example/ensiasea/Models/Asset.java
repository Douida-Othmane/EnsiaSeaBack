package com.example.ensiasea.Models;

import lombok.Data;

@Data
public class Asset {
    private String ID;
    private String Type;
    private String Owner;
    private String CheckSum;
    private Integer Price;

    public Asset(String id, String type, String owner, String checksum, Integer price) {
        this.ID = id;
        this.Type = type;
        this.Owner = owner;
        this.CheckSum = checksum;
        this.Price = price;
    }
}
