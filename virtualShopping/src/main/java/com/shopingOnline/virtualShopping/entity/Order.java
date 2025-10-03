package com.shopingOnline.virtualShopping.entity;

import com.shopingOnline.virtualShopping.enums.OrderStatus;

import java.util.Date;
import java.util.Timer;

public class Order {
    private Long id;
    private Date date;
    private Timer hours;
    private Client client;
    private ItemOrder items;
    private ClientAdress adressClient;
    private Payment paymentType;
    private OrderStatus status;

    public Order(Long id, Date date, Timer hours, Client client, ItemOrder items, ClientAdress adressClient, Payment paymentType, OrderStatus status) {
        this.id = id;
        this.date = date;
        this.hours = hours;
        this.client = client;
        this.items = items;
        this.adressClient = adressClient;
        this.paymentType = paymentType;
        this.status = status;
    }

    public Order() {
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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Timer getHours() {
        return hours;
    }

    public void setHours(Timer hours) {
        this.hours = hours;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
}
