package com.shopingOnline.virtualShopping.entity;

public class ProductImage {
    private Long id;
    private String url;   // exemplo: "https://cdn.minhaloja.com/produtos/123_1.jpg"
    private int orderImg;
    private Product produt;

    public ProductImage(Long id, String url, int orderImg, Product produt) {
        this.id = id;
        this.url = url;
        this.orderImg = orderImg;
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

    public int getOrderImg() {
        return orderImg;
    }

    public void setOrderImg(int orderImg) {
        this.orderImg = orderImg;
    }

    public Product getProdut() {
        return produt;
    }

    public void setProdut(Product produt) {
        this.produt = produt;
    }
}
