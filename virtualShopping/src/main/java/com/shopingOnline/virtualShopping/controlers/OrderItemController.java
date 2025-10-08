package com.shopingOnline.virtualShopping.controlers;

import com.shopingOnline.virtualShopping.components.dtos.OrderItemDto;
import com.shopingOnline.virtualShopping.components.serializer.OrederSave;
import com.shopingOnline.virtualShopping.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderItemController {
    @Autowired
    private OrderService service;

    public OrderItemDto save(@RequestBody OrederSave data){
        return service.save(data);
    }
}
