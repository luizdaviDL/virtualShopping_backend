package com.shopingOnline.virtualShopping.components.dtos;

import com.shopingOnline.virtualShopping.entity.Category;
import com.shopingOnline.virtualShopping.entity.ColorProduct;
import com.shopingOnline.virtualShopping.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private List<String> images;
    private int stock;
    private List<ColorsDto> colors;
    private List<String> size;
    private String description;
    private CategoryDto category;

    public ProductDto(Long id, String name, BigDecimal price, List<String> images, int stock, List<ColorsDto> colors, List<String> size, String description, CategoryDto category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.images = images;
        this.stock = stock;
        this.colors = colors;
        this.size = size;
        this.description = description;
        this.category = category;
    }

    public ProductDto() {
    }

    public ProductDto(Product i, CategoryDto dtoCategory, List<ColorsDto> color) {
        this.id = i.getId();
        this.name = i.getName();
        this.price = i.getPrice();
        this.images = i.getUrlsImage();
        this.stock = i.getStock();
        this.colors = color;
        this.size = i.getSize();
        this.category = dtoCategory;
        this.description = i.getDescripion();
        this.category = dtoCategory;
    }

    public ProductDto(Product i, CategoryDto dtoCategory) {
        this.id = i.getId();
        this.name = i.getName();
        this.price = i.getPrice();
        this.images = i.getUrlsImage();
        this.stock = i.getStock();
        this.size = i.getSize();
        this.category = dtoCategory;
        this.description = i.getDescripion();
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<ColorsDto> getColors() {
        return colors;
    }

    public void setColors(List<ColorsDto> colors) {
        this.colors = colors;
    }

    public List<String> getSize() {
        return size;
    }

    public void setSize(List<String> size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }
}
