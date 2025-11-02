package com.shopingOnline.virtualShopping.controlers;

import com.shopingOnline.virtualShopping.components.dtos.PaymentDto;
import com.shopingOnline.virtualShopping.components.serializer.PaymentSave;
import com.shopingOnline.virtualShopping.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    public PaymentDto save(@RequestBody PaymentSave data){
        return service.save(data);
    }
}
