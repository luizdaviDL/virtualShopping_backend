package com.shopingOnline.virtualShopping.entity;

import org.apache.catalina.User;

import java.util.List;

public class ItemOrder {
    private Long id;
    private List<Product> product;
    private User user;
    private int quantity;
    private Double totalPrice;
    private Double freight; //frete

    public ItemOrder(Long id, List<Product> product, User user, int quantity, Double totalPrice, Double freight) {
        this.id = id;
        this.product = product;
        this.user = user;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.freight = freight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }
}
