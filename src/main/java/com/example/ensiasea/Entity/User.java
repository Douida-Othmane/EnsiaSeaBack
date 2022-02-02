package com.example.ensiasea.Entity;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

/**
 * User
 */

@Entity
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
    @OneToMany(mappedBy = "nftItemOwnerId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NFTitem> NFTitems;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "offerMakerId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Offer> offers;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToOne(mappedBy = "ownerId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Wallet wallet;

    // Getters and Setters

    /**
     * @return Long return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return String return the userDescription
     */
    public String getUserDescription() {
        return userDescription;
    }

    /**
     * @param userDescription the userDescription to set
     */
    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    /**
     * @return String return the userCode
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * @param userCode the userCode to set
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    /**
     * @return String return the userPicture
     */
    public String getUserPicture() {
        return userPicture;
    }

    /**
     * @param userPicture the userPicture to set
     */
    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    /**
     * @return List<NFTitem> return the NFTitems
     */
    public List<NFTitem> getNFTitems() {
        return NFTitems;
    }

    /**
     * @param NFTitems the NFTitems to set
     */
    public void setNFTitems(List<NFTitem> NFTitems) {
        this.NFTitems = NFTitems;
    }

    /**
     * @return List<Offer> return the offers
     */
    public List<Offer> getOffers() {
        return offers;
    }

    /**
     * @param offers the offers to set
     */
    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    /**
     * @return Wallet return the wallet
     */
    public Wallet getWallet() {
        return wallet;
    }

    /**
     * @param wallet the wallet to set
     */
    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "User [NFTitems=" + NFTitems + ", email=" + email + ", offers=" + offers + ", password=" + password
                + ", userCode=" + userCode + ", userDescription=" + userDescription + ", userId=" + userId
                + ", userPicture=" + userPicture + ", username=" + username + ", wallet=" + wallet + "]";
    }

}