package com.shopingOnline.virtualShopping.entity;

import com.shopingOnline.virtualShopping.components.serializer.ItemOrderSave;
import com.shopingOnline.virtualShopping.enums.OrderStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @Column(name = "hours")
    private LocalTime hours;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemOrder> items;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "client_address_id")
    private ClientAdress adressClient;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment paymentType;
    private OrderStatus statusPayment;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private Double totalPrice;

    public Order() {}

    public Order(
                 Client client, ClientAdress adressClient, OrderStatus status, OrderStatus statusPayment, Double totalPrice) {
        this.date = java.sql.Date.valueOf(LocalDate.now());
        this.hours = LocalTime.now();
        this.client = client;
        this.adressClient = adressClient;
        this.status = status;
        this.statusPayment = statusPayment;
        this.totalPrice = totalPrice;
    }

    // Getters e setters

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

    public List<ItemOrder> getItems() {
        return items;
    }

    public void setItems(List<ItemOrder> items) {
        this.items = items;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public OrderStatus getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(OrderStatus statusPayment) {
        this.statusPayment = statusPayment;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
