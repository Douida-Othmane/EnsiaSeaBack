package com.example.ensiasea.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.example.ensiasea.Models.NFTitem;

public interface NFTitemRepo extends JpaRepository<NFTitem, Long> {

    Optional<NFTitem> findNftItemByNftItemId(Long id);

}
