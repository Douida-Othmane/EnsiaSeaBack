package com.example.ensiasea.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AssetP {
    private String assetId;
    private String type;
    private String owner;
    private String checksum;
    private float price;

    public AssetP(String assetId, String type, String owner, String checksum,
            float price) {
        this.assetId = assetId;
        this.type = type;
        this.owner = owner;
        this.checksum = checksum;
        this.price = price;
    }
}
