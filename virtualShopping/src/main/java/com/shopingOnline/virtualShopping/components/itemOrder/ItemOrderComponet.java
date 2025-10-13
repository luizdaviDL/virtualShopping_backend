package com.shopingOnline.virtualShopping.components.itemOrder;

import com.shopingOnline.virtualShopping.components.client.ClientComponents;
import com.shopingOnline.virtualShopping.components.dtos.*;
import com.shopingOnline.virtualShopping.components.order.OrderComponent;
import com.shopingOnline.virtualShopping.components.product.Components;
import com.shopingOnline.virtualShopping.components.serializer.ItemOrderSave;
import com.shopingOnline.virtualShopping.components.serializer.OrderSave;
import com.shopingOnline.virtualShopping.entity.ItemOrder;
import com.shopingOnline.virtualShopping.entity.Order;
import com.shopingOnline.virtualShopping.entity.Product;
import com.shopingOnline.virtualShopping.repository.ItemOrderRepository;
import com.shopingOnline.virtualShopping.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemOrderComponet {
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

    public List<ItemOrder> ItemOrderSave_to_ItemOrders(List<ItemOrderSave> data){
        List<ItemOrder> list = new ArrayList<>();
        for(ItemOrderSave i: data){
            Product product = productRepository.findById(i.getProductId()).get();
            ItemOrder instance = new ItemOrder(i);
            instance.setProduct(product);
            ItemOrder item = repository.save(instance);
            list.add(item);
        }
        return list;
    }


}
