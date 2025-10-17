package com.shopingOnline.virtualShopping.services;

import com.shopingOnline.virtualShopping.components.dtos.ColorsDto;
import com.shopingOnline.virtualShopping.components.serializer.ColorProductSave;
import com.shopingOnline.virtualShopping.components.validationsUtil.colorProduct.ColorProductValidation;
import com.shopingOnline.virtualShopping.entity.ColorProduct;
import com.shopingOnline.virtualShopping.repository.ColorProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ColorProductService {
    @Autowired
    private ColorProductRepository repository;
    @Autowired
    private ColorProductValidation validation;

    public List<ColorProduct> save(List<ColorProductSave> data) {
        List<ColorProduct> dtos= new ArrayList<>();

        validation.validateColorExist(data);
        for(ColorProductSave i: data){
            ColorProduct instance = new ColorProduct(i);
            ColorProduct save = repository.save(instance);
            dtos.add(save);
        }
        return dtos;
    }
}
