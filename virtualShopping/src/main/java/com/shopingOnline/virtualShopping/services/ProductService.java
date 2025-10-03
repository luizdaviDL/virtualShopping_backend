package com.shopingOnline.virtualShopping.services;

import com.shopingOnline.virtualShopping.components.BusinessException;
import com.shopingOnline.virtualShopping.components.ValidationUtil;
import com.shopingOnline.virtualShopping.components.dtos.ProductDto;
import com.shopingOnline.virtualShopping.components.product.Components;
import com.shopingOnline.virtualShopping.components.serializer.ProductSave;
import com.shopingOnline.virtualShopping.entity.Category;
import com.shopingOnline.virtualShopping.entity.Product;
import com.shopingOnline.virtualShopping.repository.CategoryRepository;
import com.shopingOnline.virtualShopping.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ModelMapper mappper;
    @Autowired
    private ProductRepository repository;
    @Autowired
    private CategoryRepository cateRepository;
    @Autowired
    private Components component;

    public ProductDto saveProduct(ProductSave data) {
        ValidationUtil.validateProductExist(repository, data.getName());
        ValidationUtil.validateCategoryExist(cateRepository, data.getCategory());

        Product productInstance = mappper.map(data, Product.class);
        Product saved = repository.save(productInstance);
        return mappper.map(saved, ProductDto.class);
    }

    public ProductDto update(ProductSave data){
        ValidationUtil.validateProductNotExist(repository, data.getName());
        ValidationUtil.validateCategoryExist(cateRepository, data.getCategory());
        Product productInstance = mappper.map(data, Product.class);
        Product save = repository.save(productInstance);
        return mappper.map(save, ProductDto.class);
    }

    public List<ProductDto> delete(ProductSave data){
        ValidationUtil.validateProductNotExist(repository, data.getName());
        Product productInstance = mappper.map(data, Product.class);
        repository.deleteById(productInstance.getId());

        return getAllProducts();
    }

    public List<ProductDto> getAllProducts(){
        List<Product> getProducts = repository.findAll();
        return component.listDtoProduct(getProducts);
    }

}
