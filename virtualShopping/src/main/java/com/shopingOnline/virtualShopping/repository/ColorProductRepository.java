package com.shopingOnline.virtualShopping.repository;

import com.shopingOnline.virtualShopping.entity.ColorProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorProductRepository extends JpaRepository<ColorProduct, Long> {
    ColorProduct findByName(String name);
}
