package com.shopingOnline.virtualShopping.repository;

import com.shopingOnline.virtualShopping.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
