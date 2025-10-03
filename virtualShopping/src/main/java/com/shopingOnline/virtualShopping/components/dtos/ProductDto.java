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
    private Category category;

    public ProductDto(Product data) {
        this.id = data.getId();
        this.name = data.getName();
        this.stock = data.getStock();
        this.colores = data.getColores();
        this.size = data.getSize();
        this.category = data.getCategory();
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
