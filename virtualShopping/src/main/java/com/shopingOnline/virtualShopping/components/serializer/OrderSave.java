package com.shopingOnline.virtualShopping.components.serializer;

import com.shopingOnline.virtualShopping.entity.*;
import com.shopingOnline.virtualShopping.enums.PaymentStatus;

import java.util.Collections;
import java.util.List;

public class OrderSave {
    private Long id;
    private List<ItemOrder> items;
    private Client user;
    private List<Double> totalPrice;
    private Double freight; //frete
    private Long adress;

    public OrderSave() {
    }

    public OrderSave(Long id, List<ItemOrder> items, Client user, List<Double> totalPrice, Double freight, Long adress) {
        this.id = id;
        this.items = items;
        this.user = user;
        this.totalPrice = totalPrice;
        this.freight = freight;
        this.adress = adress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemOrder> getItems() {
        return items;
    }

    public void setItems(List<ItemOrder> items) {
        this.items = items;
    }

    public Client getUser() {
        return user;
    }

    public void setUser(Client user) {
        this.user = user;
    }

    public List<Double> getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(List<Double> totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public Long getAdress() {
        return adress;
    }

    public void setAdress(Long adress) {
        this.adress = adress;
    }
}
