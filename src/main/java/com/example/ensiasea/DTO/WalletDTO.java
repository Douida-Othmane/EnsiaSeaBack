package com.example.ensiasea.DTO;

import lombok.Data;

@Data
public class WalletDTO {

    private Long walletId;
    private String currency;
    private float balance;
    private Long ownerId;
}
