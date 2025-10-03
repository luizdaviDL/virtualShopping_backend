package com.shopingOnline.virtualShopping.services;

import com.shopingOnline.virtualShopping.components.BusinessException;
import com.shopingOnline.virtualShopping.components.dtos.ProductDto;
import com.shopingOnline.virtualShopping.components.serializer.ProductSave;
import com.shopingOnline.virtualShopping.entity.Category;
import com.shopingOnline.virtualShopping.entity.Product;
import com.shopingOnline.virtualShopping.repository.CategoryRepository;
import com.shopingOnline.virtualShopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private CategoryRepository cateRepository;

    public ProductDto saveProduct(ProductSave data) {
        Optional<Product> findName = repository.findProductName(data.getName());
        Optional<Category> findCategory = cateRepository.findById(data.getCategory());
        if (findName.isEmpty()) {
            throw new BusinessException(
                    "Product already exists in the database: " + data.getName()
            );
        }
        if(findCategory.isEmpty()){
            throw new BusinessException(
                    "category not exists in the database: " + data.getCategory()
            );
        }

        Product productInstance = new Product();
        productInstance.setName(data.getName());
        productInstance.setStock(data.getStock());
        productInstance.setColores(data.getColores());
        productInstance.setSize(data.getSize());
        productInstance.setCategory(findCategory.get());

        Product saved = repository.save(productInstance);

        return new ProductDto(saved);
    }
}
