package com.shopingOnline.virtualShopping.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;   // exemplo: "https://cdn.minhaloja.com/produtos/123_1.jpg"
    @ManyToOne
    @JoinColumn(name = "product")
    private Product produt;

    public ProductImage(Long id, String url, Product produt) {
        this.id = id;
        this.url = url;
        this.produt = produt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Product getProdut() {
        return produt;
    }

    public void setProdut(Product produt) {
        this.produt = produt;
    }
}
