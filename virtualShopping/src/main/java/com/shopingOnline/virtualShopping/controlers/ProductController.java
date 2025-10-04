package com.shopingOnline.virtualShopping.controlers;

import com.shopingOnline.virtualShopping.components.dtos.ProductDto;
import com.shopingOnline.virtualShopping.components.serializer.ProductSave;
import com.shopingOnline.virtualShopping.entity.Product;
import com.shopingOnline.virtualShopping.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService service;
    @PostMapping("/save")
    public ProductDto save(@RequestBody ProductSave data){
        return service.saveProduct(data);
    }

    @PutMapping("/update")
    public ProductDto update(@RequestBody ProductSave data){
        return service.update(data);
    }
    @DeleteMapping("/delete")
    public List<ProductDto> delete(@RequestBody ProductSave data){
        return service.delete(data);
    }

    @GetMapping("/products")
    public List<ProductDto> getAll(){
        return service.getAllProducts();
    }

}
