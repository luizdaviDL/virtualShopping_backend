package com.shopingOnline.virtualShopping.repository;

import com.shopingOnline.virtualShopping.entity.Client;
import com.shopingOnline.virtualShopping.entity.ItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrder, Long> {
    @Query(value="select ord.* , p.name as product_name\n" +
            "from item_order as ord\n" +
            "join product as p on ord.product_id = p.id\n" +
            "where order_id = :id", nativeQuery = true)
    List<ItemOrder> findByProduct(Long id);

    @Query(value = "select cli.* \n" +
            "from client as cli \n" +
            "join orders as ord on ord.id = :id", nativeQuery = true)
    Client finByClient(Long id);
}
