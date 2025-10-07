package com.shopingOnline.virtualShopping.controlers;

import com.shopingOnline.virtualShopping.components.dtos.ClientAdressDto;
import com.shopingOnline.virtualShopping.components.serializer.ClientAdressSave;
import com.shopingOnline.virtualShopping.services.ClientAdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientAdress")
public class ClientAdressController {

    @Autowired
    private ClientAdressService service;

    @PostMapping(value = "/save")
    public ClientAdressDto save(@RequestBody ClientAdressSave data){
        return service.save(data);
    }

    @GetMapping(value = "/getAll")
    public List<ClientAdressDto> getAll(){
        return service.getAll();
    }
}
