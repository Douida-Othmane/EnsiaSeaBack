package com.example.ensiasea.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.*;

import com.example.ensiasea.Models.Offer;

@EnableJpaRepositories
public interface OfferRepo extends JpaRepository<Offer, Long> {

    Optional<Offer> findOfferByOfferId(Long OfferId);
}
