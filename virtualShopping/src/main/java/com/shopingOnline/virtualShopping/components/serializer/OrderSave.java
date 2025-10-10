package com.shopingOnline.virtualShopping.components.serializer;

import com.shopingOnline.virtualShopping.entity.*;
import com.shopingOnline.virtualShopping.enums.PaymentStatus;

import java.util.Collections;
import java.util.List;

public class OrderSave {
    private Long id;
    private Long user;
    private List<ItemOrderSave> items;
    private Double totalPrice;
    private Double freight; //frete
    private Long adress;

    public OrderSave() {
    }

    public OrderSave(Long id, Long user, List<ItemOrderSave> items, Double totalPrice, Double freight, Long adress) {
        this.id = id;
        this.user = user;
        this.items = items;
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

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public List<ItemOrderSave> getItems() {
        return items;
    }

    public void setItems(List<ItemOrderSave> items) {
        this.items = items;
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

    public Long getAdress() {
        return adress;
    }

    public void setAdress(Long adress) {
        this.adress = adress;
    }
}
