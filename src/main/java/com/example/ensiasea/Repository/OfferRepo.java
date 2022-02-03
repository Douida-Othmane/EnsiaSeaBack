package com.example.ensiasea.Repository;

import com.example.ensiasea.Entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.*;

@EnableJpaRepositories
public interface OfferRepo extends JpaRepository<Offer, Long> {

    Optional<Offer> findOfferByOfferId(Long OfferId);
}
