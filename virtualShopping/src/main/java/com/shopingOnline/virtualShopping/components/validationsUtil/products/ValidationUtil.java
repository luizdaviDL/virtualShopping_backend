package com.shopingOnline.virtualShopping.components.validationsUtil.products;

import com.shopingOnline.virtualShopping.components.exceptions.BusinessException;
import com.shopingOnline.virtualShopping.entity.Category;
import com.shopingOnline.virtualShopping.entity.Product;
import com.shopingOnline.virtualShopping.repository.CategoryRepository;
import com.shopingOnline.virtualShopping.repository.ProductRepository;

import java.util.Optional;

public class ValidationUtil {

    public static void validateProductExist(ProductRepository repository, String productName){
        Optional<Product> findName = repository.findByName(productName);
        if(findName.isPresent()){
            throw new BusinessException("Product already exists in the database: " + productName);
        }
    }

    public static void validateProductNotExist(ProductRepository repository, String productName){
        Optional<Product> findName = repository.findByName(productName);
        if(findName.isEmpty()){
            throw new BusinessException("Product not exists in the database: " + productName);
        }
    }

    public static void validateProductExistById(ProductRepository repository, Long id){
        Optional<Product> findCatedory = repository.findById(id);
        if (findCatedory.isEmpty()){
            throw new BusinessException("Product does not exist in the database: " + id);
        }
    }


}
