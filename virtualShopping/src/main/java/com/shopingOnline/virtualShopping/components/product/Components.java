package com.shopingOnline.virtualShopping.components.product;

import com.shopingOnline.virtualShopping.components.dtos.CategoryDto;
import com.shopingOnline.virtualShopping.components.dtos.ProductDto;
import com.shopingOnline.virtualShopping.entity.ItemOrder;
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

    public List<ProductDto> listDtoProductItems(List<ItemOrder> data){
        List<ProductDto> list = new ArrayList<>();

        for(ItemOrder i:  data){
            Product product = i.getProduct();
            CategoryDto dtoCategory = mapper.map(product.getCategory(), CategoryDto.class);
            ProductDto dto = new ProductDto(product, dtoCategory);
            list.add(dto);
        }
        return list;
    }

}
