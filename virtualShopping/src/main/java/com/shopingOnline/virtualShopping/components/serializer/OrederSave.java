package com.shopingOnline.virtualShopping.components.serializer;

import com.shopingOnline.virtualShopping.entity.ClientAdress;
import com.shopingOnline.virtualShopping.entity.ItemOrder;
import com.shopingOnline.virtualShopping.entity.Payment;
import com.shopingOnline.virtualShopping.enums.OrderStatus;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Date;

public class OrederSave {
    private Long id;
    private Date date;
    private LocalTime hours;
    private ItemOrder items;
    private ClientAdress adressClient;
    private Payment paymentType;
    private OrderStatus status;

    public OrederSave(Long id, Date date, LocalTime hours, ItemOrder items, ClientAdress adressClient, Payment paymentType, OrderStatus status) {
        this.id = id;
        this.date = date;
        this.hours = hours;
        this.items = items;
        this.adressClient = adressClient;
        this.paymentType = paymentType;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalTime getHours() {
        return hours;
    }

    public void setHours(LocalTime hours) {
        this.hours = hours;
    }

    public ItemOrder getItems() {
        return items;
    }

    public void setItems(ItemOrder items) {
        this.items = items;
    }

    public ClientAdress getAdressClient() {
        return adressClient;
    }

    public void setAdressClient(ClientAdress adressClient) {
        this.adressClient = adressClient;
    }

    public Payment getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Payment paymentType) {
        this.paymentType = paymentType;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OrederSave() {
    }
}
