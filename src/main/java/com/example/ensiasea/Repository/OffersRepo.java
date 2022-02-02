package com.example.ensiasea.Repository;

import com.example.ensiasea.Entity.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.*;

@EnableJpaRepositories
public interface OffersRepo extends JpaRepository<Offers, Long> {
   
    Optional<Offers> findOffersByOfferId(Long OfferId);

    void deleteOffersByOfferId(Long OfferId);
    
}
