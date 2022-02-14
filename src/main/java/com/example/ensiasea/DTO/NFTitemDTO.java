package com.example.ensiasea.DTO;

import java.util.Date;


import lombok.Data;

@Data
public class NFTitemDTO {
    private Long nftItemId;
    private String nftItemPicture;
    private String nftItemName;
    private String nftItemDescription;
    private float nftItemPrice;
    private String nftItemCategory;
    private Date creationDate;
    private Long nftItemOwnerId;
}
