package com.shopingOnline.virtualShopping.components.dtos;

import com.shopingOnline.virtualShopping.entity.*;
import com.shopingOnline.virtualShopping.enums.OrderStatus;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDto {
    private Long id;
    private Date date;
    private LocalTime hours;
    private ClientDto client;
    private List<OrderItemDto> items;
    private ClientAdressDto adressClient;
    private OrderStatus status;

    public OrderDto(Long id, Date date, LocalTime hours, ClientDto client, ClientAdressDto adressClient, OrderStatus status) {
        this.id = id;
        this.date = date;
        this.hours = hours;
        this.client = client;
        this.adressClient = adressClient;
        this.status = status;
    }

    public OrderDto() {
    }


    public OrderDto(ClientDto client, ClientAdressDto adress, ArrayList<OrderItemDto> itemDto, OrderStatus status) {
        this.client = client;
        this.adressClient = adress;
        this.items = itemDto;
        this.date = new Date();
        this.hours = LocalTime.now();
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
}
