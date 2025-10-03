package com.shopingOnline.virtualShopping.entity;

import com.shopingOnline.virtualShopping.enums.ShippingStatus;

public class Shipping {
    private Long id;
    private Order order;
    private ShippingStatus status;
    private String city;
    private String state;

    public Shipping(Long id, Order order, ShippingStatus status, String city, String state) {
        this.id = id;
        this.order = order;
        this.status = status;
        this.city = city;
        this.state = state;
    }

    public void updateLocation(String city, String state, ShippingStatus status) {
        this.city = city;
        this.state = state;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ShippingStatus getStatus() {
        return status;
    }

    public void setStatus(ShippingStatus status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
