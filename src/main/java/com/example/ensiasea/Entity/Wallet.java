package com.example.ensiasea.Entity;

public class Wallet {
    
    // foreign key : userId

    private Long WalletId;
    private float Currency;
    private float balance;



    public Long getWalletId() {
        return this.WalletId;
    }

    public void setWalletId(Long WalletId) {
        this.WalletId = WalletId;
    }

    public float getCurrency() {
        return this.Currency;
    }

    public void setCurrency(float Currency) {
        this.Currency = Currency;
    }

    public float getBalance() {
        return this.balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

}
