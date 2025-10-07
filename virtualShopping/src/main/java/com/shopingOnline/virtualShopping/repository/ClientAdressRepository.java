package com.shopingOnline.virtualShopping.repository;

import com.shopingOnline.virtualShopping.entity.ClientAdress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientAdressRepository extends JpaRepository<ClientAdress, Long> {
    @Query(value = "select cep from client_adress where client_id = :client and cep = :cep", nativeQuery = true)
    String findByCep(@Param("cep") String cep, @Param("client") Long client);

}
