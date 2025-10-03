package com.shopingOnline.virtualShopping.repository;

import com.shopingOnline.virtualShopping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long > {
    Optional<Product> findProductName(String name);

}
