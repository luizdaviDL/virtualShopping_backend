package com.shopingOnline.virtualShopping.components.dtos;

import com.shopingOnline.virtualShopping.entity.*;
import com.shopingOnline.virtualShopping.enums.OrderStatus;
import com.shopingOnline.virtualShopping.enums.PaymentStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDto {
    private Long id;
    private LocalDate date;
    private LocalTime hours;
    private ClientDto client;
    private List<OrderItemDto> items;
    private ClientAdressDto adressClient;
    private OrderStatus status;
    private BigDecimal totalPrice;
    private PaymentStatus statusPayment;

    public OrderDto(Long id, LocalDate date, LocalTime hours, ClientDto client, ClientAdressDto adressClient, OrderStatus status,BigDecimal totalPrice,PaymentStatus statusPayment) {
        this.id = id;
        this.date = date;
        this.hours = hours;
        this.client = client;
        this.adressClient = adressClient;
        this.status = status;
        this.totalPrice = totalPrice;
        this.statusPayment = statusPayment;
    }

    public OrderDto() {
    }


    public OrderDto(ClientDto client, ClientAdressDto adress, ArrayList<OrderItemDto> itemDto, OrderStatus status,BigDecimal totalPrice) {
        this.client = client;
        this.adressClient = adress;
        this.items = itemDto;
        //this.date = new Date();
        this.hours = LocalTime.now();
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHours() {
        return hours;
    }

    public void setHours(LocalTime hours) {
        this.hours = hours;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }

    public ClientAdressDto getAdressClient() {
        return adressClient;
    }

    public void setAdressClient(ClientAdressDto adressClient) {
        this.adressClient = adressClient;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public PaymentStatus getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(PaymentStatus statusPayment) {
        this.statusPayment = statusPayment;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
