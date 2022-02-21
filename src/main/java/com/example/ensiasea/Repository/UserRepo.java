package com.example.ensiasea.Repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.example.ensiasea.Models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findUserByUserId(Long userId);

    User findByEmail(String email);

    User findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
