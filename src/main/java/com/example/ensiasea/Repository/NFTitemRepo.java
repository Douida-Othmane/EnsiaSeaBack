package com.example.ensiasea.Repository;

import com.example.ensiasea.Entity.NFTitem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NFTitemRepo extends JpaRepository<NFTitem, Long> {

    Optional<NFTitem> findNftItemById(Long id);

    void deleteNftItemById(Long id);
}
