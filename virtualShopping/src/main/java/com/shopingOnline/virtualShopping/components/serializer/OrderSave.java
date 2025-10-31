package com.shopingOnline.virtualShopping.components.serializer;

import com.shopingOnline.virtualShopping.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.List;

public class OrderSave {
    private Long id;
    private OrderStatus status;
    private Long user;
    private List<ItemOrderSave> items;
    private BigDecimal totalPrice;
    private BigDecimal freight; //frete
    private Long adress;
    private int quantity;
    private Long color;
    private String device;

    public OrderSave() {
    }

    public OrderSave(Long id, Long user, List<ItemOrderSave> items, BigDecimal totalPrice, BigDecimal freight, Long adress, int quantity, Long color, String device) {
        this.id = id;
        this.user = user;
        this.items = items;
        this.totalPrice = totalPrice;
        this.freight = freight;
        this.adress = adress;
        this.quantity = quantity;
        this.color = color;
        this.device = device;
    }

    public OrderSave(Long id, Long user, List<ItemOrderSave> items, BigDecimal totalPrice, BigDecimal freight, Long adress, int quantity, Long color) {
        this.id = id;
        this.user = user;
        this.items = items;
        this.totalPrice = totalPrice;
        this.freight = freight;
        this.adress = adress;
        this.quantity = quantity;
        this.color = color;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getColor() {
        return color;
    }

    public void setColor(Long color) {
        this.color = color;
    }

    public void setItems(List<ItemOrderSave> items) {
        this.items = items;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public Long getAdress() {
        return adress;
    }

    public void setAdress(Long adress) {
        this.adress = adress;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }
}
