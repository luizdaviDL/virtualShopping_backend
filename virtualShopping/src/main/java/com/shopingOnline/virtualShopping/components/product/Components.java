package com.shopingOnline.virtualShopping.components.product;

import com.shopingOnline.virtualShopping.components.dtos.CategoryDto;
import com.shopingOnline.virtualShopping.components.dtos.ProductDto;
import com.shopingOnline.virtualShopping.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class Components {

    @Autowired
    private ModelMapper mapper;

    public List<ProductDto> listDtoProduct(List<Product> data){
        List<ProductDto> list = new ArrayList<>();
        for(Product i:  data){
            CategoryDto dtoCategory = mapper.map(i.getCategory(), CategoryDto.class);
            ProductDto dto = new ProductDto(i, dtoCategory);
            list.add(dto);
        }
        return list;
    }
}
