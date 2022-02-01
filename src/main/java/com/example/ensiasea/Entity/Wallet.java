package com.example.ensiasea.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "wallets")
public class Wallet {
    
    // foreign key : userId

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long WalletId;
    
    @Column(nullable = false, unique = true, length = 45)
    private float Currency;
    
    @Column(nullable = false, unique = true, length = 45)
    private float balance;


    // getters & setters


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
