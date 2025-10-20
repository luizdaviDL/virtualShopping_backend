package com.shopingOnline.virtualShopping.controlers;

import com.shopingOnline.virtualShopping.components.dtos.ColorsDto;
import com.shopingOnline.virtualShopping.components.serializer.ColorProductSave;
import com.shopingOnline.virtualShopping.repository.ColorProductRepository;
import com.shopingOnline.virtualShopping.services.ColorProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/colors")
public class ColorProductController {
    @Autowired
    private ColorProductService service;

    @PostMapping(value = "/save")
    public ColorsDto save(@RequestBody ColorProductSave data){
        return  service.save(data);
    }

    @GetMapping("/getAll")
    public List<ColorsDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/findId")
    public ColorsDto findById(@RequestBody ColorProductSave data) {
        return service.findById(data.getId());
    }

    @PutMapping("/update")
    public ColorsDto update(@RequestBody ColorProductSave data) {
        return service.update(data);
    }

    @DeleteMapping("/delete")
    public List<ColorsDto> delete(@RequestBody ColorProductSave data) {
        service.delete(data.getId());
        return findAll();
    }

}
