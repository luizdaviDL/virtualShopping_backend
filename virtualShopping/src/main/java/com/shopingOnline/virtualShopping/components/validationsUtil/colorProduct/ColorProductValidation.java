package com.shopingOnline.virtualShopping.components.validationsUtil.colorProduct;

import com.shopingOnline.virtualShopping.components.exceptions.BusinessException;
import com.shopingOnline.virtualShopping.components.serializer.ColorProductSave;
import com.shopingOnline.virtualShopping.entity.ColorProduct;
import com.shopingOnline.virtualShopping.entity.Order;
import com.shopingOnline.virtualShopping.repository.ColorProductRepository;
import com.shopingOnline.virtualShopping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ColorProductValidation {
    @Autowired
    private ColorProductRepository repository;

    public  void validateColorExist(List<ColorProductSave> data){
        for(ColorProductSave i: data){
            Optional<ColorProduct> color = Optional.ofNullable(repository.findByName(i.getName()));
            if(color.isPresent()){
                throw new BusinessException("this color already exist in the data base" + i.getName() );
            }
        }

    }
}
