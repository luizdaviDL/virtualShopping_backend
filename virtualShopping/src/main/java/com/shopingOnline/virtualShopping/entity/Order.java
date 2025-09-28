package com.shopingOnline.virtualShopping.entity;

import java.util.Date;

public class Order {
    private Long id;
    private Date date;
    private boolean status;

    public Order(Long id, Date date, boolean status) {
        this.id = id;
        this.date = date;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
