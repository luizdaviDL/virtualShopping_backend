package com.shopingOnline.virtualShopping.controlers;

import com.shopingOnline.virtualShopping.components.dtos.ColorsDto;
import com.shopingOnline.virtualShopping.components.serializer.ColorProductSave;
import com.shopingOnline.virtualShopping.repository.ColorProductRepository;
import com.shopingOnline.virtualShopping.services.ColorProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/colors")
public class ColorProductController {
    @Autowired
    private ColorProductService service;

    public ColorsDto save(@RequestBody ColorProductSave data){
        return  service.save(data);
    }


}
