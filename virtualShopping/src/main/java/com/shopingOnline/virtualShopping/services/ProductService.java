package com.shopingOnline.virtualShopping.services;

import com.shopingOnline.virtualShopping.components.dtos.CategoryDto;
import com.shopingOnline.virtualShopping.components.dtos.ColorsDto;
import com.shopingOnline.virtualShopping.components.validationsUtil.category.CategoryValidationUtil;
import com.shopingOnline.virtualShopping.components.validationsUtil.colorProduct.ColorProductValidation;
import com.shopingOnline.virtualShopping.components.validationsUtil.products.ValidationUtil;
import com.shopingOnline.virtualShopping.components.dtos.ProductDto;
import com.shopingOnline.virtualShopping.components.product.Components;
import com.shopingOnline.virtualShopping.components.serializer.ProductSave;
import com.shopingOnline.virtualShopping.entity.Category;
import com.shopingOnline.virtualShopping.entity.ColorProduct;
import com.shopingOnline.virtualShopping.entity.Product;
import com.shopingOnline.virtualShopping.repository.CategoryRepository;
import com.shopingOnline.virtualShopping.repository.ColorProductRepository;
import com.shopingOnline.virtualShopping.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private ColorProductValidation validationColor;
    @Autowired
    private ColorProductRepository colorRepository;

    public ProductDto saveProduct(ProductSave data) {
        List<ColorsDto> colors = new ArrayList<>();

        ValidationUtil.validateProductExist(repository, data.getName());
        CategoryValidationUtil.validateCategoryExistById(cateRepository, data.getCategory());
        validationColor.validateColorsExist(data.getColores());

        List<ColorProduct> colorEntities = colorRepository.findAllById(data.getColores());

        Optional<Category> categoryValue = cateRepository.findById(data.getCategory());
        Product productInstance = new Product(data, categoryValue.get(),colorEntities);
        Product saved = repository.save(productInstance);

        Optional<Category> getCategory = cateRepository.findById(data.getCategory());
        CategoryDto category = mappper.map(getCategory, CategoryDto.class);

        for(ColorProduct i : saved.getColores()){
            colors.add(mappper.map(i, ColorsDto.class));
        }
        return new ProductDto(saved, category, colors);
    }

    public ProductDto update(ProductSave data){
        ValidationUtil.validateProductExistById(repository, data.getId());
        CategoryValidationUtil.validateCategoryExistById(cateRepository, data.getCategory());
        validationColor.validateColorsExist(data.getColores());

        Category existingCategory = cateRepository.findById(data.getCategory()).get();
        Product existingProduct = repository.findById(data.getId()).get();
        List<ColorProduct> colorEntities = colorRepository.findAllById(data.getColores());


        existingProduct.setName(data.getName());
        existingProduct.setDescripion(data.getDescripion());
        existingProduct.setPrice(data.getPrice());
        existingProduct.setStock(data.getStock());
        existingProduct.setColores(colorEntities);
        existingProduct.setSize(data.getSize());
        existingProduct.setUrlsImage(data.getUrlsImage());
        existingProduct.setCategory(existingCategory);

        //Product productInstance = new Product(data, existingCategory);
        Product save = repository.save(existingProduct);
        return mappper.map(save, ProductDto.class);
    }

    public List<ProductDto> delete(ProductSave data){
        ValidationUtil.validateProductExistById(repository, data.getId());
        Product productInstance = mappper.map(data, Product.class);
        repository.deleteById(productInstance.getId());

        return getAllProducts();
    }

    public List<ProductDto> getAllProducts(){
        List<Product> getProducts = repository.findAll();
        return component.listDtoProduct(getProducts);
    }

}
