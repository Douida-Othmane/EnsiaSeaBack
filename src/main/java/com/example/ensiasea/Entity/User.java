package com.example.ensiasea.Entity;



import javax.persistence.*;

import java.util.List;

/**
 * User
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 60)
    private String username;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false, length = 60)
    private String usercode;

    @Column()
    private String pricture;

    //onetoone onetomany manytomany
    @OneToMany(mappedBy = "itemOwnerId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NFTitem> NFTitem;

    @OneToMany(mappedBy = "offerMakerId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Offers> offers;

    @OneToOne(mappedBy = "ownerId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Wallet wallet;

    // Getters and Setters


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<NFTitem> getNFTItems() {
        return NFTitem;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getPricture() {
        return pricture;
    }

    public void setPricture(String pricture) {
        this.pricture = pricture;
    }


    public List<com.example.ensiasea.Entity.NFTitem> getNFTitem() {
        return NFTitem;
    }

    public void setNFTitem(List<com.example.ensiasea.Entity.NFTitem> NFTitem) {
        this.NFTitem = NFTitem;
    }

    public List<Offers> getOffers() {
        return offers;
    }

    public void setOffers(List<Offers> offers) {
        this.offers = offers;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}