package com.shopingOnline.virtualShopping.repository;

import com.shopingOnline.virtualShopping.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByName(String email);

    Optional<Client> findByEmail(String email);
}
