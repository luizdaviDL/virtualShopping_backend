package com.shopingOnline.virtualShopping.services;

import com.shopingOnline.virtualShopping.components.categorys.CategoryComponents;
import com.shopingOnline.virtualShopping.components.dtos.CategoryDto;
import com.shopingOnline.virtualShopping.components.serializer.CategorySave;
import com.shopingOnline.virtualShopping.components.validationsUtil.category.CategoryValidationUtil;
import com.shopingOnline.virtualShopping.entity.Category;
import com.shopingOnline.virtualShopping.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private CategoryComponents components;

    public CategoryDto save(CategorySave data){
        CategoryValidationUtil.validateCategoryExist(repository, data.getName());
        Category categoryMappper = mapper.map(data, Category.class);
        Category save = repository.save(categoryMappper);
        return mapper.map(save, CategoryDto.class);
    }

    public List<CategoryDto> delete(CategorySave data) {
        CategoryValidationUtil.validateCategoryExistById(repository, data.getId());
        repository.deleteById(data.getId());
        return getAll();
    }


    public List<CategoryDto> getAll() {
        List<Category> values = repository.findAll();
        return components.listDtoCategory(values);
    }

    public CategoryDto update(CategorySave data) {
        CategoryValidationUtil.validateCategoryNotExist(repository, data.getName());
        Category getCategory = repository.findById(data.getId()).get();
        getCategory.setName(data.getName());
        getCategory.setDescription(data.getDescription());
        Category saving = repository.save(getCategory);
        return mapper.map(saving, CategoryDto.class);
        //Category instance = mapper.map(getCategory,Category.class);


    }
}
