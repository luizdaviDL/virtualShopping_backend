package com.shopingOnline.virtualShopping.entity;

import com.shopingOnline.virtualShopping.components.serializer.ProductSave;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;

@Table(name = "product")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String descripion;
    private double price;
    private int stock;
    @ElementCollection
    @CollectionTable(name = "product_colors", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "color")
    private List<String> colores;
    @ElementCollection
    @CollectionTable(name = "product_sizes", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "size")
    private List<String> size;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category")
    private Category category;
    @ElementCollection
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "url")
    private List<String> urlsImage;

    public Product(Long id, String name, String descripion, double price, int stock, List<String> colores, List<String> size, Category category, List<String> urlsImage) {
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

    public Product() {
    }

    public Product(ProductSave data, Category category) {
        this.id = data.getId();
        this.name = data.getName();
        this.descripion = data.getDescripion();
        this.price = data.getPrice();
        this.stock = data.getStock();
        this.colores = data.getColores();
        this.size = data.getSize();
        this.urlsImage = data.getUrlsImage();
        this.category = category;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public List<String> getUrlsImage() {
        return urlsImage;
    }

    public void setUrlsImage(List<String> urlsImage) {
        this.urlsImage = urlsImage;
    }
}
