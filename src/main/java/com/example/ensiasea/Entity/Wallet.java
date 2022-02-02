package com.example.ensiasea.Entity;

import javax.persistence.*;


@Entity
@Table(name = "wallets")
public class Wallet {
    
    // foreign key : userId

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long WalletId;
    
    @Column(nullable = false, length = 45)
    private String Currency;
    
    @Column(nullable = false, length = 45)
    private float balance;

    @JoinColumn(name = "user_id")
    @OneToOne(fetch = FetchType.LAZY)
    private User ownerId;



    // getters & setters


    public Long getWalletId() {
        return this.WalletId;
    }

    public void setWalletId(Long WalletId) {
        this.WalletId = WalletId;
    }

    public float getBalance() {
        return this.balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public User getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(User ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "WalletId=" + WalletId +
                ", Currency='" + Currency + '\'' +
                ", balance=" + balance +
                ", ownerId=" + ownerId +
                '}';
    }
}
