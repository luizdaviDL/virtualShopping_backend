package com.shopingOnline.virtualShopping.entity;

public class ItemOrder {
    private Long id;
    private Product product;
    private int quantity;
    private Double unicPrice;

    public ItemOrder(Long id, Product product, int quantity, Double unicPrice) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.unicPrice = unicPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getUnicPrice() {
        return unicPrice;
    }

    public void setUnicPrice(Double unicPrice) {
        this.unicPrice = unicPrice;
    }
}
