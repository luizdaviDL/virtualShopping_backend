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

    public ProductDto patchProduct(ProductSave data) {
        Product product = repository.findById(data.getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (data.getName() != null) product.setName(data.getName());
        if (data.getDescripion() != null) product.setDescripion(data.getDescripion());
        if (data.getPrice() != null) product.setPrice(data.getPrice());
        if (data.getStock() != null) product.setStock(data.getStock());
        if (data.getSize() != null) product.setSize(data.getSize());
        if (data.getUrlsImage() != null) product.setUrlsImage(data.getUrlsImage());

        if (data.getCategory() != null) {
            Category category = cateRepository.findById(data.getCategory())
                    .orElseThrow(() -> new RuntimeException("Categoria inválida"));
            product.setCategory(category);
        }

        if (data.getColores() != null) {
            List<ColorProduct> colors = colorRepository.findAllById(data.getColores());
            product.setColores(colors);
        }

        Product saved = repository.save(product);

        CategoryDto categoryDto = mappper.map(saved.getCategory(), CategoryDto.class);
        List<ColorsDto> colorsDto = saved.getColores().stream()
                .map(c -> mappper.map(c, ColorsDto.class))
                .toList();

        return new ProductDto(saved, categoryDto, colorsDto);
    }


}
