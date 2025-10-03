package com.shopingOnline.virtualShopping.controlers;

import com.shopingOnline.virtualShopping.components.dtos.ProductDto;
import com.shopingOnline.virtualShopping.components.serializer.ProductSave;
import com.shopingOnline.virtualShopping.entity.Product;
import com.shopingOnline.virtualShopping.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService service;
    @PostMapping("/save")
    public ProductDto save(@RequestBody ProductSave data){
        return service.saveProduct(data);
    }
}
