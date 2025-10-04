package com.shopingOnline.virtualShopping.services;

import com.shopingOnline.virtualShopping.components.dtos.CategoryDto;
import com.shopingOnline.virtualShopping.components.serializer.CategorySave;
import com.shopingOnline.virtualShopping.components.validationsUtil.category.CategoryValidationUtil;
import com.shopingOnline.virtualShopping.entity.Category;
import com.shopingOnline.virtualShopping.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    @Autowired
    private ModelMapper mapper;

    public CategoryDto save(CategorySave data){
        CategoryValidationUtil.validateCategoryExist(repository, data.getName());
        Category categoryMappper = mapper.map(data, Category.class);
        Category save = repository.save(categoryMappper);
        return mapper.map(save, CategoryDto.class);
    }
}
