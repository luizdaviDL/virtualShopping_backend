package com.shopingOnline.virtualShopping.repository;

import com.shopingOnline.virtualShopping.entity.ClientInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientInformationRepository extends JpaRepository<ClientInformation, Long> {
    @Query(value = "select  * \n" +
            "from client_information as cl\n" +
            "where cl.user_id  = :id", nativeQuery = true)
    ClientInformation finByIdClient(Long id);
}
