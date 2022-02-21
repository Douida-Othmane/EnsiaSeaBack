package com.example.ensiasea.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.example.ensiasea.Models.PriceHistory;

public interface PriceHistoryRepo extends JpaRepository<PriceHistory, Long> {

    Optional<PriceHistory> findPriceHistoryByPriceHistoryID(Long id);

}
