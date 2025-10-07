package com.shopingOnline.virtualShopping.repository;

import com.shopingOnline.virtualShopping.entity.ClientAdress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientAdressRepository extends JpaRepository<ClientAdress, Long> {
    String findByCep(String cep);
}
