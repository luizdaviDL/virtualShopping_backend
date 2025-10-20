package com.shopingOnline.virtualShopping.entity;

import com.shopingOnline.virtualShopping.components.serializer.ProductSave;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private BigDecimal price;
    private int stock;
    @ManyToMany
    @JoinTable(name = "product_colors",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "color_id")
    )
    private List<ColorProduct> colores;
    @ElementCollection
    @CollectionTable(name = "product_sizes", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "size")
    private List<String> size;
    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;
    @ElementCollection
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "url")
    private List<String> urlsImage;
    private LocalDateTime createAt;

    public Product(Long id, String name, String descripion, BigDecimal price, int stock, List<ColorProduct> colores, List<String> size, Category category, List<String> urlsImage) {
        this.id = id;
        this.name = name;
        this.descripion = descripion;
        this.price = price;
        this.stock = stock;
        this.colores = colores;
        this.size = size;
        this.category = category;
        this.urlsImage = urlsImage;
        this.createAt = LocalDateTime.now();
    }

    public Product() {
    }

    public Product(ProductSave data, Category category, List<ColorProduct> colores) {
        this.id = data.getId();
        this.name = data.getName();
        this.descripion = data.getDescripion();
        this.price = data.getPrice();
        this.stock = data.getStock();
        this.colores = colores;
        this.size = data.getSize();
        this.urlsImage = data.getUrlsImage();
        this.category = category;
        this.createAt = LocalDateTime.now();
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<ColorProduct> getColores() {
        return colores;
    }

    public void setColores(List<ColorProduct> colores) {
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

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
