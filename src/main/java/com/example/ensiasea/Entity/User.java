package com.example.ensiasea.Entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


import lombok.Data;
import lombok.ToString;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Data
@ToString
@Table(name = "users")
@JsonInclude(value = Include.NON_NULL)
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
    @JsonManagedReference(value = "usernftitems")
    private List<NFTitem> nftitems;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "offerMakerId")
    @JsonManagedReference(value = "useroffers")
    private List<Offer> offers;

    @JsonManagedReference(value = "userwallets")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToOne(mappedBy = "ownerId")
    private Wallet wallet;

}