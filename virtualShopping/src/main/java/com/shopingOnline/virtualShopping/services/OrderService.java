package com.shopingOnline.virtualShopping.services;

import com.shopingOnline.virtualShopping.components.dtos.OrderItemDto;
import com.shopingOnline.virtualShopping.components.serializer.OrederSave;
import com.shopingOnline.virtualShopping.entity.ItemOrder;
import com.shopingOnline.virtualShopping.repository.OrderRepository;
import com.shopingOnline.virtualShopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    @Autowired
    private ProductRepository productRepository;

    public OrderItemDto save(OrederSave data) {
        //verificar se tem relamente pedidos
        //se itens pedidos estão em estoque
        //valdar preço atual
        //se pagamento foi confirmado
        //limit de credito(
        //descontos
        //ItemOrder item  productRepository

    }
}
