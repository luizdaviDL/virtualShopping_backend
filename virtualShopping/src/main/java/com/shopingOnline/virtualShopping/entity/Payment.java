package com.shopingOnline.virtualShopping.entity;

import java.util.Date;

public class Payment {
    private Long id;
    private Client client;
    private String type;
    private boolean status;
    private double value;

    public Payment(Long id, Client client, String type, boolean status, double value) {
        this.id = id;
        this.client = client;
        this.type = type;
        this.status = status;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
