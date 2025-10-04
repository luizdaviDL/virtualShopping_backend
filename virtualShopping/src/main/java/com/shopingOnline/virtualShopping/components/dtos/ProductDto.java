package com.shopingOnline.virtualShopping.components.dtos;

import com.shopingOnline.virtualShopping.entity.Category;
import com.shopingOnline.virtualShopping.entity.Product;

import java.util.List;

public class ProductDto {
    private Long id;
    private String name;
    private int stock;
    private List<String> colores;
    private List<String> size;
    private CategoryDto category;

    public ProductDto(Long id, String name, int stock, List<String> colores, List<String> size, CategoryDto category) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.colores = colores;
        this.size = size;
        this.category = category;
    }

    public ProductDto() {
    }

    public ProductDto(Product i, CategoryDto dtoCategory) {
        this.id = i.getId();
        this.name = i.getName();
        this.stock = i.getStock();
        this.colores = i.getColores();
        this.size = i.getSize();
        this.category = dtoCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<String> getColores() {
        return colores;
    }

    public void setColores(List<String> colores) {
        this.colores = colores;
    }

    public List<String> getSize() {
        return size;
    }

    public void setSize(List<String> size) {
        this.size = size;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }
}
