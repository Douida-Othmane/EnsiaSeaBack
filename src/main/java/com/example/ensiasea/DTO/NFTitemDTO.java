package com.example.ensiasea.DTO;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class NFTitemDTO {
    private Long nftItemId;
    private MultipartFile nftItemPicture;
    private String nftItemName;
    private String nftItemDescription;
    private float nftItemPrice;
    private String nftItemCategory;
    private Date creationDate;
    private Long nftItemOwnerId;
}
