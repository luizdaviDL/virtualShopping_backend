package com.shopingOnline.virtualShopping.repository;

import com.shopingOnline.virtualShopping.entity.ItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrder, Long> {
}
