package com.example.ensiasea.Entity;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 60)
    private String username;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(nullable = false, length = 500)
    private String userDescription;

    @Column(nullable = false, length = 60)
    private String userCode;

    @Column()
    private String userPicture;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "nftItemOwnerId")
    private List<NFTitem> NFTitems;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "offerMakerId")
    private List<Offer> offers;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToOne(mappedBy = "ownerId" )
    private Wallet wallet;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public List<NFTitem> getNFTitems() {
        return NFTitems;
    }

    public void setNFTitems(List<NFTitem> NFTitems) {
        this.NFTitems = NFTitems;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}