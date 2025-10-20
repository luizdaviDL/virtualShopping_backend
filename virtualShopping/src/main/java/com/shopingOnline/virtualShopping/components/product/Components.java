package com.shopingOnline.virtualShopping.components.product;

import com.shopingOnline.virtualShopping.components.dtos.CategoryDto;
import com.shopingOnline.virtualShopping.components.dtos.ColorsDto;
import com.shopingOnline.virtualShopping.components.dtos.ProductDto;
import com.shopingOnline.virtualShopping.entity.ColorProduct;
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
        List<ColorsDto> colors = new ArrayList<>();

        for(Product i:  data){
            CategoryDto dtoCategory = mapper.map(i.getCategory(), CategoryDto.class);
            for(ColorProduct co: i.getColores()){
                colors.add(mapper.map(co, ColorsDto.class));
            }

            ProductDto dto = new ProductDto(i, dtoCategory,colors);
            list.add(dto);
        }
        return list;
    }

    public List<ProductDto> listDtoProductItems(List<ItemOrder> data){
        List<ProductDto> list = new ArrayList<>();
        List<ColorsDto> colors = new ArrayList<>();

        for(ItemOrder i:  data){
            Product product = i.getProduct();
            for(ColorProduct pro : product.getColores()){
                colors.add(mapper.map(pro, ColorsDto.class));
            }
            CategoryDto dtoCategory = mapper.map(product.getCategory(), CategoryDto.class);
            ProductDto dto = new ProductDto(product, dtoCategory,colors);
            list.add(dto);
        }
        return list;
    }


}
