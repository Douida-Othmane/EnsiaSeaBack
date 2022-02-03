package com.example.ensiasea.Repository;

import com.example.ensiasea.Entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.*;

@EnableJpaRepositories
public interface OffersRepo extends JpaRepository<Offer, Long> {

    Optional<Offer> findOffersByOfferId(Long OfferId);

    void deleteOffersByOfferId(Long OfferId);

}
