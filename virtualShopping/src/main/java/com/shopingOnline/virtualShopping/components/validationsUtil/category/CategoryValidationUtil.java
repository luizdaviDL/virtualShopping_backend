package com.shopingOnline.virtualShopping.components.validationsUtil.category;

import com.shopingOnline.virtualShopping.components.exceptions.BusinessException;
import com.shopingOnline.virtualShopping.entity.Category;
import com.shopingOnline.virtualShopping.repository.CategoryRepository;

import java.util.Optional;

public class CategoryValidationUtil {
    public static void validateCategoryExist(CategoryRepository repository, String name){
        Optional<Category> findName = repository.findByName(name);
        if(findName.isPresent()){
            throw new BusinessException("Category already exists in the database: " + name);
        }
    }

    public static void validateCategoryNotExist(CategoryRepository repository, String name){
        Optional<Category> findName = repository.findByName(name);
        if(findName.isEmpty()){
            throw new BusinessException("Category not exists in the database: " + name);
        }
    }

    public static void validateCategoryExistById(CategoryRepository repository, Long id) {
        Optional<Category> findCatedory = repository.findById(id);
        if (findCatedory.isEmpty()) {
            throw new BusinessException("Category does not exist in the database: " + id);
        }

    }
}
