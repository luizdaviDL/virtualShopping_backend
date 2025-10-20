package com.shopingOnline.virtualShopping.components.serializer;

import com.shopingOnline.virtualShopping.entity.Category;
import com.shopingOnline.virtualShopping.entity.ColorProduct;

import java.math.BigDecimal;
import java.util.List;

public class ProductSave {
    private Long id;
    private String name;
    private String descripion;
    private BigDecimal price;
    private Integer  stock;
    private List<Long> colores;
    private List<String> size;
    private Long category;
    private List<String> urlsImage;

    public ProductSave(Long id, String name, String descripion, BigDecimal price, int stock, List<Long> colores, List<String> size, Long category, List<String> urlsImage) {
        this.id = id;
        this.name = name;
        this.descripion = descripion;
        this.price = price;
        this.stock = stock;
        this.colores = colores;
        this.size = size;
        this.category = category;
        this.urlsImage = urlsImage;
    }

    public ProductSave() {
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

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public List<Long> getColores() {
        return colores;
    }

    public void setColores(List<Long> colores) {
        this.colores = colores;
    }

    public List<String> getSize() {
        return size;
    }

    public void setSize(List<String> size) {
        this.size = size;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public List<String> getUrlsImage() {
        return urlsImage;
    }

    public void setUrlsImage(List<String> urlsImage) {
        this.urlsImage = urlsImage;
    }
}
