package com.shopingOnline.virtualShopping.components.order;

import com.shopingOnline.virtualShopping.components.client.ClientComponents;
import com.shopingOnline.virtualShopping.components.dtos.*;
import com.shopingOnline.virtualShopping.components.product.Components;
import com.shopingOnline.virtualShopping.entity.ItemOrder;
import com.shopingOnline.virtualShopping.entity.Order;
import com.shopingOnline.virtualShopping.entity.Product;
import com.shopingOnline.virtualShopping.repository.ItemOrderRepository;
import com.shopingOnline.virtualShopping.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderComponent {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ItemOrderRepository repository;
    @Autowired
    private Components productComponet;
    @Autowired
    private ClientComponents clientComponents;


    public OrderDto orderDto(Order data){
        List<OrderItemDto> items = new ArrayList<>();

        for(ItemOrder i: data.getItems()){
            Product product = i.getProduct();
            CategoryDto category = mapper.map(product.getCategory(), CategoryDto.class);
            items.add(new OrderItemDto(product, i,category));
        }
        OrderDto dto =  mapper.map(data, OrderDto.class);
        dto.setItems(items);
        return dto;
    }

    public OrderDto list_OrderItemDto(Order data){
        ArrayList<OrderItemDto> itemDto = new ArrayList<>();
        ClientDto client = null;
        ClientAdressDto adress = null;

        client = clientComponents.clientDto(data.getClient());
        for(ItemOrder da: data.getItems()){
            itemDto.add(mapper.map(da, OrderItemDto.class));
        }
        adress = clientComponents.adressDto(data.getAdressClient());
        return new OrderDto(client, adress,itemDto, data.getStatus());
    }
}
