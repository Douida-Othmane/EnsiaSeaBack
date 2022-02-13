package com.example.ensiasea.Entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@Entity
@Table(name = "wallets")
@JsonInclude(value = Include.NON_NULL)
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long walletId;

    @Column(nullable = false, length = 45)
    private String currency;

    @Column(nullable = false, length = 45)
    private float balance;

    @JsonBackReference(value = "userwallets")
    @JoinColumn(name = "user_id")
    @OneToOne(fetch = FetchType.LAZY)
    private User ownerId;

}
