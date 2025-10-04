package com.shopingOnline.virtualShopping.controlers;

import com.shopingOnline.virtualShopping.components.dtos.CategoryDto;
import com.shopingOnline.virtualShopping.components.serializer.CategorySave;
import com.shopingOnline.virtualShopping.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @PostMapping("/save")
    public CategoryDto save(@RequestBody CategorySave data){
        return service.save(data);
    }

    @DeleteMapping("/delete")
    public List<CategoryDto> delete(@RequestBody CategorySave data){
        return service.delete(data);
    }

    @GetMapping("/getAll")
    public List<CategoryDto> getAll(){
        return service.getAll();
    }
}
