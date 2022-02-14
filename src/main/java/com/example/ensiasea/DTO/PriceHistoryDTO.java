package com.example.ensiasea.DTO;

import java.util.Date;

import lombok.Data;

@Data
public class PriceHistoryDTO {

    private Long priceHistoryID;
    private Date transactionDate;
    private String previousOwner;
    private float priceHistoryPrice;
    private Long nftItemID;
}
