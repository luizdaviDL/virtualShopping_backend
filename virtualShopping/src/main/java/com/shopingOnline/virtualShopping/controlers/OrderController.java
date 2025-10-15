package com.shopingOnline.virtualShopping.controlers;

import com.shopingOnline.virtualShopping.components.dtos.OrderDto;
import com.shopingOnline.virtualShopping.components.serializer.OrderSave;
import com.shopingOnline.virtualShopping.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping(value="/save")
    public OrderDto save(@RequestBody OrderSave data){
        return service.save(data);
    }

    @GetMapping(value="/getAll")
    public List<OrderDto> getAll(){
        return service.getAll();
    }
}
