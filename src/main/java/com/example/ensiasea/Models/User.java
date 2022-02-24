package com.example.ensiasea.Models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "users")
@JsonInclude(value = Include.NON_NULL)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 60, unique = true)
    private String username;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(length = 500)
    private String userDescription;

    @Column(nullable = false, length = 60, unique = true)
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

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();

    public User(String username, String email, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

}