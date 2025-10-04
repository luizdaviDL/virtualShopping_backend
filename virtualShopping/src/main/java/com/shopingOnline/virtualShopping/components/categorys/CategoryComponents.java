package com.shopingOnline.virtualShopping.components.categorys;

import com.shopingOnline.virtualShopping.components.dtos.CategoryDto;
import com.shopingOnline.virtualShopping.entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryComponents {
    @Autowired
    private ModelMapper mapper;
    public List<CategoryDto> listDtoCategory(List<Category> data){
        ArrayList<CategoryDto> list = new ArrayList<>();

        for(Category i: data){
            list.add(mapper.map(i, CategoryDto.class));
        }
        return list;
    }
}
